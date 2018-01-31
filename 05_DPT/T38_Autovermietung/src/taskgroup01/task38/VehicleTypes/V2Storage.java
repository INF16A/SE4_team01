package taskgroup01.task38.VehicleTypes;

import taskgroup01.task38.IIterator;
import taskgroup01.task38.VehicleStorage;

public class V2Storage extends VehicleStorage<V2> {

    public V2Storage(int maxSize) {
        super(maxSize);
    }

    @Override
    public IIterator iterator() {
        return new V2Iterator(this);
    }
}
