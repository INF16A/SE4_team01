import org.junit.Assert;
import org.junit.Test;

public class CsvParserTest {

    @Test
    public void processInputFileFail() {
        CsvParser cs = new CsvParser();
        Assert.assertEquals(0, cs.processInputFile("").size() );
    }
}
