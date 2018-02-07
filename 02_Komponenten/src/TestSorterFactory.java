import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSorterFactory {


    @Test
    public void testFactory() {
        Configuration.instance.className = "Sorter";
        Assert.assertNotNull(SorterFactory.create());
    }

    @Test
    public void testFactoryFail() {
        Configuration.instance.className = null;
        Assert.assertNull(SorterFactory.create());
    }
}
