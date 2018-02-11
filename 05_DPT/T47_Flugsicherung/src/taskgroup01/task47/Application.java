package taskgroup01.task47;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Application {

    public static int timerInterval = 50;

    public static void main(String... args) {
        IFlightControl flightControl = new FlightControl();
        Airport A = new Airport(0);
        Airport B = new Airport(1000);

        Airplane F1 = new Airplane(flightControl, "F1", 20, A);
        Airplane F2 = new Airplane(flightControl, "F2", -20, B);

        startTimer();
    }

    private static void startTimer() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            private int counter = 0;

            @Override
            public void run() {
                TimeControl.timeControl.Cycle();
                counter++;
                if (counter == 50) {
                    this.cancel();
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, timerInterval, timerInterval);
    }

    private static Random random = new Random();

    public static float getRandomChance() {
        return random.nextFloat();
    }
}
