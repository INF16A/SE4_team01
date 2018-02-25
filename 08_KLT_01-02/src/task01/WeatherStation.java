package task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements IStationAccess {
    private List<IDataListener> listeners = new ArrayList<>();
    private Random random;

    WeatherStation() {
        random = new Random();
    }

    void queryData() {
        double temp = (random.nextDouble() * 60) - 20; //generate random temperature between -20 and +40°C
        String data = "Current temperature: " + Double.toString(temp).substring(0, 5) + "°C";
        for (IDataListener listener : listeners) {
            listener.newDataAvailable(data);
        }
    }

    @Override
    public void addListener(IDataListener listener) {
        listeners.add(listener);
    }
}
