import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeGeneratorMultiThreaded implements IPrimeStrategy {

    private static final int tasksCount = Runtime.getRuntime().availableProcessors();
    private static final int startExponent = 6;
    private int taskStopCounter = tasksCount;
    private List<IPrimeListener> primeListeners;
    private TreeSet<BlockResult> primeBuffer;
    private BigInteger nextBlockStart;
    private ExecutorService executorService;
    private Boolean running = false;
    private int ctr = 0;

    public PrimeGeneratorMultiThreaded() {
        this.primeListeners = new ArrayList<>();
        this.primeBuffer = new TreeSet<>();
        this.executorService = Executors.newFixedThreadPool(tasksCount);
    }

    @Override
    public void start() {
        running = true;
        startTask();
    }

    private void startTask() {
        nextBlockStart = BigInteger.ZERO;
        for (int i = 0; i < tasksCount; i++) {
            final int multiplier = i;
            executorService.submit(() -> generatePrimes(multiplier, tasksCount));
        }
        System.out.println("started");
    }

    private synchronized void receiveBlockResult(BlockResult result) {
        primeBuffer.add(result);

        BlockResult blockToCompare = primeBuffer.first();

        for (; blockToCompare.getBlockStart().equals(nextBlockStart) && !primeBuffer.isEmpty(); ) {
            blockToCompare.getPrimes().forEach(this::publishPrime);

            primeBuffer.remove(blockToCompare);
            nextBlockStart = blockToCompare.getNextBlockStart();

            if (!primeBuffer.isEmpty()) {
                blockToCompare = primeBuffer.first();
            } else {
                break;
            }

        }


    }

    private void generatePrimes(int startMultiplier, int tasksCount) {
        BigInteger range = BigInteger.TEN.pow(startExponent);
        BigInteger startValue = range.multiply(BigInteger.valueOf(startMultiplier));
        BigInteger endValue = startValue.add(range);
        List<BigInteger> primes = new ArrayList<>();

        for (BigInteger prime = startValue.nextProbablePrime();
             prime.compareTo(endValue) < 1;
             prime = prime.nextProbablePrime()) {
            primes.add(prime);
        }

        receiveBlockResult(new BlockResult(startValue, endValue, primes));


        if (running) {
            executorService.execute(() ->
                    generatePrimes(startMultiplier + tasksCount, tasksCount));
        } else {
            System.out.println("[" + startMultiplier % tasksCount + "] generator stopped at" + endValue.toString());
            receiveStops();
        }

    }

    private synchronized void receiveStops() {
        System.out.println("stop received." + ctr++);
        if (--taskStopCounter == 0) {
            System.out.println("stop fired.");
            executorService.shutdown();
            primeListeners.forEach(IPrimeListener::primeGeneratorStopped);
        }
    }

    private void publishPrime(BigInteger prime) {
        primeListeners.forEach(listener -> listener.primeGenerated(prime));
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public void addListener(IPrimeListener listener) {
        primeListeners.add(listener);
    }

    @Override
    public void removeListener(IPrimeListener listener) {
        primeListeners.remove(listener);
    }
}
