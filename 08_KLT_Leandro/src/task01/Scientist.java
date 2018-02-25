package task01;

public class Scientist implements IDataListener {
    private boolean stationAccessAllowed = false;

    public Scientist(boolean allowed) {
        stationAccessAllowed = allowed;
    }

    public boolean isStationAccessAllowed() {
        return stationAccessAllowed;
    }

    @Override
    public void newDataAvailable(String data) {
        System.out.println("I have received new data!   " + data);
    }
}
