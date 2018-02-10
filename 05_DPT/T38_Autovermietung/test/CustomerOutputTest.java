import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taskgroup01.task38.Customer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CustomerOutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testReservationNotification() {
        Customer c = new Customer("Hans");
        c.reservationNotification();
        String[] outLines = outContent.toString().split(System.lineSeparator());
        Assert.assertEquals("Customer Hans, your reserved car is now available.", outLines[outLines.length - 1]);
    }

    @After
    public void restoreOutStream() {
        System.setOut(System.out);
    }

}
