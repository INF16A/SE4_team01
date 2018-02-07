import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigurationFileTest {

    private Properties prop = new Properties();

    @Test
    public void testIntroSortType() {
        prop.setProperty("sorterType", "intro");
        store();

        Assert.assertEquals(SorterType.intro, Configuration.instance.getSorterType());
    }

    @Test
    public void testShakerSortType() {
        prop.setProperty("sorterType", "shaker");
        store();

        Assert.assertEquals(SorterType.shaker, Configuration.instance.getSorterType());
    }

    @After
    public void restoreValues() {
        prop.setProperty("sorterType", "shaker");
        store();
    }

    @Test
    public void testPropertyStoreFail() {
        try {
            prop = null;
            store();
            Assert.fail();
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void testPropertyRestoreFail() {
        try {
            prop = null;
            restoreValues();
            Assert.fail();
        } catch (RuntimeException e) {

        }
    }

    private void store() {
        try {
            FileOutputStream fos = new FileOutputStream(Configuration.instance.userDirectory + Configuration.instance.fileSeparator + Configuration.instance.propFile);
            prop.store(fos, "");
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
