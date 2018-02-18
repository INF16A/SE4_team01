import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

public class PrimeProcessorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrimeProcessing() {
        PrimeProcessor primeProcessor = new PrimeProcessor();
        primeProcessor.primeGenerated(new BigInteger("7"));
        primeProcessor.primeGenerated(new BigInteger("11"));
        primeProcessor.primeGenerated(new BigInteger("13"));
        primeProcessor.primeGeneratorStopped();
        Assert.assertTrue(outContent.toString().contains("71113"));
    }

    @Test
    public void testPrimeProcessingNegative() {
        PrimeProcessor primeProcessor = new PrimeProcessor();
        primeProcessor.primeGenerated(new BigInteger("2"));
        primeProcessor.primeGenerated(new BigInteger("3"));
        primeProcessor.primeGenerated(new BigInteger("5"));
        primeProcessor.primeGeneratorStopped();
        Assert.assertFalse(outContent.toString().contains("235"));
    }
}
