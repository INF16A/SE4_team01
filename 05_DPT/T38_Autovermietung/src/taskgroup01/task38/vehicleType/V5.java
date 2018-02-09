package taskgroup01.task38.vehicleType;

import taskgroup01.task38.Vehicle;

public class V5 extends Vehicle {
    private int type = 5;

    public V5(String name) {
        super(name);
    }

    @Override
    public int getType() {
        return type;
    }
}
