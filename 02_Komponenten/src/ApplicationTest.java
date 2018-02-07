/**
 * Created by Leandro on 07.02.2018.
 */

import org.junit.After;
import org.junit.Assert;
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

    private void runApplicationWithCommand(String cmd) {
        ByteArrayInputStream in = new ByteArrayInputStream(cmd.getBytes());
        System.setIn(in);
        Application.main();
    }

    @Test
    public void startup() {
        runApplicationWithCommand("exit");
        Assert.assertEquals("Please enter a command:" + System.lineSeparator(), outContent.toString());
        //System.err.println(outContent);
    }

    @Test
    public void loadSorterFromPropsFile() {
        runApplicationWithCommand("show current component\r\nexit\r\nexit");
        System.err.println(outContent);
    }


    @After
    public void restoreOutStream() {
        System.setOut(System.out);
    }

}
