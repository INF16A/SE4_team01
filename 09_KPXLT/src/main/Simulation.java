package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    private final int wrapAround = 1000;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    private List<Vehicle> vehicles = new ArrayList<>();
    private Random random;
    private float lingerProbability;

    public Simulation(int numberOfCars, float lingerProbability) {
        random = new Random();
        this.lingerProbability = lingerProbability;

        //add vehicles with random gaps to each other
        double curPos = 0, distance = wrapAround / (double) numberOfCars;
        int variation = (int) distance / 2;
        for (int i = 0; i < numberOfCars; i++) {
            int delta = 0;
            if (variation > 0) {
                delta = random.nextInt(variation * 2) - variation;
            }
            int position = (int) curPos + delta;
            if (position < 0)
                position = 0;
            if (position >= wrapAround)
                position = wrapAround - 1;
            vehicles.add(new Vehicle(position, 0));
            curPos += distance;
        }
    }

    public void step1Accelerate(Vehicle v) {
        v.accelerate();
    }

    public void step2CheckGap(Vehicle v1, Vehicle v2) {
        int gap = v2.getPosition() - v1.getPosition() - 1;
        if (gap < 0) { //correct for wrap-around calculation
            gap += 1000;
        }
        if (v1.getSpeed() > gap) {
            v1.setSpeed(gap);
        }
    }

    public void step3Linger(Vehicle v) {
        if (lingerProbability > 0) {
            if (random.nextFloat() < lingerProbability) {
                v.decelerate();
            }
        }
    }

    public void step4Drive(Vehicle v) {
        v.moveForwards();
    }
}
