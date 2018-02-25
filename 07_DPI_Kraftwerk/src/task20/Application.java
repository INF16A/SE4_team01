package task20;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        EnergyCollectionPoint energyCollectionPoint = new EnergyCollectionPoint();
        PowerPlant powerPlant = new PowerPlant(energyCollectionPoint);
        ControlRoom controlRoom = new ControlRoom(powerPlant);
        while(true) {
            powerPlant.tick();
            energyCollectionPoint.tick();
            Thread.sleep(1000);
        }
    }
}
