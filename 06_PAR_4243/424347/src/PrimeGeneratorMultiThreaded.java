import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeGeneratorMultiThreaded implements IPrimeStrategy {

    public PrimeGeneratorMultiThreaded() {
        this.primeListeners = new ArrayList<>();
        this.primeBuffer = new TreeSet<>();
        //TODO make variable
        this.executorService = Executors.newFixedThreadPool(tasksCount);
    }

    private static final int tasksCount = Runtime.getRuntime().availableProcessors();
    private static final int startExponent = 5;
    private List<IPrimeListener> primeListeners;
    private TreeSet<BlockResult> primeBuffer;
    private BigInteger nextBlockStart;

    private ExecutorService executorService;
    private Boolean running = false;

    @Override
    public void start() {
        running = true;
        startTask();
    }

    private void startTask() {
        nextBlockStart = BigInteger.ZERO;
        // TODO make variable
        for (int i = 0; i < 4; i++) {
            final int multiplier = i;
            executorService.submit(() -> generatePrimes(multiplier, tasksCount));
        }
        System.out.println("started");
    }

    private void receiveBlockResult(BlockResult result) {
        primeBuffer.add(result);
        processBlocks();
    }

    private void processBlocks() {
        for (BlockResult blockToCompare = primeBuffer.first();
             blockToCompare.getBlockStart().equals(nextBlockStart);
             blockToCompare = primeBuffer.first()) {
            processBlock(blockToCompare);
        }
    }

    private void processBlock(BlockResult block) {
        // publish primes
        block.getPrimes().forEach(this::publishPrime);
        // remove from buffer
        primeBuffer.remove(block);
        // set next block
        nextBlockStart = block.getNextBlockStart();
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
            executorService.submit(() ->
                    generatePrimes(startMultiplier + tasksCount, tasksCount));
            System.out.println("task finished:" + startMultiplier);
            return;
        }
        System.out.println(startMultiplier % tasksCount + "generator stopped");
    }

    private void publishPrime(BigInteger prime) {
        primeListeners.forEach(listener -> listener.primeGenerated(prime));
    }

    @Override
    public void stop() {
        running = false;
        primeListeners.forEach(IPrimeListener::primeGeneratorStopped);
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
