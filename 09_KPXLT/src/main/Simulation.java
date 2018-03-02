package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    private final int xResolution = 1000;
    private List<Vehicle> vehicles = new ArrayList<>();
    private Random random;
    private float lingerProbability;

    public Simulation(float lingerProbability) {
        random = new Random();
        this.lingerProbability = lingerProbability;
    }


    private void step1Accelerate(Vehicle v) {
        v.accelerate();
    }

    private void step2CheckGap(Vehicle v1, Vehicle v2) {
        int gap = v2.getPosition() - v1.getPosition();
        if (gap < 0) { //correct for wrap-around calculation
            gap += 1000;
        }
        if (v1.getSpeed() > gap) {
            v1.setSpeed(gap);
        }
    }

    private void step3Linger(Vehicle v) {
        if (lingerProbability > 0) {
            if (random.nextFloat() < lingerProbability) {
                v.slowDown();
            }
        }
    }

    private void step4Drive(Vehicle v) {
        v.moveForwards();
    }
}
