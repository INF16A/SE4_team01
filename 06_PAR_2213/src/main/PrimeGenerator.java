package main;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable {

    private int min;
    private int max;

    private List<Integer> primes = new ArrayList<>();

    public PrimeGenerator(int minumum, int maximum) {
        min = minumum;
        max = maximum;
    }

    @Override
    public void run() {
        for(int i = min; i < max; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    private boolean isPrime(int testNr) {
        if(testNr == 2) {
            return true;
        }

        if(testNr % 2 == 0)
            return false;

        for(int i = 3; i * i <= testNr; i += 2) {
            if((testNr % i) == 0)
                return false;
        }
        return true;
    }

    private int integerSqrt(int n) {
        if(n < 0) {
            throw new RuntimeException("No negative sqrts");
        }

        if(n < 2)
            return n;

        int small = integerSqrt(n >> 2) << 1;
        int large = small + 1;
        if(large*large > n)
            return small;
        return large;
    }
}