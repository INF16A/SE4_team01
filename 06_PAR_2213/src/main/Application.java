package main;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Calculation calc = new Calculation();
        int maxThreads = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        //ExecutorCompletionService executorComp = new ExecutorCompletionService(executor);

        PrimeGenerator pg = new PrimeGenerator(0, 10_000_000);
        pg.run();
        System.out.println("Primes done");
        List<Integer> results = new ArrayList<>();
        try {
            List<Future<Pair<Integer, Boolean>>> futures = executor.invokeAll(pg.getPrimes().stream().map(Calculation::new).collect(Collectors.toList()));

            futures.forEach(f -> {
                try {
                    Pair<Integer, Boolean> result = f.get();
                    if (result.getValue())
                        results.add(result.getKey());
                    //System.out.println(result.getKey());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(results);
    }


}
