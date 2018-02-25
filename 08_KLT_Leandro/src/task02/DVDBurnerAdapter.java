package task02;

public class DVDBurnerAdapter extends DVDBurner implements IUSB2 {
    @Override
    public void plugIn() {
        plugInUSB3();
    }
}
