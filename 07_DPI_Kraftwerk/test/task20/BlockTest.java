package task20;


import org.junit.Assert;
import org.junit.Test;

public class BlockTest {
    @Test
    public void testEnergyGenerationAmountOfOnes() {
        Block b = new Block("");
        Assert.assertEquals(380, b.generateEnergy().replace("0", "").length());
    }

    @Test
    public void testEnergyGenerationNormalization() {
        IEnergyGeneration b = new BlockAdapter("");
        String expected = "010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101";
        Assert.assertEquals(expected, b.generateNormalizedEnergy());
    }
}
