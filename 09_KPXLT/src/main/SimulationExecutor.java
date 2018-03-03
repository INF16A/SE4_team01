package main;

import java.util.ArrayList;
import java.util.List;

public abstract class SimulationExecutor implements ISimulationExecutor {
    public SimulationExecutor(Simulation simulation) {
        this.simulation = simulation;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    protected Simulation simulation;


    public void AddListener(ISimulationObserver observer) {
        observers.add(observer);
    }

    public void RemoveListener(ISimulationObserver observer) {
        observers.remove(observer);
    }

    protected void fireEvent() {
        try {
            observers.forEach(ISimulationObserver::stepFinished);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<ISimulationObserver> observers = new ArrayList<>();


}
