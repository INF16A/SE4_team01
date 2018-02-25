package Task_I06.ShoppingCartStatus;

import Task_I06.ShoppingCart;

public class PaidShoppingCartStatus implements IShoppingCartStatus {
    @Override
    public boolean isClosed() {
        return true;
    }

    @Override
    public boolean isPaid() {
        return true;
    }

    @Override
    public IShoppingCartStatus close(ShoppingCart cart) {
        System.out.println("Cart already closed.");
        return this;
    }

    @Override
    public IShoppingCartStatus pay(ShoppingCart cart) {
        System.out.println("Cart already paid.");
        return this;
    }
}
