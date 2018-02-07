import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {
    @Test
    public void testGetJarPath() {
        Configuration.instance.sortingAlgorithm = "SpicySort";
        Configuration.instance.fileSeparator = "/";
        Assert.assertEquals("exchange_component_SpicySort/jar/sorter.jar", Configuration.instance.getJarPath());
    }

    @Test
    public void testGetSorterTypeFail() {
        Configuration.instance.userDirectory = null;
        Assert.assertNull(Configuration.instance.getSorterType());
    }


}
