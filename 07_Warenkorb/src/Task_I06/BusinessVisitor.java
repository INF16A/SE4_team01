package Task_I06;

import Task_I06.Product.FoodProduct;
import Task_I06.Product.NonFoodProduct;

public class BusinessVisitor implements IShoppingCartVisitor {
    @Override
    public double visit(FoodProduct p) {
        double valueAfterTax = p.getPrice() * 1.07;
        System.out.println(p.getName() + "\t\t" + p.getPrice() + " +7%->\t" + valueAfterTax);
        return valueAfterTax;
    }

    @Override
    public double visit(NonFoodProduct p) {
        double valueAfterTax = p.getPrice() * 1.15;
        System.out.println(p.getName() + "\t\t" + p.getPrice() + " +15%->\t" + valueAfterTax);
        return valueAfterTax;
    }
}
