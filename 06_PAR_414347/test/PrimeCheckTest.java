import org.junit.Assert;
import org.junit.Test;

public class PrimeCheckTest {
    @Test
    public void testPrime414347() {
        Assert.assertTrue(PrimeCheck.check("414347"));
    }

    @Test
    public void testPrime71113() {
        Assert.assertTrue(PrimeCheck.check("71113"));
    }


    @Test
    public void testPrime235Negative() {
        Assert.assertFalse(PrimeCheck.check("235"));
    }
}
