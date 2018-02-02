package taskgroup01.task47;

import org.junit.Test;

public class TestApplicationMain {
    @Test
    public void TestMain(){
        Application.main(null);
    }
    @Test
    public void TestMainConsistency(){
        for (int i = 0; i < 100; i++) {
            Application.main(null);
        }
    }
}
