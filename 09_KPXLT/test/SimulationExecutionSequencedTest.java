import main.ISimulationExecution;
import main.Simulation;
import main.SimulationExecutionParallel;
import main.SimulationExecutionSequenced;
import org.junit.Test;

public class SimulationExecutionSequencedTest {

    @Test
    public void step() {
        ISimulationExecution sep = new SimulationExecutionSequenced(new Simulation(2,0));
        sep.step();
        //throws no exception. is magic
    }

}
