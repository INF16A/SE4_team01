package taskgroup01.task38.vehicleType;

import taskgroup01.task38.Vehicle;

public class V2 extends Vehicle {
    private int type = 2;

    public V2(String name) {
        super(name);
    }

    @Override
    public int getType() {
        return type;
    }
}
