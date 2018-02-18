package main;

import javafx.util.Pair;

import java.util.concurrent.Callable;

public class Calculation implements Callable<Pair<Long, Boolean>> {
    private long inputNumber;

    public Calculation(long num) {
        inputNumber = num;
    }

    @Override
    public Pair<Long, Boolean> call() throws Exception {
        boolean result = calculate(inputNumber);
        return new Pair<>(inputNumber, result);
    }

    public boolean calculate(long input) {
        if (input < 100) return false;
        String numStr = Long.toString(input);
        int length = numStr.length();

        int[] parts = {length - 2, 1, 1};
        parts[0]--;
        parts[2]++;
        for (parts[0] = 1; parts[0] <= length - 2; parts[0]++) {
            for (parts[1] = 1; parts[1] <= length - 1 - parts[0]; parts[1]++) {
                parts[2] = length - parts[0] - parts[1];

                int a = Integer.parseInt(numStr.substring(0, parts[0]));
                int b = Integer.parseInt(numStr.substring(parts[0], parts[0] + parts[1]));
                int c = Integer.parseInt(numStr.substring(parts[0] + parts[1], parts[0] + parts[1] + parts[2]));

                long sum = (long) Math.pow(a, 3);
                if (sum > input) break;
                sum += (long) Math.pow(b, 3);
                if (sum > input) break;
                sum += (long) Math.pow(c, 3);
                if (sum == input) {
                    return true;
                }

            }
        }
        return false;
    }
}
