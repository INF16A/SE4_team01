import main.*;
import org.junit.Test;

public class SimulationExecutorTest {
    @Test
    public void listenerTest() {
        ISimulationObserver observer = () -> {}; //lambda implementation for empty observer function is cool
        SimulationExecutor sx = new SimulationExecutorSingleThreaded(new SimulationExecutionParallel(new Simulation(10,0)));
        sx.addListener(observer);
        sx.removeListener(observer);
    }
}
