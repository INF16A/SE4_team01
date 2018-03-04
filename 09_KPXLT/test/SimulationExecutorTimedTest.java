import main.*;
import org.junit.Test;

public class SimulationExecutorTimedTest {
    @Test
    public void startStop() throws InterruptedException {
        ISimulationExecutor sx = new SimulationExecutorTimed(new SimulationExecutionParallel(new Simulation(10, 0)), 10);
        sx.start();
        Thread.sleep(100);
        sx.stop();
    }
}
