package taskgroup01.task47;

import org.junit.Assert;
import org.junit.Test;

public class TestRandomChanceProvider {
    @Test
    public void TestRandomChanceInBounds() {
        double chance = Application.getRandomChance();
        Assert.assertTrue(0 <= chance);
        Assert.assertTrue(1 >= chance);
    }
}
