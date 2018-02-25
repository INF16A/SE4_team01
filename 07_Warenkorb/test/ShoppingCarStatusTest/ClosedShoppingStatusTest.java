package ShoppingCarStatusTest;

import Task_I06.ShoppingCartStatus.ClosedShoppingCartStatus;
import Task_I06.ShoppingCartStatus.IShoppingCartStatus;
import Task_I06.ShoppingCartStatus.PaidShoppingCartStatus;
import org.junit.Assert;
import org.junit.Test;

public class ClosedShoppingStatusTest {
    @Test
    public void closeTest() {
        IShoppingCartStatus status = new ClosedShoppingCartStatus();
        Assert.assertTrue(ClosedShoppingCartStatus.class.isInstance(status.close(null)));
    }

    @Test
    public void payTest() {
        IShoppingCartStatus status = new ClosedShoppingCartStatus();
        Assert.assertTrue(PaidShoppingCartStatus.class.isInstance(status.pay(null)));
    }

    @Test
    public void testIsPaid() {
        Assert.assertFalse(new ClosedShoppingCartStatus().isPaid());
    }

    @Test
    public void testIsClosed() {
        Assert.assertTrue(new ClosedShoppingCartStatus().isClosed());
    }
}
