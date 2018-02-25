package Task_I06;

import Task_I06.Product.FoodProduct;
import Task_I06.Product.NonFoodProduct;

public interface IShoppingCartVisitor {
    double visit(FoodProduct p);

    double visit(NonFoodProduct p);
}
