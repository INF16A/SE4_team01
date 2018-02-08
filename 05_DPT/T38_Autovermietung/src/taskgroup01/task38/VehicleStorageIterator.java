package taskgroup01.task38;

public abstract class VehicleStorageIterator<VhclStrg extends VehicleStorage> implements IIterator {
    private VhclStrg vehicleStorage;
    private int index;

    public VehicleStorageIterator(VhclStrg vs) {
        this.vehicleStorage = vs;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return (vehicleStorage.getVehicleAt(index) != null);
    }

    @Override
    public Vehicle next() {
        Vehicle v = vehicleStorage.getVehicleAt(index); //also increment index for next time
        index++;
        return v;

    }
}
