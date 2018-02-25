package task02;

public class SystemProcess implements IDeviceListener {

    @Override
    public void newDeviceConnected(IUSB2 device) {
        System.out.println("New USB2 device connected!");
    }
}
