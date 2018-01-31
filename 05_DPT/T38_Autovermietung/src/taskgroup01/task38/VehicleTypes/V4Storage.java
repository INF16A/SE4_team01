package taskgroup01.task38.VehicleTypes;

import taskgroup01.task38.IIterator;
import taskgroup01.task38.VehicleStorage;

public class V4Storage extends VehicleStorage<V4> {

    public V4Storage(int maxSize) {
        super(maxSize);
    }

    @Override
    public IIterator iterator() {
        return new V4Iterator(this);
    }
}
