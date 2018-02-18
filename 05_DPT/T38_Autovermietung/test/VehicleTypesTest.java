import org.junit.Assert;
import org.junit.Test;
import taskgroup01.task38.Vehicle;
import taskgroup01.task38.vehicleType.*;

public class VehicleTypesTest {
    @Test
    public void testV1() {
        Vehicle car = new V1("car");
        Assert.assertEquals(1, car.getType());
    }

    @Test
    public void testV2() {
        Vehicle car = new V2("car");
        Assert.assertEquals(2, car.getType());
    }

    @Test
    public void testV3() {
        Vehicle car = new V3("car");
        Assert.assertEquals(3, car.getType());
    }

    @Test
    public void testV4() {
        Vehicle car = new V4("car");
        Assert.assertEquals(4, car.getType());
    }

    @Test
    public void testV5() {
        Vehicle car = new V5("car");
        Assert.assertEquals(5, car.getType());
    }

}
