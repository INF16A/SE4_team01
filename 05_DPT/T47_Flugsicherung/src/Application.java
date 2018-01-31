import java.util.Random;

public class Application {
    public static void main(String... args) {
        IFlightControl flightControl = new FlightControl();
        Airplane F1 = new Airplane(flightControl,"F1");
        Airplane F2 = new Airplane(flightControl,"F2");
        Airport A = new Airport(flightControl, 0);
        Airport B = new Airport(flightControl, 1000);

    }

    private static Random random = new Random();

    public static float GetRandomChance() {
        return random.nextFloat();
    }
}
