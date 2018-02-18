package taskgroup01.task47;

import org.junit.Assert;
import org.junit.Test;

public class TestClimbCommand {

    @Test
    public void TestTestAirplaneInitialCounter() {
        TestClimber airplane = new TestClimber();
        Assert.assertEquals(0, airplane.callsCount);
    }

    @Test
    public void TestTestAirplaneCycleCounter() {
        TestClimber airplane = new TestClimber();
        airplane.emergencyClimb();
        Assert.assertEquals(1, airplane.callsCount);
    }

    @Test
    public void TestClimbCommandInitial() {
        TestClimber airplane = new TestClimber();
        ICommand command = new ClimbCommand(airplane);
        command.execute();
        Assert.assertEquals(1, airplane.callsCount);
    }

    private class TestClimber implements IEmergencyClimbable {
        private int callsCount = 0;

        @Override
        public void emergencyClimb() {
            callsCount++;
        }
    }

}
