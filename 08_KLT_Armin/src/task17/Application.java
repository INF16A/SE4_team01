package task17;

import task17.iterator.Battery;
import task17.iterator.ChargingStation;
import task17.iterator.SystemProcess;
import task17.observer.Display;

public class Application {
    public static void main(String[] args) {
        ChargingStation station = new ChargingStation();
        Battery battery1 = new Battery(0),
                battery2 = new Battery(15),
                battery3 = new Battery(20);
        station.AddBattery(battery1);
        station.AddBattery(battery2);
        station.AddBattery(battery3);

        SystemProcess process = new SystemProcess(station);
        process.AddListener(new Display());

        for (int i = 0; i < 15; i++) {
            process.tick();
        }

    }
}
