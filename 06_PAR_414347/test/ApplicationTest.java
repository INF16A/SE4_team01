import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApplicationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String runApplicationWithCommand(String cmd) {
        ByteArrayInputStream in = new ByteArrayInputStream(cmd.getBytes());
        System.setIn(in);
        Application.main(null);
        return outContent.toString();
    }


    @Before
    public void setOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void TestMainClosing() {
        runApplicationWithCommand("a" + System.lineSeparator());
    }

}
