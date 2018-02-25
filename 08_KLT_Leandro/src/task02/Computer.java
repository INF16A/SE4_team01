package task02;

import java.util.ArrayList;
import java.util.List;

class Computer {
    private List<IUSB2> connectedDevices = new ArrayList<>();
    private List<IDeviceListener> deviceListeners = new ArrayList<>();

    void connectUSBDevice(IUSB2 device) {
        connectedDevices.add(device);
        for (IDeviceListener listener : deviceListeners) {
            listener.newDeviceConnected(device);
        }
    }

    public void addListener(IDeviceListener listener) {
        deviceListeners.add(listener);
    }

    public void removeListener(IDeviceListener listener) {
        deviceListeners.remove(listener);
    }
}
