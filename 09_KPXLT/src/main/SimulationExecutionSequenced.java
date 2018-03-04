package main;

import java.util.List;

public class SimulationExecutionSequenced implements ISimulationExecution {
    public SimulationExecutionSequenced(Simulation simulation) {
        this.simulation = simulation;
    }

    private Simulation simulation;

    @Override
    public void step() {
        List<Vehicle> vehicles = simulation.getVehicles();
        final int vehiclesCount = vehicles.size();
        System.out.println(0);
        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step1Accelerate(vehicles.get(i));
        }
        System.out.println(1);

        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step2CheckGap(vehicles.get(i), vehicles.get(wrap(i + 1, vehiclesCount)));
        }
        System.out.println(2);

        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step3Linger(vehicles.get(i));
        }
        System.out.println(3);

        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step4Drive(vehicles.get(i));
        }
    }
    private int wrap(int idx, int max) {
        return (idx % max);
    }


}
