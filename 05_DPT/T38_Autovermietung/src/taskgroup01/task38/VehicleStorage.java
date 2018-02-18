package taskgroup01.task38;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class VehicleStorage<Vhcl extends Vehicle> implements IAgregate {
    private List<Vhcl> vehicles = new ArrayList<>();
    private int maximumIndex;

    public VehicleStorage(int maxSize) {
        maximumIndex = maxSize;
    }


    Vhcl getVehicleByPlate(String plate) {
        return vehicles.stream().filter(v -> v.getLicensePlate().toLowerCase().equals(plate.toLowerCase())).findFirst().orElse(null);
    }

    void setTenant(Vehicle v, Customer tenant) {
        vehicles.get(vehicles.indexOf(v)).setRentedBy(tenant);
    }

    List<Vhcl> getFreeVehicles() {
        return vehicles.stream().filter(v -> v.getRentedBy() == null).collect(Collectors.toList());
    }


    protected void appendVehicle(Vhcl v) {
        vehicles.add(v);
    }

    public abstract IIterator iterator();

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
