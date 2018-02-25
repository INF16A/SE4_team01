import Task_I06.Product.FoodProducts.Egg;
import Task_I06.Product.Product;
import Task_I06.ShoppingCart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShoppingCartTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void AddProductTest() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Egg();
        cart.AddProduct(product);
    }

    @Test
    public void AddProductToClosedCartTest() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Egg();
        cart.close();
        cart.AddProduct(product);
        Assert.assertTrue(outContent.toString(), outContent.toString().contains("Can't add a product to a closed cart"));
    }

    @Test
    public void AddProductToPaidCartTest() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Egg();
        cart.close();
        cart.pay();
        cart.AddProduct(product);
        Assert.assertTrue(outContent.toString(), outContent.toString().contains("Can't add a product to a closed cart"));
    }

    @Test
    public void PayOpenCartTest() {
        ShoppingCart cart = new ShoppingCart();
        cart.pay();
        Assert.assertTrue(outContent.toString(), outContent.toString().contains("Can't pay an open cart"));
    }
}

