package ShoppingCarStatusTest;

import Task_I06.ShoppingCartStatus.ClosedShoppingCartStatus;
import Task_I06.ShoppingCartStatus.IShoppingCartStatus;
import Task_I06.ShoppingCartStatus.OpenShoppingCartStatus;
import org.junit.Assert;
import org.junit.Test;

public class OpenShoppingCartStatusTest {
    @Test
    public void closeTest() {
        IShoppingCartStatus status = new OpenShoppingCartStatus();
        Assert.assertTrue(ClosedShoppingCartStatus.class.isInstance(status.close(null)));
    }

    @Test
    public void payTest() {
        IShoppingCartStatus status = new OpenShoppingCartStatus();
        Assert.assertTrue(OpenShoppingCartStatus.class.isInstance(status.pay(null)));
    }

    @Test
    public void testIsPaid() {
        Assert.assertFalse(new OpenShoppingCartStatus().isPaid());
    }

    @Test
    public void testIsClosed() {
        Assert.assertFalse(new OpenShoppingCartStatus().isClosed());
    }
}
