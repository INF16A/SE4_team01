import javafx.util.Pair;
import main.Calculation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculationTest {

    Calculation calc;

    @Before
    public void setup() {
        calc = new Calculation();
    }

    @Test
    public void wrongNumber() {
        Assert.assertEquals(false, calc.calculate(2212));
    }

    @Test
    public void correctNumber() {
        Assert.assertEquals(true, calc.calculate(2213));
        Assert.assertEquals(true, calc.calculate(333667001));
    }

    @Test
    public void testCallable() throws Exception {
        Calculation callableCalc = new Calculation(2213);
        Assert.assertEquals(new Pair<>(2213L, true), callableCalc.call());
        callableCalc = new Calculation(2212);
        Assert.assertEquals(new Pair<>(2212L, false), callableCalc.call());
    }
}
