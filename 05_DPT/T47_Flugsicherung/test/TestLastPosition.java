import org.junit.Assert;
import org.junit.Test;

public class TestLastPosition {
    @Test
    public void testConstructor() {
        LastPosition lp = new LastPosition(0, 0);
        Assert.assertEquals(0, lp.pos);
        Assert.assertEquals(0, lp.height);
    }
}
