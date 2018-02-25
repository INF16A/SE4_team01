package task01;

public class Scientist implements IDataListener {
    private boolean stationAccessAllowed = false;

    Scientist(boolean allowed) {
        stationAccessAllowed = allowed;
    }

    boolean isStationAccessAllowed() {
        return stationAccessAllowed;
    }

    @Override
    public void newDataAvailable(String data) {
        System.out.println("I have received new data!   " + data);
    }
}
