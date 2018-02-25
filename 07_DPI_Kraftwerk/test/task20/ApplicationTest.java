package task20;

import org.junit.Test;

public class ApplicationTest {
    @Test
    public void singleTick() {
        EnergyCollectionPoint energyCollectionPoint = new EnergyCollectionPoint();
        PowerPlant powerPlant = new PowerPlant(energyCollectionPoint);
        ControlRoom controlRoom = new ControlRoom(powerPlant);
        powerPlant.tick();
        energyCollectionPoint.tick();
        //with 3 households and 3 blocks activated, there should be exactly 480 energy left, so no error
        energyCollectionPoint.provideEnergy(480);
    }
}
