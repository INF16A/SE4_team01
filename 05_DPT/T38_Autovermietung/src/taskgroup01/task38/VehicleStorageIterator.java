package taskgroup01.task38;

public abstract class VehicleStorageIterator<VhclStrg extends VehicleStorage> implements IIterator {
    private VhclStrg vehicleStorage;

    public VehicleStorageIterator(VhclStrg vs) {
        this.vehicleStorage = vs;
    }

    @Override
    public boolean hasNext() {
        return vehicleStorage.getFreeVehicles().size() > 0;
    }

    @Override
    public Vehicle next() {
        return (Vehicle) vehicleStorage.getFreeVehicles().get(0);

    }


}
