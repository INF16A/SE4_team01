package taskgroup01.task38.vehicleType;

import taskgroup01.task38.IIterator;
import taskgroup01.task38.VehicleStorage;

public class V3Storage extends VehicleStorage<V3> {

    public V3Storage(int maxSize) {
        super(maxSize);
    }

    @Override
    public IIterator iterator() {
        return new V3Iterator(this);
    }
}
