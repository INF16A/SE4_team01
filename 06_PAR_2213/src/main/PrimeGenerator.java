package main;

import java.math.BigInteger;
import java.util.function.LongSupplier;

public class PrimeGenerator implements LongSupplier {
    private long start;
    private long interval;
    private int offset;
    private BigInteger bigInt;
    private long startTime = 0;

    public PrimeGenerator(long start, long interval, int offset) {
        this.start = start;
        this.interval = interval;
        this.offset = offset;
        bigInt = BigInteger.valueOf(start);
        startTime = System.currentTimeMillis();
    }

    public long nextPrime() {
        bigInt = bigInt.nextProbablePrime();
        long val = bigInt.longValue();
        if (val > (start + interval)) {
            start += interval * offset;
            bigInt = BigInteger.valueOf(start);
            System.out.print("\r" + Float.toString((float)(System.currentTimeMillis() - startTime) / 1000) + "  debug: prime generator currently at: " + Long.toString(start) + "        ");
            return nextPrime();
        }
        return val;
    }


    @Override
    public long getAsLong() {
        return nextPrime();
    }
}
