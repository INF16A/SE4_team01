package taskgroup01.task47;

import java.util.ArrayList;
import java.util.List;

public class Airplane implements IAirplane, ITimeControlled {
    private static final float changeHeightChance = 0.2f;
    private static final int minHeight = 9500;
    private static final int maxHeight = 11250;
    private int height = 10000;
    private int position;
    private int speed;
    private String name;

    private List<IPositionListener> listeners = new ArrayList<>();

    Airplane(IFlightControl fc, String name, int speed, Airport startAirport) {
        this.speed = speed;
        this.position = startAirport.getLocation();
        this.name = name;
        TimeControl.timeControl.addToTimeControl(this);
        fc.registerAirplane(this);
    }

    public void addListener(IPositionListener positionListener) {
        listeners.add(positionListener);
    }

    public void removeListener(IPositionListener positionListener) {
        listeners.remove(positionListener);
    }

    @Override
    public void cycle() {
        position += speed;
        //change height random based
        double chance = Application.getRandomChance();
        if (chance < changeHeightChance) {
            if (chance < changeHeightChance / 2) {
                height += 250;
            } else {
                height -= 250;
            }
        }

        // correct flight height
        if (height > maxHeight) {
            height = maxHeight;
        }
        if (height < minHeight) {
            height = minHeight;
        }

        System.out.print("[" + name + "] " + position + ", " + height + "  \t");
        notifyListeners();
    }

    public void emergencyClimb() {
        System.out.print("[" + name + "] Emergency climb from " + height + " to");
        height += 500;
        System.out.println(height);
    }

    private void notifyListeners() {
        for (IPositionListener listener : listeners) {
            listener.positionChanged(this, position, height);
        }
    }


}
