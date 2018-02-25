package task20;

public class ControlRoom {
    private PowerPlant powerPlant;

    public ControlRoom(PowerPlant pp) {
        powerPlant = pp;

        powerPlant.activateBlock(0);
        powerPlant.activateBlock(1);
        powerPlant.activateBlock(3);
    }
}
