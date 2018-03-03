package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationExecutorSingleThreaded extends SimulationExecutor {
    private Boolean running = false;

    public SimulationExecutorSingleThreaded(ISimulationExecution simulationExecution) {
        super(simulationExecution);
    }

    private ExecutorService service = Executors.newFixedThreadPool(1);

    @Override
    public void start() {
        running = true;
        service.submit(() -> {
            while (running) {
                simulationExecution.step();
                fireEvent();
            }
            System.out.println("shutting down successful");
            service.shutdown();
        });
    }

    private int wrap(int idx, int max) {
        return (idx % max);
    }

    @Override
    public void stop() {
        System.out.println("attempting to shutdown");
        running = false;
    }
}
