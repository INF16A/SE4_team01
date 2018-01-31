import java.util.ArrayList;
import java.util.List;

public class Airplane implements ITimeControlled {
    private static final float changeHeightChance = 0.2f;
    private static final int minHeight = 9500;
    private static final int maxHeight = 11250;
    private static final int maxEmergencyHeight = 9000;
    private static final int minEmergencyHeight = 11500;
    private int height = 10000;
    private int position;
    private int speed = 20;
    private String name;

    private IFlightControl flightControl;
    private List<IPositionListener> listeners = new ArrayList<>();

    public Airplane(IFlightControl fc, String name) {
        this.name = name;
        this.flightControl = fc;
        this.flightControl.registerAirplane(this);
    }

    public void addListener(IPositionListener positionListener) {
        listeners.add(positionListener);
    }

    public void removeListener(IPositionListener positionListener) {
        listeners.remove(positionListener);
    }

    @Override
    public void Cycle() {
        position += speed;
        //change height random based
        double chance = Application.GetRandomChance();
        if (chance < changeHeightChance) {
            if (chance < changeHeightChance / 2) {
                height += 250;
            } else if (chance >= changeHeightChance / 2) {
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

        System.out.print("[" + name + "] now flying at position " + position + ", altitude " + height);
        notifyListeners();
    }

    public void emergencyClimb() {
        System.out.print("[" + name + "] Emergency climb from " + height + " to");
        height += 500;
        System.out.println(height);
    }

    private void notifyListeners() {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).positionChanged(this, position, height);
        }
    }


}
