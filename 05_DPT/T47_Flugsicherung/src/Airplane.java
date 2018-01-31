import java.util.ArrayList;
import java.util.List;

public class Airplane{
    private int height;
    private int[] location;
    private int speed;
    private IFlightControl flightControl;
    private List<IPositionListener> listeners = new ArrayList<>();

    public Airplane(IFlightControl fc) {
        this.flightControl = fc;
    }

    public void addListener(IPositionListener positionListener) {
        listeners.add(positionListener);
    }
}
