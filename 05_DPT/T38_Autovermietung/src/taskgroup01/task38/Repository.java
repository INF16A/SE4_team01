package taskgroup01.task38;

import taskgroup01.task38.VehicleTypes.V1;
import taskgroup01.task38.VehicleTypes.V1Iterator;
import taskgroup01.task38.VehicleTypes.V1Storage;

public class Repository {
    V1Iterator v1Iterator;
    V1Storage v1Storage;

    public Repository() {
        v1Storage = new V1Storage(3);
        v1Iterator = new V1Iterator(v1Storage);
        v1Storage.appendVehicle(new V1("HN-AB1234"));
        v1Storage.appendVehicle(new V1("HN-AB1337"));
        v1Storage.appendVehicle(new V1("HN-AB4242"));
    }
}
