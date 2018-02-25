package task17.iterator;

import java.util.Iterator;

public class SlotIterator implements Iterator<Battery> {
    public SlotIterator(Battery battery1, Battery battery2, Battery battery3) {
        this.battery1 = battery1;
        this.battery2 = battery2;
        this.battery3 = battery3;
    }

    private Battery battery1, battery2, battery3;
    private int index = 0;

    @Override
    public boolean hasNext() {
        return index < 3;
    }

    @Override
    public Battery next() {
        index++;
        if (index == 1) {
            return battery1;
        }
        if (index == 2) {
            return battery2;
        }
        if (index == 3) {
            return battery3;
        }
        throw new RuntimeException("There is no next element");
    }
}
