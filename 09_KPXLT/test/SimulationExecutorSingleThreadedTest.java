import main.ISimulationExecutor;
import main.Simulation;
import main.SimulationExecutionParallel;
import main.SimulationExecutorSingleThreaded;
import org.junit.Test;

public class SimulationExecutorSingleThreadedTest {
    @Test
    public void startStop() throws InterruptedException {
        ISimulationExecutor sx = new SimulationExecutorSingleThreaded(new SimulationExecutionParallel(new Simulation(10, 0)));
        sx.start();
        Thread.sleep(100);
        sx.stop();
    }
}
