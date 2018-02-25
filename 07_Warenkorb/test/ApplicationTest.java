import Task_I06.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApplicationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    private String runApplicationWithCommand(String cmd) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(cmd.getBytes());
        System.setIn(in);
        Application.main(null);
        return outContent.toString();
    }

    @Test
    public void ApplicationValidInputTest() throws Exception {
        runApplicationWithCommand(
                "y" + System.lineSeparator() +
                        "choose" + System.lineSeparator() +
                        "close" + System.lineSeparator() +
                        "pay" + System.lineSeparator());

    }

    @Test
    public void ApplicationTypoTest() throws Exception {
        runApplicationWithCommand(
                "y" + System.lineSeparator() +
                        "chooose" + System.lineSeparator() +
                        "choose" + System.lineSeparator() +
                        "close" + System.lineSeparator() +
                        "pay" + System.lineSeparator());
    }


    @Test
    public void ApplicationPayOnlyTest() throws Exception {
        runApplicationWithCommand(
                "y" + System.lineSeparator() +
                        "pay" + System.lineSeparator());
    }


    @After
    public void restoreOutStream() {
        System.setOut(System.out);
    }
}

