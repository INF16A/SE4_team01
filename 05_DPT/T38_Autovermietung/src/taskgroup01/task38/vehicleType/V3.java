package taskgroup01.task38.vehicleType;

import taskgroup01.task38.Vehicle;

public class V3 extends Vehicle {
    private final static int type = 3;

    public V3(String name) {
        super(name);
    }

    @Override
    public int getType() {
        return type;
    }
}
