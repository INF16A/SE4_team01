package taskgroup01.task47;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestApplicationMain {

    @Before
    public void setUp() {
        Application.timerInterval = 10;
    }

    @Test
    public void TestMain() {
        Application.main((String) null);
    }

    @Test
    public void TestMainConsistency() {
        for (int i = 0; i < 100; i++) {
            Application.main((String) null);
        }
    }

    @After
    public void tearDown() {
        Application.timerInterval = 1000;
    }
}
