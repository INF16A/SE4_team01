package task20;

import java.util.ArrayList;
import java.util.List;

public class EnergyCollectionPoint {
    private List<IHouseHold> connectedHouseHolds = new ArrayList<>();
    private String energyStorage = "";

    EnergyCollectionPoint() {
        connectedHouseHolds.add(new HouseholdAdapter(this));
        connectedHouseHolds.add(new HouseholdAdapter(this));
        connectedHouseHolds.add(new HouseholdAdapter(this));

        System.out.print(connectedHouseHolds.size());
        System.out.print(" households connected to the collection point, drawing ");
        System.out.print(connectedHouseHolds.size() * 220);
        System.out.println(" units of energy per second");
    }

    void tick() {
        for(IHouseHold hh : connectedHouseHolds) {
            hh.useEnergy();
        }
        System.out.print("Current energy stored: ");
        System.out.println(energyStorage.length() / 2);
    }

    void acceptEnergy(String energy) {
        energyStorage += energy;
    }

    String provideEnergy(int length) {
        String energyPacket = energyStorage.substring(0, length * 2); //*2 because numbers of ones count
        energyStorage = energyStorage.substring(length * 2); //remove energy packet from storage
        return energyPacket;
    }

}
