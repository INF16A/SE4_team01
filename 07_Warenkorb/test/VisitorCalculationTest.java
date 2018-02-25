import Task_I06.BusinessVisitor;
import Task_I06.IShoppingCartVisitor;
import Task_I06.PrivateVisitor;
import Task_I06.Product.FoodProduct;
import Task_I06.Product.NonFoodProduct;
import org.junit.Assert;
import org.junit.Test;

public class VisitorCalculationTest {
    @Test
    public void testFoodBusinessVisitorCalculation() {
        IShoppingCartVisitor visitor = new BusinessVisitor();
        Assert.assertEquals(visitor.visit(new FoodProduct() {
            @Override
            public double getPrice() {
                return 100;
            }
        }), 107, 1e-3);
    }

    @Test
    public void testFoodPrivateVisitorCalculation() {
        IShoppingCartVisitor visitor = new PrivateVisitor();
        Assert.assertEquals(visitor.visit(new FoodProduct() {
            @Override
            public double getPrice() {
                return 100;
            }
        }), 105, 1e-3);
    }

    @Test
    public void testNonFoodBusinessVisitorCalculation() {
        IShoppingCartVisitor visitor = new BusinessVisitor();
        Assert.assertEquals(visitor.visit(new NonFoodProduct() {
            @Override
            public double getPrice() {
                return 100;
            }
        }), 115, 1e-3);
    }
    @Test
    public void testNonFoodPrivateVisitorCalculation() {
        IShoppingCartVisitor visitor = new PrivateVisitor();
        Assert.assertEquals(visitor.visit(new NonFoodProduct() {
            @Override
            public double getPrice() {
                return 100;
            }
        }), 120, 1e-3);
    }
}
