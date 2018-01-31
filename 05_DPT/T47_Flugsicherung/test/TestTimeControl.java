import org.junit.Assert;
import org.junit.Test;

public class TestTimeControl {
    @Test
    public void TestTimeControlCounterInitial() {
        TimeControl tc = new TimeControl();
        Assert.assertEquals(0, tc.getTicksCount());
    }

    @Test
    public void TestTimeControlCounterCycle() {
        TimeControl tc = new TimeControl();
        tc.Cycle();
        Assert.assertEquals(1, tc.getTicksCount());
    }

    @Test
    public void TestTimeControlTestObjectInitial() {
        TimeControl tc = new TimeControl();
        testTimeControlledObject testObject = new testTimeControlledObject();
        tc.Cycle();
        tc.AddToTimeControl(testObject);
        Assert.assertEquals(0, testObject.callsCount);
    }

    @Test
    public void TestTimeControlTestObjectCycle() {
        TimeControl tc = new TimeControl();
        testTimeControlledObject testObject = new testTimeControlledObject();
        tc.AddToTimeControl(testObject);
        tc.Cycle();
        Assert.assertEquals(1, testObject.callsCount);
    }
    @Test
    public void TestTestTimeControlInitial() {
        testTimeControlledObject testTimeControlledObject = new testTimeControlledObject();
        Assert.assertEquals(0, testTimeControlledObject.callsCount);
    }

    @Test
    public void TestTestTimeControlCycle() {
        testTimeControlledObject testTimeControlledObject = new testTimeControlledObject();
        testTimeControlledObject.Cycle();
        Assert.assertEquals(1, testTimeControlledObject.callsCount);
    }
    private class testTimeControlledObject implements ITimeControlled {
        private int callsCount = 0;

        @Override
        public void Cycle() {
            callsCount++;
        }


    }
}
