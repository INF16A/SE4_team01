package taskgroup01.task38.vehicleType;

import taskgroup01.task38.Vehicle;

public class V1 extends Vehicle {
    private final static int type = 1;
    public V1(String name) {
        super(name);
    }

    @Override
    public int getType() {
        return type;
    }
}
