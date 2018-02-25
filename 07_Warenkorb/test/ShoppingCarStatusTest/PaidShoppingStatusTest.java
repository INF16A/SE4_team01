package ShoppingCarStatusTest;

import Task_I06.ShoppingCartStatus.IShoppingCartStatus;
import Task_I06.ShoppingCartStatus.PaidShoppingCartStatus;
import org.junit.Assert;
import org.junit.Test;

public class PaidShoppingStatusTest {

    @Test
    public void closeTest() {
        IShoppingCartStatus status = new PaidShoppingCartStatus();
        Assert.assertTrue(PaidShoppingCartStatus.class.isInstance(status.close(null)));
    }

    @Test
    public void payTest() {
        IShoppingCartStatus status = new PaidShoppingCartStatus();
        Assert.assertTrue(PaidShoppingCartStatus.class.isInstance(status.pay(null)));
    }

    @Test
    public void testIsPaid() {
        Assert.assertTrue(new PaidShoppingCartStatus().isPaid());
    }

    @Test
    public void testIsClosed() {
        Assert.assertTrue(new PaidShoppingCartStatus().isClosed());
    }
}
