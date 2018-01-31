import java.util.ArrayList;
import java.util.List;

class LastPosition {
    public int pos;
    public int height;

    public LastPosition(int pos, int height) {
        this.pos = pos;
        this.height = height;
    }
}

public class FlightControl implements IFlightControl, IPositionListener {
    private List<Airplane> airplanes = new ArrayList<>();
    private List<ClimbCommand> climbCommands = new ArrayList<>();
    private List<LastPosition> lastPositions = new ArrayList<>();
    private List<Airport> airports = new ArrayList<>();

    public FlightControl() {
        lastPositions.add(new LastPosition(0,0));
        lastPositions.add(new LastPosition(0,0));
    }

    public void registerAirplane(Airplane p) {
        p.addListener(this);
        airplanes.add(p);
        climbCommands.add(new ClimbCommand(p));
    }

    public void registerAirport(Airport a) {
        airports.add(a);
    }

    @Override
    public void positionChanged(Airplane p, int pos, int height) {
        int index = airplanes.indexOf(p);
        lastPositions.set(index, new LastPosition(pos, height));
        checkForCollision();
    }

    private void checkForCollision() {
        LastPosition loc1 = lastPositions.get(0);
        LastPosition loc2 = lastPositions.get(1);
        if (Math.abs(loc1.pos - loc2.pos) <= 40) { //planes are one second apart
            if (loc1.height == loc2.height) { //planes will collide
                if (Application.GetRandomChance() < 0.5) {
                    climbCommands.get(0).execute();
                } else {
                    climbCommands.get(1).execute();
                }
            }
        }
    }
}
