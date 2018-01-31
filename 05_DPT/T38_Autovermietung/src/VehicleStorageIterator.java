public abstract class VehicleStorageIterator implements IIterator {
    private VehicleStorage vehicleStorage;
    private int index;

    public VehicleStorageIterator(VehicleStorage vs) {
        this.vehicleStorage = vs;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return (vehicleStorage.getVehicleAt(index + 1) != null);
    }

    @Override
    public Vehicle next() {
        index++;
        return vehicleStorage.getVehicleAt(index);

    }
}
