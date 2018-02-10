import org.junit.Assert;
import org.junit.Test;
import taskgroup01.task38.Customer;

public class CustomerTest {
    @Test
    public void testName() {
        Customer customer = new Customer("test");
        Assert.assertEquals("test", customer.getName());
    }

    @Test
    public  void testToString(){
        Customer customer = new Customer("test");
        Assert.assertEquals("test", customer.toString());
    }

}
