package taskgroup01.task47;

import java.util.Random;

public class Application {
    public static void main(String... args) {
        IFlightControl flightControl = new FlightControl();
        Airport A = new Airport(0);
        Airport B = new Airport(1000);

        Airplane F1 = new Airplane(flightControl, "F1", 20, A);
        Airplane F2 = new Airplane(flightControl, "F2", -20, B);

        for (int i = 0; i < 50; i++) {
            TimeControl.timeControl.Cycle();
        }
    }

    private static Random random = new Random();

    public static float GetRandomChance() {
        return random.nextFloat();
    }
}
