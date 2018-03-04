import main.ISimulationExecution;
import main.Simulation;
import main.SimulationExecutionParallel;
import org.junit.Test;

public class SimulationExecutionParallelTest {

    @Test
    public void step() {
        ISimulationExecution sep = new SimulationExecutionParallel(new Simulation(2,0));
        sep.step();
        //throws no exception. is magic
    }

}
