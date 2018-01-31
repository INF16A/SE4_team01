import java.util.ArrayList;
import java.util.List;

public abstract class VehicleStorage {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int maximumIndex;

    public VehicleStorage(int maxSize) {
        maximumIndex = maxSize;
    }

    public Vehicle getVehicleAt(int index) {
        if (index < maximumIndex) {
            return vehicles.get(index);
        } else return null;
    }

    public int getLength() {
        return vehicles.size();
    }

    public void appendVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public IIterator iterator() {
        //return new VehicleStorageIterator(this);
        return null;
    }

}
