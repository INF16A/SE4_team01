package task17.iterator;

import task17.observer.ChargingProcessListener;
import task17.observer.IChargingProcessListener;

public class SystemProcess extends ChargingProcessListener {

    public SystemProcess(ChargingStation station) {
        this.station = station;
    }

    private ChargingStation station;

    public void tick() {
        boolean allFull = true;
        for (Battery battery : station) {
            int chargingState = battery.getStateInPercent();
            if (chargingState != 100) {
                allFull = false;
                battery.setStateInPercent(battery.getStateInPercent() + 10);
            }
        }
        System.out.println(allFull);
        if(allFull){
            listeners.forEach(IChargingProcessListener::batteryChargedCompletely);
        }
    }
}
