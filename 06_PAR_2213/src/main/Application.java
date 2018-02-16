package main;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Application {
    static BigInteger bigInt = BigInteger.ONE;
    static List<Long> results = new ArrayList<>();

    public static long nextPrime() {
        bigInt = bigInt.nextProbablePrime();
        return bigInt.longValue();
    }


    public static void main(String[] args) {
        int maxThreads = Runtime.getRuntime().availableProcessors();

        System.out.println("The next number is at approximately 334 Million. It took about 12 minutes on my machine to find it.");

        long interval = 100000;
        List<PrimeGenerator> pgs = new ArrayList<>();
        for (int i = 0; i < maxThreads; i++) {
            PrimeGenerator pg = new PrimeGenerator(interval * i, interval, maxThreads);
            pgs.add(pg);

        }
        pgs.parallelStream().forEach(p -> LongStream.generate(p).mapToObj(Calculation::new).map(c -> {
            try {
                return c.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Pair<>(0, false);
        }).filter(Pair::getValue).map(Pair::getKey).forEach(res -> System.out.println("RESULT: " + res.toString())));
    }


}
