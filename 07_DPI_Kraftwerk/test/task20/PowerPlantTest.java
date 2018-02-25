package task20;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PowerPlantTest {
    private PowerPlant pp;

    @Before
    public void before() {
        pp = new PowerPlant(new EnergyCollectionPoint());
    }

    @Test
    public void blockActivation() {
        pp.activateBlock(0);
        Assert.assertEquals(true, pp.blockIsActivated(0));
    }

    @Test
    public void blockDeactivation() {
        pp.deactivateBlock(0);
        Assert.assertEquals(false, pp.blockIsActivated(0));
    }
}
