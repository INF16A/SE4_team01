package taskgroup01.task38.vehicleType;

import taskgroup01.task38.IIterator;
import taskgroup01.task38.VehicleStorage;

public class V1Storage extends VehicleStorage<V1> {

    public V1Storage(int maxSize) {
        super(maxSize);
    }

    @Override
    public IIterator iterator() {
        return new V1Iterator(this);
    }
}
