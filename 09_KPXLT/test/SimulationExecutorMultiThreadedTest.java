import main.ISimulationExecutor;
import main.Simulation;
import main.SimulationExecutionParallel;
import main.SimulationExecutorMultiThreaded;
import org.junit.Test;

public class SimulationExecutorMultiThreadedTest {
    @Test
    public void startStop() throws InterruptedException {
        ISimulationExecutor sx = new SimulationExecutorMultiThreaded(new SimulationExecutionParallel(new Simulation(10, 0)));
        sx.start();
        Thread.sleep(100);
        sx.stop();
    }
}
