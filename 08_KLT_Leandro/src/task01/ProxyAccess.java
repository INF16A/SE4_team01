package task01;

public class ProxyAccess implements IStationAccess {
    private Scientist scientist;
    private WeatherStation weatherStation;

    public ProxyAccess(Scientist s) {
        scientist = s;
        weatherStation = new WeatherStation();
    }

    public void setScientist(Scientist s) {
        scientist = s;
    }

    @Override
    public void addListener(IDataListener listener) {
        if(scientist.isStationAccessAllowed()) {
            weatherStation.addListener(listener);
        }
        else {
            System.out.println("This person is not allowed to observe the weather station");
        }
    }

    public void queryData() {
        weatherStation.queryData();
    }
}
