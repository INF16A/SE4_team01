package taskgroup01.task47;

import java.util.ArrayList;
import java.util.List;

class LastPosition {
    public final int pos;
    public final int height;

    public LastPosition(int pos, int height) {
        this.pos = pos;
        this.height = height;
    }
}

public class FlightControl implements IFlightControl, IPositionListener {
    private List<IAirplane> airplanes = new ArrayList<>();
    private List<ClimbCommand> climbCommands = new ArrayList<>();
    private List<LastPosition> lastPositions = new ArrayList<>();

    public FlightControl() {
        lastPositions.add(new LastPosition(0, 0));
        lastPositions.add(new LastPosition(0, 0));
    }

    public void registerAirplane(IAirplane p) {
        p.addListener(this);
        airplanes.add(p);
        climbCommands.add(new ClimbCommand(p));
    }

    @Override
    public void positionChanged(IPositionSpeaker p, int pos, int height) {
        int index = airplanes.indexOf(p);
        lastPositions.set(index, new LastPosition(pos, height));
        if (index == 1) checkForCollision();
    }

    private void checkForCollision() {
        LastPosition loc1 = lastPositions.get(0);
        LastPosition loc2 = lastPositions.get(1);
        if (Math.abs(loc1.pos - loc2.pos) <= 40 && loc1.pos < loc2.pos) { //planes are one second apart
            if (loc1.height == loc2.height) { //planes will collide
                if (Application.getRandomChance() < 0.5) {
                    climbCommands.get(0).execute();
                } else {
                    climbCommands.get(1).execute();
                }
            }
        }
    }
}
