package task20;

public class HouseholdAdapter extends Household implements IHouseHold {

    private EnergyCollectionPoint energyCollectionPoint;

    HouseholdAdapter(EnergyCollectionPoint ecp) {
        energyCollectionPoint = ecp;
    }

    @Override
    public void useEnergy() {
        String energy = energyCollectionPoint.provideEnergy(220);
        energy = energy.replace("0101", "0101 ");
        takeHouseHoldEnergy(energy);
    }
}
