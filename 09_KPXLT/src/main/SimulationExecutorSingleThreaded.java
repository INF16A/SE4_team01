package main;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationExecutorSingleThreaded extends SimulationExecutor {
    private Boolean running = false;

    public SimulationExecutorSingleThreaded(Simulation simulation) {
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

    private int wrap(int idx, int max) {
        return (idx % max);
    }

    private void loop() {
        List<Vehicle> vehicles = simulation.getVehicles();
        final int vehiclesCount = vehicles.size();
        System.out.println(0);
        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step1Accelerate(vehicles.get(i));
        }
        System.out.println(1);

        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step2CheckGap(vehicles.get(i), vehicles.get(wrap(i+1, vehiclesCount)));
        }
        System.out.println(2);

        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step3Linger(vehicles.get(i));
        }
        System.out.println(3);

        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step4Drive(vehicles.get(i));
        }
        fireEvent();
    }

    @Override
    public void stop() {
        System.out.println("attempting to shutdown");
        running = false;
    }
}
