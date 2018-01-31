package taskgroup01.task47;

import org.junit.Assert;
import org.junit.Test;

public class TestAirport {
    @Test
    public void TestGetLocation() {
        Airport airport = new Airport(0);
        Assert.assertEquals(0, airport.getLocation());
    }
}
