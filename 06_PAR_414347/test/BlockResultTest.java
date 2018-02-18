import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class BlockResultTest {
    @Test
    public void testBlockStart() {
        BlockResult result = new BlockResult(BigInteger.ZERO, null, null);
        Assert.assertEquals(BigInteger.ZERO, result.getBlockStart());
    }

    @Test
    public void testNextBlockStart() {
        BlockResult result = new BlockResult(BigInteger.ZERO, BigInteger.TEN, null);
        Assert.assertEquals(BigInteger.TEN, result.getNextBlockStart());
    }

    @Test
    public void testPrimes() {
        BlockResult result = new BlockResult(BigInteger.ZERO, BigInteger.TEN, null);
        Assert.assertNull(result.getPrimes());
    }

    @Test
    public void testComparison() {
        BlockResult result1 = new BlockResult(BigInteger.ZERO, BigInteger.TEN, null);
        BlockResult result2 = new BlockResult(BigInteger.ONE, BigInteger.TEN, null);

        Assert.assertEquals(-1, result1.compareTo(result2));
    }

    @Test
    public void testComparisoneSelf() {
        BlockResult result1 = new BlockResult(BigInteger.ZERO, BigInteger.TEN, null);

        Assert.assertEquals(0, result1.compareTo(result1));
    }
}
