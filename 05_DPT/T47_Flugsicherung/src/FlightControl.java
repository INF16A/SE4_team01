import java.util.ArrayList;
import java.util.List;

public class FlightControl implements IFlightControl, IPositionListener {
    List<Airplane> airplanes = new ArrayList<>();
    List<Airport> airports = new ArrayList<>();
    List<ClimbCommand> climbCommands = new ArrayList<>();

    public void registerAirplane(Airplane p) {
        airplanes.add(p);
        climbCommands.add(new ClimbCommand(p));
    }

    public void registerAirport(Airport a) {
        airports.add(a);
    }

    @Override
    public void positionChanged(Airplane p, int pos, int height) {

    }
}
