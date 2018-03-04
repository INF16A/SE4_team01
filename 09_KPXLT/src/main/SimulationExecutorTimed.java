package main;

import java.util.Timer;
import java.util.TimerTask;

public class SimulationExecutorTimed extends SimulationExecutor {
    private Boolean running = false;
    private int interval;
    private Timer timer;

    public SimulationExecutorTimed(ISimulationExecution simulationExecution, int interval) {
        super(simulationExecution);
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
                        simulationExecution.step();
                        fireEvent();
                        if (!running) {
                            this.cancel();
                            timer.cancel();
                            System.out.println("shutting down successful");
                        }
                    }
                }
                , interval, interval);
    }

    @Override
    public void stop() {
        System.out.println("attempting to shutdown");
        running = false;
    }
}
