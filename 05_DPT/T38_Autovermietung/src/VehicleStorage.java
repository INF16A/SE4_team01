import java.util.ArrayList;
import java.util.List;

public abstract class VehicleStorage {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int maximumIndex = 3;

    public Vehicle getVehicleAt(int index) {
        if (index < maximumIndex) {
            return vehicles.get(index);
        } else return null;
    }

    public int getLength() {
        return vehicles.size();
    }

}
