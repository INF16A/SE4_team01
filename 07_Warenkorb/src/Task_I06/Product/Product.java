package Task_I06.Product;

import Task_I06.IShoppingCartVisitor;

public abstract class Product {
    public abstract double getPrice();

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public abstract double accept(IShoppingCartVisitor visitor);

}
