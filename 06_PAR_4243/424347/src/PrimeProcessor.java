import java.math.BigInteger;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeProcessor implements IPrimeListener {

    public PrimeProcessor() {
        this.executorService = Executors.newFixedThreadPool(tasksCount);
        this.results = new TreeSet<>();
    }

    private static final int tasksCount = Runtime.getRuntime().availableProcessors();
    private ExecutorService executorService;
    private BigInteger lastPrime1;
    private BigInteger lastPrime2;
    private TreeSet<BigInteger> results;

    private synchronized void addValue(BigInteger value) {
        results.add(value);
    }

    @Override
    public void primeGenerated(BigInteger nextPrime) {
        if (lastPrime1 != null && lastPrime2 != null) {
            String value = lastPrime2.toString() + lastPrime1.toString() + nextPrime.toString();
            executorService.execute(() -> {
                if (check(value)) {
                    addValue(new BigInteger(value));
                }
            });
        } else {
            System.out.println("waiting for more primes...");
        }
        lastPrime2 = lastPrime1;
        lastPrime1 = nextPrime;

    }

    @Override
    public void primeGeneratorStopped() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        results.forEach(prime -> System.out.println(prime));
    }

    private boolean check(String input) {
        boolean isTrue = true;
        int length = input.length();
        for (int i = 1; isTrue && i < length; i++) {
            if (length % i == 0) {
                isTrue = check(input, i);
            }
        }
        return isTrue;
    }

    public static boolean check(String input, int divLength) {
        int length = input.length();
        int partsCount = length / divLength;
        long sum = 0;
        int idx = 0;
        for (int i = 0; i < partsCount; i++) {
            sum += Long.parseLong(input.substring(idx, idx += divLength));
        }
        BigInteger val = BigInteger.valueOf(sum);
        return val.isProbablePrime(Integer.MAX_VALUE);//.subtract(BigInteger.ONE).nextProbablePrime().equals(val);
        //
    }

    public static BigInteger stickTogether(BigInteger val1, BigInteger val2, BigInteger val3) {
        int val3Length = (val3).toString().length();
        int val2Length = (val2).toString().length();
        BigInteger shifted1 = val1.multiply(BigInteger.TEN.pow(val2Length + val3Length));
        BigInteger shifted2 = val2.multiply(BigInteger.TEN.pow(val3Length));
        return val3.add(shifted2).add(shifted1);
    }
}
