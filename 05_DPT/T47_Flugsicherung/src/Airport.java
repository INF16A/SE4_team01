public class Airport {
    private int[] location;
    private IFlightControl flightControl;

    public Airport(IFlightControl fc, int posX, int posY) {
        this.flightControl = fc;
        fc.registerAirport(this);
        location[0] = posX;
        location[1] = posY;
    }
}
