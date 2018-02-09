package taskgroup01.task38;

import taskgroup01.task38.vehicleType.*;

public class Repository {
    private V1Storage v1Storage;
    private V2Storage v2Storage;
    private V3Storage v3Storage;
    private V4Storage v4Storage;
    private V5Storage v5Storage;
    private IIterator v1Iterator;
    private IIterator v2Iterator;
    private IIterator v3Iterator;
    private IIterator v4Iterator;
    private IIterator v5Iterator;

    Reservation reservation;

    public Repository() {
        reservation = new Reservation();

        // there must be a better way for this, but I can't think how currently. TODO: make better
        v1Storage = new V1Storage(3);
        v1Iterator = v1Storage.iterator();
        v1Storage.appendVehicle(new V1("BS-AF1001"));
        v1Storage.appendVehicle(new V1("BS-AF1002"));
        v1Storage.appendVehicle(new V1("BS-AF1003"));

        v2Storage = new V2Storage(3);
        v2Iterator = v2Storage.iterator();
        v2Storage.appendVehicle(new V2("BS-AF2001"));
        v2Storage.appendVehicle(new V2("BS-AF2002"));
        v2Storage.appendVehicle(new V2("BS-AF2003"));

        v3Storage = new V3Storage(3);
        v3Iterator = v3Storage.iterator();
        v3Storage.appendVehicle(new V3("BS-AF3001"));
        v3Storage.appendVehicle(new V3("BS-AF3002"));
        v3Storage.appendVehicle(new V3("BS-AF3003"));

        v4Storage = new V4Storage(3);
        v4Iterator = v4Storage.iterator();
        v4Storage.appendVehicle(new V4("BS-AF4001"));
        v4Storage.appendVehicle(new V4("BS-AF4002"));
        v4Storage.appendVehicle(new V4("BS-AF4003"));

        v5Storage = new V5Storage(3);
        v5Iterator = v5Storage.iterator();
        v5Storage.appendVehicle(new V5("BS-AF5001"));
        v5Storage.appendVehicle(new V5("BS-AF5002"));
        v5Storage.appendVehicle(new V5("BS-AF5003"));
    }

    // there must be a better way for this, but I can't think how currently. TODO: make better
    private Vehicle getVehicleByLicensePlate(String plate) {
        Vehicle v = null;
        v = v1Storage.getVehicleByPlate(plate);
        if (v != null) return v;
        v = v2Storage.getVehicleByPlate(plate);
        if (v != null) return v;
        v = v3Storage.getVehicleByPlate(plate);
        if (v != null) return v;
        v = v4Storage.getVehicleByPlate(plate);
        if (v != null) return v;
        v = v5Storage.getVehicleByPlate(plate);
        return v;
    }

    private VehicleStorage getStorageForVehicle(Vehicle v) {
        String className = v.getClass().toString();
        if(className.contains("V1"))
            return v1Storage;
        else if(className.contains("V2"))
            return v2Storage;
        else if(className.contains("V3"))
            return v3Storage;
        else if(className.contains("V4"))
            return v4Storage;
        else if(className.contains("V5"))
            return v5Storage;
        else
            return null;
    }

    private VehicleStorage getStorageForType(int vehicleType) {
        switch (vehicleType) {
            case 1:
                return v1Storage;
            case 2:
                return v2Storage;
            case 3:
                return v3Storage;
            case 4:
                return v4Storage;
            case 5:
                return v5Storage;
        }
        return null;
    }

    private IIterator getIteratorForType(int vehicleType) {
        switch (vehicleType) {
            case 1:
                return v1Iterator;
            case 2:
                return v2Iterator;
            case 3:
                return v3Iterator;
            case 4:
                return v4Iterator;
            case 5:
                return v5Iterator;
        }
        return null;
    }


    public void rentVehicle(int vehicleType, Customer customer) {
        VehicleStorage vehicleStorage = getStorageForType(vehicleType);
        IIterator vehicleIterator = getIteratorForType(vehicleType);
        if (vehicleStorage != null) {
            if (vehicleIterator.hasNext()) {
                Vehicle vehicle = vehicleIterator.next();
                vehicleStorage.setTenant(vehicle, customer);
                System.out.println("Rented car with plate " + vehicle.getLicensePlate() + " to " + customer.getName());
            } else {
                System.out.println("No car of the requested type available, a reservation will be remembered.");
                reservation.addListener(vehicleType, customer);
            }
        }
    }

    public void returnVehicle(String plate, Customer customer) {
        Vehicle v = getVehicleByLicensePlate(plate);
        if (v != null) {
            VehicleStorage vs = getStorageForVehicle(v);
            if(v.getRentedBy() != null) {
                if(v.getRentedBy().equals(customer)) {
                    vs.setTenant(v, null);
                    System.out.println("Successfully returned vehicle");
                    reservation.sendNotification(v.getType());
                }
                else {
                    System.out.println("ERROR: You are unauthorized to return the vehicle rented by " + v.getRentedBy().getName());
                }
            } else {
                System.out.println("ERROR: Can't return car that is not rented.");
            }
        } else {
            System.out.println("ERROR: No vehicle with plate " + plate + " exists");
        }
    }


}
