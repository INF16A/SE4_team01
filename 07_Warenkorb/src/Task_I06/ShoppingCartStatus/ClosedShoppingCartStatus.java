package Task_I06.ShoppingCartStatus;

import Task_I06.ShoppingCart;

public class ClosedShoppingCartStatus implements IShoppingCartStatus {
    @Override
    public boolean isClosed() {
        return true;
    }

    @Override
    public boolean isPaid() {
        return false;
    }

    @Override
    public IShoppingCartStatus close(ShoppingCart cart) {
        System.out.println("Can't close a closed cart.");
        return this;
    }

    @Override
    public IShoppingCartStatus pay(ShoppingCart cart) {
        return new PaidShoppingCartStatus();
    }
}
