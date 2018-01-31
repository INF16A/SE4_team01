import java.util.List;

public class FlightControl implements IFlightControl, IPositionListener {
    List<Airplane> airplanes;
    List<Airport> airports;
    public void sendClimbCommand(Airplane p) {

    }

    public void registerAirplane(Airplane p) {
        airplanes.add(p);
    }

    public void registerAirport(Airport a) {
        airports.add(a);
    }

    @Override
    public void heightChanged() {

    }

    @Override
    public void positionChanged() {

    }
}
