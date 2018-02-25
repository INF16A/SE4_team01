import Task_I06.PrivateVisitor;
import Task_I06.ShoppingCartOperator;
import org.junit.Test;

public class ShoppingCartOperatorTest {
    @Test
    public void closeCartTest() {
        ShoppingCartOperator operator = new ShoppingCartOperator(null);
        operator.close();
    }

    @Test
    public void payCartTest() {
        ShoppingCartOperator operator = new ShoppingCartOperator(null);
        operator.close();
        operator.pay();
    }

    @Test
    public void addToCartTest() {
        ShoppingCartOperator operator = new ShoppingCartOperator(null);
        operator.selectRandomProducts();
    }

    @Test
    public void printReceiptAsPrivateCustomer() {
        ShoppingCartOperator operator = new ShoppingCartOperator(new PrivateVisitor());
        operator.selectRandomProducts();
        operator.close();
        operator.pay();
    }
}
