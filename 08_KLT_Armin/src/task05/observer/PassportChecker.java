package task05.observer;

import task17.observer.ChargingProcessListener;

import java.util.ArrayList;
import java.util.List;

public class PassportChecker extends ChargingProcessListener {
    protected List<ISecurityCheckListener> listeners;

    public PassportChecker() {
        listeners = new ArrayList<>();
    }

    public void AddListener(ISecurityCheckListener listener) {
        listeners.add(listener);
    }

    public void RemoveListener(ISecurityCheckListener listener) {
        listeners.remove(listener);
    }
}
