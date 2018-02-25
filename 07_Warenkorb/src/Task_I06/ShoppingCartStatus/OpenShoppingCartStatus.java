package Task_I06.ShoppingCartStatus;

import Task_I06.ShoppingCart;

public class OpenShoppingCartStatus implements IShoppingCartStatus {
    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public boolean isPaid() {
        return false;
    }

    @Override
    public IShoppingCartStatus close(ShoppingCart cart) {
        return new ClosedShoppingCartStatus();

    }

    @Override
    public IShoppingCartStatus pay(ShoppingCart cart) {
        System.out.println("Can't pay an open cart");
        return this;
    }
}
