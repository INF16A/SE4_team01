public class Airport {
    private int location;
    private IFlightControl flightControl;

    public Airport(IFlightControl fc, int pos) {
        this.flightControl = fc;
        fc.registerAirport(this);
        location = pos;
    }
}
