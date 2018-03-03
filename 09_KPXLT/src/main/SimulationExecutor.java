package main;

import java.util.ArrayList;
import java.util.List;

public abstract class SimulationExecutor implements ISimulationExecutor {
    public SimulationExecutor(ISimulationExecution simulationExecution) {
        this.simulationExecution = simulationExecution;
    }


    protected ISimulationExecution simulationExecution;


    public void AddListener(ISimulationObserver observer) {
        observers.add(observer);
    }

    public void RemoveListener(ISimulationObserver observer) {
        observers.remove(observer);
    }

    protected void fireEvent() {
        try {
            observers.forEach(ISimulationObserver::stepFinished);
        } catch (Exception e) {
            // todo FIX this exception.
            e.printStackTrace();
        }
    }

    private List<ISimulationObserver> observers = new ArrayList<>();


}
