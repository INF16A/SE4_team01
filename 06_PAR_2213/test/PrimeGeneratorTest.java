import main.PrimeGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeGeneratorTest {
    PrimeGenerator pg;

    @Before
    public void before() {
        pg = new PrimeGenerator(0, 10, 2);
    }

    @Test
    public void testGeneratorSlicing() {

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            long prime = pg.nextPrime();
            //System.out.println(prime);
            result.add(prime);
        }
        //toString is easiest to implement because of type incompatibility between Arrays$ArrayList and ArrayList
        Assert.assertEquals(Arrays.asList(2L, 3, 5, 7, 23, 29, 41, 43, 47, 61, 67, 83, 89, 101, 103, 107, 109, 127, 149, 163).toString(), result.toString());
    }

    @Test
    public void testGetAsLong() {
        pg = new PrimeGenerator(10, 100, 1);
        long nextPrime = pg.nextPrime();
        pg = new PrimeGenerator(10, 100, 1);
        long getAsLong = pg.getAsLong();
        Assert.assertEquals(nextPrime, getAsLong);

    }
}
