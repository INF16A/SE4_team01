public class Airplane {
    private int height;
    private int[] location;
    private int speed;
    private IFlightControl flightControl;

    public Airplane(IFlightControl fc) {
        this.flightControl = fc;
    }
}
