package taskgroup01.task38.vehicleType;

import taskgroup01.task38.Vehicle;

public class V4 extends Vehicle {
    private final static int type = 4;

    public V4(String name) {
        super(name);
    }

    @Override
    public int getType() {
        return type;
    }
}
