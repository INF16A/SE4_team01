package Task_I06;

import Task_I06.Product.Product;

public class ShoppingCartOperator {
    private IShoppingCartVisitor visitor;
    private ShoppingCart cart;

    public ShoppingCartOperator(IShoppingCartVisitor visitor) {
        cart = new ShoppingCart();
        this.visitor = visitor;
    }

    public boolean pay() {
        cart.pay();
        if (cart.isPaid())
            makeReceipt();
        return cart.isPaid();
    }

    private void makeReceipt() {
        double sum = 0;
        for (Product product : cart) {
            sum = product.accept(visitor);
        }
        System.out.println("Sum: " + sum);
    }

    public boolean close() {
        cart.close();
        return cart.isClosed();
    }

    public void selectRandomProducts() {
        for (int i = 0; i < 15; i++) {
            cart.AddProduct(ProductsRepository.instance.getRandomProduct());
        }
        System.out.println("Products selected.");
    }
}
