import java.math.BigInteger;

public class PrimeCheck {
    public static boolean check(String input) {
        boolean isTrue = true;
        int length = input.length();
        for (int i = 1; isTrue && i < length; i++) {
            if (length % i == 0) {
                isTrue = check(input, i);
            }
        }
        return isTrue;
    }

    private static boolean check(String input, int divLength) {
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
