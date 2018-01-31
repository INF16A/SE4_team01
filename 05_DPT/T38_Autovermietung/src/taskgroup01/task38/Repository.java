package taskgroup01.task38;

import taskgroup01.task38.vehicleType.*;

public class Repository {
    private V1Storage v1Storage;
    private V2Storage v2Storage;
    private V3Storage v3Storage;
    private V4Storage v4Storage;
    private V5Storage v5Storage;

    public Repository() {
        v1Storage = new V1Storage(3);
        v1Storage.appendVehicle(new V1("BS-AF1001"));
        v1Storage.appendVehicle(new V1("BS-AF1002"));
        v1Storage.appendVehicle(new V1("BS-AF1003"));

        v2Storage = new V2Storage(3);
        v2Storage.appendVehicle(new V2("BS-AF2001"));
        v2Storage.appendVehicle(new V2("BS-AF2002"));
        v2Storage.appendVehicle(new V2("BS-AF2003"));

        v3Storage = new V3Storage(3);
        v3Storage.appendVehicle(new V3("BS-AF3001"));
        v3Storage.appendVehicle(new V3("BS-AF3002"));
        v3Storage.appendVehicle(new V3("BS-AF3003"));

        v4Storage = new V4Storage(3);
        v4Storage.appendVehicle(new V4("BS-AF4001"));
        v4Storage.appendVehicle(new V4("BS-AF4002"));
        v4Storage.appendVehicle(new V4("BS-AF4003"));

        v5Storage = new V5Storage(3);
        v5Storage.appendVehicle(new V5("BS-AF5001"));
        v5Storage.appendVehicle(new V5("BS-AF5002"));
        v5Storage.appendVehicle(new V5("BS-AF5003"));
    }
}
