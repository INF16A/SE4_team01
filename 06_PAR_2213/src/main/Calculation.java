package main;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.util.Map;
import java.util.concurrent.Callable;

public class Calculation implements Callable<Pair<Integer, Boolean>> {
    private int inputNumber;

    private boolean result;

    public Calculation() {

    }

    public Calculation(int num) {
        inputNumber = num;
    }

    @Override
    public Pair<Integer, Boolean> call() throws Exception {
        calculate(inputNumber);
        return new Pair<>(inputNumber, result);
    }

    public int getInputNumber() {
        return inputNumber;
    }
/*
    @Override
    public void run() {
        calculate(inputNumber);
    }*/

    public boolean calculate(int input) {
        if (input < 100) return false;
        String numStr = Integer.toString(input);
        int length = numStr.length();

        int[] parts = {length - 2, 1, 1};
        parts[0]--;
        parts[2]++;
        result = false;
        for (parts[0] = 1; parts[0] <= length - 2; parts[0]++) {
            for (parts[1] = 1; parts[1] <= length - 1 - parts[0]; parts[1]++) {
                parts[2] = length - parts[0] - parts[1];

                int a = Integer.parseInt(numStr.substring(0, parts[0]));
                int b = Integer.parseInt(numStr.substring(parts[0], parts[0] + parts[1]));
                int c = Integer.parseInt(numStr.substring(parts[0] + parts[1], parts[0] + parts[1] + parts[2]));
                //System.out.println();
                //System.out.print(Integer.toString(a) + " " + Integer.toString(b) + " " + Integer.toString(c) + " " );
                long sum = (long)Math.pow(a, 3);
                if(sum > input) break;
                sum += (long)Math.pow(b, 3);
                if(sum > input) break;
                sum += (long)Math.pow(c, 3);
                //System.out.println(sum);
                if(sum == input) {
                    result = true;
                    return true;
                }

            }
        }
        return false;
    }

    /*private int doCubic(int num, int[] parts) {
        String numStr = Integer.toString(num);
        int a = Integer.parseInt(numStr.substring(0, parts[0]));
        int b = Integer.parseInt(numStr.substring(parts[0], parts[0] + parts[1]));
        int c = Integer.parseInt(numStr.substring(parts[0] + parts[1], parts[0] + parts[1] + parts[2]));

        int sum = (int)Math.pow(a, 3);
        sum += Math.pow(b, 3);
        sum += Math.pow(c, 3);
        return sum;
    }*/
}
