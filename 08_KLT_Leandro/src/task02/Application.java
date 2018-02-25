package task02;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        SystemProcess systemProcess = new SystemProcess();
        computer.addListener(systemProcess);
        IUSB2 dvdBurner = new DVDBurnerAdapter();
        computer.connectUSBDevice(dvdBurner);

    }
}
