package taskgroup01.task38;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleStorage<Vhcl extends Vehicle> implements IAgregate {
    private List<Vhcl> vehicles = new ArrayList<>();
    private int maximumIndex;

    public VehicleStorage(int maxSize) {
        maximumIndex = maxSize;
    }

    public Vhcl getVehicleAt(int index) {
        if (index < maximumIndex) {
            return vehicles.get(index);
        } else return null;
    }

    public int getLength() {
        return vehicles.size();
    }

    public void appendVehicle(Vhcl v) {
        vehicles.add(v);
    }

    public IIterator iterator() {
        //return new taskgroup01.task38.VehicleStorageIterator(this);
        return null;
    }

}
