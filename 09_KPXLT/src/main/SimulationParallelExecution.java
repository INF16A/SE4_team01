package main;

import java.util.List;
import java.util.stream.IntStream;

public class SimulationParallelExecution implements ISimulationExecution {
    public SimulationParallelExecution(Simulation simulation) {
        this.simulation = simulation;
    }

    private Simulation simulation;

    @Override
    public void step() {
        List<Vehicle> vehicles = simulation.getVehicles();
        final int vehiclesCount = vehicles.size();
        vehicles.stream().parallel().forEach(simulation::step1Accelerate);
        IntStream.range(0, vehicles.size()).forEach(idx -> simulation.step2CheckGap(vehicles.get(idx), vehicles.get(wrap(idx + 1, vehiclesCount))));
        vehicles.stream().parallel().forEach(simulation::step3Linger);
        vehicles.stream().parallel().forEach(simulation::step4Drive);
    }

    private int wrap(int idx, int max) {
        return (idx % max);
    }
}
