package main;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SimulationExecutorTimed extends SimulationExecutor {
    private Boolean running = false;
    private int interval;
    private Timer timer;

    public SimulationExecutorTimed(Simulation simulation, int interval) {
        super(simulation);
        this.interval = interval;
        this.timer = new Timer();
    }


    @Override
    public void start() {
        running = true;
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        loop();
                    }
                }
                , interval, interval);
        System.out.println("shutting down successful");

    }

    private int wrap(int idx, int max) {
        return (idx % max);
    }

    private void loop() {
        List<Vehicle> vehicles = simulation.getVehicles();
        final int vehiclesCount = vehicles.size();
        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step1Accelerate(vehicles.get(i));
        }
        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step2CheckGap(vehicles.get(i), vehicles.get(wrap(i + 1, vehiclesCount)));
        }
        for (int i = 0; i < vehiclesCount; i++) {
            simulation.step3Linger(vehicles.get(i));
        }
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
