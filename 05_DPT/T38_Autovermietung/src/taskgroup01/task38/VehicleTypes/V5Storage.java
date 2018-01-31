package taskgroup01.task38.VehicleTypes;

import taskgroup01.task38.IIterator;
import taskgroup01.task38.VehicleStorage;

public class V5Storage extends VehicleStorage<V5> {

    public V5Storage(int maxSize) {
        super(maxSize);
    }

    @Override
    public IIterator iterator() {
        return new V5Iterator(this);
    }
}
