import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {


    private String sortingAlgorithm, fileSeparator, userDirectory;

    @Before
    public void saveConfig() {
        sortingAlgorithm = Configuration.instance.sortingAlgorithm;
        fileSeparator = Configuration.instance.fileSeparator;
        userDirectory = Configuration.instance.userDirectory;
    }

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

    @After
    public void restoreConfiguration() {
        Configuration.instance.sortingAlgorithm = sortingAlgorithm;
        Configuration.instance.fileSeparator = fileSeparator;
        Configuration.instance.userDirectory = userDirectory;
    }

}
