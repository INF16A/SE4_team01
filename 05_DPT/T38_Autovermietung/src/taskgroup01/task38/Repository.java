package taskgroup01.task38;

import taskgroup01.task38.vehicleType.*;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<VehicleStorage> storages = new ArrayList<>();
    private List<IIterator> iterators = new ArrayList<>();

    private Reservation reservation;

    public Repository() {
        reservation = new Reservation(this);

        // there must be a better way for this, but I can't think how currently. TODO: make better
        V1Storage v1Storage = new V1Storage(3);
        IIterator v1Iterator = v1Storage.iterator();
        v1Storage.appendVehicle(new V1("BS-AF1001"));
        v1Storage.appendVehicle(new V1("BS-AF1002"));
        v1Storage.appendVehicle(new V1("BS-AF1003"));
        storages.add(v1Storage);
        iterators.add(v1Iterator);

        V2Storage v2Storage = new V2Storage(3);
        IIterator v2Iterator = v2Storage.iterator();
        v2Storage.appendVehicle(new V2("BS-AF2001"));
        v2Storage.appendVehicle(new V2("BS-AF2002"));
        v2Storage.appendVehicle(new V2("BS-AF2003"));
        storages.add(v2Storage);
        iterators.add(v2Iterator);

        V3Storage v3Storage = new V3Storage(3);
        IIterator v3Iterator = v3Storage.iterator();
        v3Storage.appendVehicle(new V3("BS-AF3001"));
        v3Storage.appendVehicle(new V3("BS-AF3002"));
        v3Storage.appendVehicle(new V3("BS-AF3003"));
        storages.add(v3Storage);
        iterators.add(v3Iterator);

        V4Storage v4Storage = new V4Storage(3);
        IIterator v4Iterator = v4Storage.iterator();
        v4Storage.appendVehicle(new V4("BS-AF4001"));
        v4Storage.appendVehicle(new V4("BS-AF4002"));
        v4Storage.appendVehicle(new V4("BS-AF4003"));
        storages.add(v4Storage);
        iterators.add(v4Iterator);

        V5Storage v5Storage = new V5Storage(3);
        IIterator v5Iterator = v5Storage.iterator();
        v5Storage.appendVehicle(new V5("BS-AF5001"));
        v5Storage.appendVehicle(new V5("BS-AF5002"));
        v5Storage.appendVehicle(new V5("BS-AF5003"));
        storages.add(v5Storage);
        iterators.add(v5Iterator);
    }

    private Vehicle getVehicleByLicensePlate(String plate) {
        for (VehicleStorage storage : storages) {
            Vehicle v = storage.getVehicleByPlate(plate);
            if (v != null) return v;
        }
        return null;
    }

    private VehicleStorage getStorageForVehicle(Vehicle v) {

        String className = v.getClass().toString();
        String[] classNameChecks = {"V1", "V2", "V3", "V4", "V5"};
        int i = 0;
        for (String classNameCheck : classNameChecks) {
            if (className.contains(classNameCheck))
                return storages.get(i);
            i++;
        }
        return null;
    }

    private VehicleStorage getStorageForType(int vehicleType) {
        if (vehicleType <= 5 && vehicleType >= 1) {
            return storages.get(vehicleType - 1);
        }
        return null;
    }

    private IIterator getIteratorForType(int vehicleType) {
        if (vehicleType <= 5 && vehicleType >= 1) {
            return iterators.get(vehicleType - 1);
        }
        return null;
    }


    public void rentVehicle(int vehicleType, Customer customer) {
        VehicleStorage vehicleStorage = getStorageForType(vehicleType);
        IIterator vehicleIterator = getIteratorForType(vehicleType);
        if (vehicleStorage != null) {
            assert vehicleIterator != null;
            if (vehicleIterator.hasNext()) {
                Vehicle vehicle = vehicleIterator.next();
                vehicleStorage.setTenant(vehicle, customer);
                System.out.println("Rented car with plate " + vehicle.getLicensePlate() + " to " + customer.getName());
            } else {
                System.out.println("No car of the requested type available, a reservation will be remembered.");
                reservation.addListener(vehicleType, customer);
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    public void returnVehicle(String plate, Customer customer) {
        Vehicle v = getVehicleByLicensePlate(plate);
        if (v != null) {
            VehicleStorage vs = getStorageForVehicle(v);
            if (v.getRentedBy() != null) {
                if (v.getRentedBy().equals(customer)) {
                    assert vs != null;
                    vs.setTenant(v, null);
                    System.out.println("Successfully returned vehicle");
                    reservation.sendNotification(v.getType());
                } else {
                    System.out.println("ERROR: You are unauthorized to return the vehicle rented by " + v.getRentedBy().getName());
                }
            } else {
                System.out.println("ERROR: Can't return car that is not rented.");
            }
        } else {
            System.out.println("ERROR: No vehicle with plate \"" + plate + "\" exists");
        }
    }


}
