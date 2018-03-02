import main.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

    private Vehicle defaultVehicle;

    @Before
    public void setUp() {
        defaultVehicle = new Vehicle(0, 1);
    }

    @Test
    public void testSpeed() {
        defaultVehicle.setSpeed(2);
        Assert.assertEquals(2, defaultVehicle.getSpeed());
    }

    @Test
    public void testSlowDown() {
        defaultVehicle.decelerate();
        Assert.assertTrue(defaultVehicle.getSpeed() + "", 1 > defaultVehicle.getSpeed());
    }

    @Test
    public void testSpeedUp() {
        defaultVehicle.setSpeed(1);
        defaultVehicle.accelerate();
        Assert.assertTrue(defaultVehicle.getSpeed() + "", 1 < defaultVehicle.getSpeed());
    }

    @Test
    public void testSetPosition() {
        Assert.assertEquals(0, defaultVehicle.getPosition());
        defaultVehicle.setPosition(10);
        Assert.assertEquals(10, defaultVehicle.getPosition());
    }

    @Test
    public void testSetSpeedAboveMaximumFails() {
        defaultVehicle.setSpeed(1);

        defaultVehicle.setSpeed(10);
        Assert.assertEquals(1, defaultVehicle.getSpeed());
    }

    @Test
    public void testMoveForward() {
        int previousPosition = defaultVehicle.getPosition();
        defaultVehicle.moveForwards();
        int currentPosition = defaultVehicle.getPosition();
        Assert.assertTrue(previousPosition < currentPosition);
        Assert.assertEquals(previousPosition + defaultVehicle.getSpeed(), currentPosition);
    }

    @Test
    public void testWrapAround() {
        int previousPosition, nextPosition;

        for (int i = 0; i < 10_000_000; i++) {
            previousPosition = defaultVehicle.getPosition();
            defaultVehicle.moveForwards();
            nextPosition = defaultVehicle.getPosition();
            Assert.assertTrue(defaultVehicle.wrapAround > previousPosition);
            if (nextPosition > previousPosition && nextPosition == previousPosition + defaultVehicle.getSpeed()) {
                return;
            }
        }
        Assert.fail();
    }
}
