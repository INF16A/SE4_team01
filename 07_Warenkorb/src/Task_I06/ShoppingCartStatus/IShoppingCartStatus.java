package Task_I06.ShoppingCartStatus;


import Task_I06.ShoppingCart;

public interface IShoppingCartStatus {

    boolean isClosed();

    boolean isPaid();

    IShoppingCartStatus close(ShoppingCart cart);

    IShoppingCartStatus pay(ShoppingCart cart);
}
