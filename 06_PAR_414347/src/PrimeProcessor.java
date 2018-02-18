import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeProcessor implements IPrimeListener {

    public PrimeProcessor() {
        this.executorService = Executors.newFixedThreadPool(tasksCount);
        this.tasks = new ArrayList<>();
    }

    private static final int tasksCount = Runtime.getRuntime().availableProcessors();
    private ExecutorService executorService;
    private BigInteger lastPrime1;
    private BigInteger lastPrime2;
    private List<Future<BigInteger>> tasks;

    @Override
    public void primeGenerated(BigInteger nextPrime) {
        if (lastPrime1 != null && lastPrime2 != null) {
            String value = lastPrime2.toString() + lastPrime1.toString() + nextPrime.toString();

            tasks.add(executorService.submit(() -> {
                if (check(value)) {
                    return new BigInteger(value);
                }
                return null;
            }));
        }
        lastPrime2 = lastPrime1;
        lastPrime1 = nextPrime;
    }


    @Override
    public void primeGeneratorStopped() {
        System.out.println("processing remaining primes");
        TreeSet<BigInteger> results = new TreeSet<>();
        for (Future<BigInteger> task : tasks) {
            try {
                BigInteger result = task.get();
                if (result != null) {
                    results.add(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("printing " + results.size() + " results now");
        results.forEach(System.out::println);
        System.out.println("goodbye");
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
        return val.subtract(BigInteger.ONE).nextProbablePrime().equals(val);
    }
}
