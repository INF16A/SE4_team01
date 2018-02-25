package task17.observer;

public class Display implements IChargingProcessListener {

    public Display() {
        System.out.println("Display: RED");
    }

    @Override
    public void batteryChargedCompletely() {
        System.out.println("Display: GREEN");
    }
}
