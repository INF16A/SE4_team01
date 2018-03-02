package main;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SimulationExecutorMultiThreaded extends SimulationExecutor {
    private Boolean running = false;

    public SimulationExecutorMultiThreaded(Simulation simulation) {
        super(simulation);
    }

    private ExecutorService service = Executors.newFixedThreadPool(1);

    @Override
    public void start() {
        running = true;
        service.submit(() -> {
            while (running) {
                loop();
            }
            System.out.println("shutting down successful");
            service.shutdown();
        });
    }

    private void loop() {
        List<Vehicle> vehicles = simulation.getVehicles();
        final int vehiclesCount = vehicles.size();
        vehicles.stream().parallel().forEach(simulation::step1Accelerate);
        IntStream.range(0, vehicles.size()).forEach(idx -> simulation.step2CheckGap(vehicles.get(idx), vehicles.get((idx + 1) % vehiclesCount)));
        vehicles.stream().parallel().forEach(simulation::step3Linger);
        vehicles.stream().parallel().forEach(simulation::step4Drive);
        fireEvent();
    }

    @Override
    public void stop() {
        System.out.println("attempting to shutdown");
        running = false;
    }
}
