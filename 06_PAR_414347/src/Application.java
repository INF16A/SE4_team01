import java.util.Timer;
import java.util.TimerTask;

public class Application {

    public static void main(String[] args) {
        IPrimeGenerator primeGenerator = new PrimeGeneratorMultiThreaded();
        PrimeProcessor pm = new PrimeProcessor();
        primeGenerator.addListener(pm);
        System.out.println("press enter to stop.");
        System.out.println("starting prime generator");
        primeGenerator.start();
        Timer tr = new Timer();
        tr.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            if (System.in.available() > 0) {
                                primeGenerator.stop();
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
