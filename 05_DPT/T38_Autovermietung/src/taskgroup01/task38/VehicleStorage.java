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

    public Vhcl getVehicleByPlate(String plate) {
        return vehicles.stream().filter(v -> v.getLicensePlate().toLowerCase().equals(plate.toLowerCase())).findFirst().orElse(null);
    }

    public void setTenant(Vehicle v, Customer tenant) {
        vehicles.get(vehicles.indexOf(v)).setRentedBy(tenant);
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

    @Override
    public String toString() {
        // has to be weird string array because of lambda
        final String[] str = {"[ "};
        vehicles.forEach(v -> str[0] += v.toString() + " | ");
        str[0] = str[0].substring(0, str[0].length() - 3);
        str[0] += " ]";
        return str[0];
    }
}
