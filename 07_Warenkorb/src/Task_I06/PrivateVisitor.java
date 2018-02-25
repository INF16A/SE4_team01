package Task_I06;

import Task_I06.Product.FoodProduct;
import Task_I06.Product.NonFoodProduct;

public class PrivateVisitor implements IShoppingCartVisitor {
    @Override
    public double visit(FoodProduct p) {
        double valueAfterTax = p.getPrice() * 1.05;
        System.out.println(p.getName() + "\t\t" + p.getPrice() + " +5%->\t" + valueAfterTax);
        return valueAfterTax;
    }

    @Override
    public double visit(NonFoodProduct p) {
        double valueAfterTax = p.getPrice() * 1.20;
        System.out.println(p.getName() + "\t\t" + p.getPrice() + " +20%->\t" + valueAfterTax);
        return valueAfterTax;
    }
}
