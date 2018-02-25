package task20;

import org.junit.Test;

public class HouseHoldTest {
    @Test
    public void testHouseHold() {
        Household h = new Household();
        h.takeHouseHoldEnergy("0101 0101 0101 0101");
        //no error = everything okay
    }
}
