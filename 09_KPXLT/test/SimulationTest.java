import main.Simulation;
import main.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimulationTest {
    private Simulation simulation;

    @Before
    public void before() {
        simulation = new Simulation(10, 0);
    }

    @Test
    public void step1() {
        Vehicle v = new Vehicle(0, 0);
        simulation.step1Accelerate(v);
        Assert.assertEquals(1, v.getSpeed());
    }

    @Test
    public void step2Gap() {
        Vehicle v1 = new Vehicle(0, 5);
        Vehicle v2 = new Vehicle(2, 0);
        simulation.step2CheckGap(v1, v2);
        Assert.assertEquals(1, v1.getSpeed());
    }

    @Test
    public void step2GapWithOverflow() {
        Vehicle v1 = new Vehicle(999, 5);
        Vehicle v2 = new Vehicle(0, 0);
        simulation.step2CheckGap(v1, v2);
        Assert.assertEquals(0, v1.getSpeed());
    }

    @Test
    public void step3NoLingering() {
        Vehicle v = new Vehicle(0, 0);
        simulation.step3Linger(v);
        Assert.assertEquals(0, v.getSpeed());
    }

    @Test
    public void step3WithLingering() {
        Simulation sim = new Simulation(1, 1.0f);
        Vehicle v = new Vehicle(0, 3);
        sim.step3Linger(v);
        Assert.assertEquals(2, v.getSpeed());
    }

    @Test
    public void step4() {
        Vehicle v = new Vehicle(0, 4);
        simulation.step4Drive(v);
        Assert.assertEquals(4, v.getPosition());
    }

    @Test
    public void getVehicles() {
        Assert.assertEquals(10, simulation.getVehicles().size());
    }

}
