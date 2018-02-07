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

public class TestApplication {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    private String runApplicationWithCommand(String cmd) {
        ByteArrayInputStream in = new ByteArrayInputStream(cmd.getBytes());
        System.setIn(in);
        Application.main();
        String[] outLines = outContent.toString().split(System.lineSeparator());
        return outLines[outLines.length - 1];
    }

    @Test
    public void startup() {
        String result = runApplicationWithCommand("exit");
        Assert.assertEquals("Please enter a command:", result);
        //System.err.println(outContent);
    }

    @Test
    public void listSorters() {
        String result = runApplicationWithCommand(
                "show components" + System.lineSeparator() +
                        "exit");
        Assert.assertEquals("intro, shaker", result);
    }

    @Test
    public void loadSorterFromPropsFile() {
        String result = runApplicationWithCommand("show current component" + System.lineSeparator() + "exit");
        Assert.assertEquals("current component: ShakerSort", result);
    }

    @Test
    public void switchSorter() {
        String result = runApplicationWithCommand(
                "set current component intro" + System.lineSeparator() +
                        "show current component" + System.lineSeparator() +
                        "exit");
        Assert.assertEquals("current component: IntroSort", result);
    }

    @Test
    public void executeShakerSort() {
        String result = runApplicationWithCommand(
                "execute 4,2,3,1" + System.lineSeparator() +
                        "exit");
        Assert.assertEquals("1,2,3,4", result);
    }

    @Test
    public void executeIntroSort() {
        String result = runApplicationWithCommand(
                "set current component intro" + System.lineSeparator() +
                        "execute 4,2,3,1" + System.lineSeparator() +
                        "exit");
        Assert.assertEquals("1,2,3,4", result);
    }

    @Test
    public void invalidNumberInput() {
        String result = runApplicationWithCommand(
                "execute a,2,3,1" + System.lineSeparator() +
                        "exit");
        Assert.assertEquals("Invalid number input", result);
    }


    @After
    public void restoreOutStream() {
        System.setOut(System.out);
    }

}
