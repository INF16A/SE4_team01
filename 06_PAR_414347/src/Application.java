import java.util.Timer;
import java.util.TimerTask;

public class Application {

    public static void main(String[] args) {
        IPrimeStrategy prime = new PrimeGeneratorMultiThreaded();
        PrimeProcessor pm = new PrimeProcessor();
        prime.addListener(pm);
        System.out.println("press any key to stop.");
        System.out.println("starting prime generator");
        prime.start();
        Timer tr = new Timer();
        tr.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            if (System.in.available() > 0) {
                                prime.stop();
                                System.out.println("stopping prime generator");
                                this.cancel();
                                tr.cancel();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 100L, 100L);
    }
}
