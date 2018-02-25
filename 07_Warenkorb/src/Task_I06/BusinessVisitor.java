package Task_I06;

import Task_I06.Product.FoodProduct;
import Task_I06.Product.NonFoodProduct;

public class BusinessVisitor implements IShoppingCartVisitor {
    @Override
    public double visit(FoodProduct p) {
        return p.getPrice() * 1.07;
    }

    @Override
    public double visit(NonFoodProduct p) {
        return p.getPrice() * 1.15;
    }
}
