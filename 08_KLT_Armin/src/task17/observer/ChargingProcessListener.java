package task17.observer;


import java.util.ArrayList;
import java.util.List;

public class ChargingProcessListener {
    protected List<IChargingProcessListener> listeners;

    public ChargingProcessListener() {
        listeners = new ArrayList<>();
    }

    public void AddListener(IChargingProcessListener listener) {
        listeners.add(listener);
    }

    public void RemoveListener(IChargingProcessListener listener) {
        listeners.remove(listener);
    }
}
