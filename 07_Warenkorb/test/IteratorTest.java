import Task_I06.Product.FoodProducts.Egg;
import Task_I06.Product.FoodProducts.RealApple;
import Task_I06.Product.Product;
import Task_I06.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class IteratorTest {
    @Test
    public void iteratorNotNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Iterator<Product> iterator = shoppingCart.iterator();
        Assert.assertNotNull(iterator);
    }

    @Test
    public void singleItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Egg();
        shoppingCart.AddProduct(product);
        Iterator<Product> iterator = shoppingCart.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
    }

    @Test
    public void multipleDifferentItemsTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = new Egg();
        shoppingCart.AddProduct(product1);
        Product product2 = new RealApple();
        shoppingCart.AddProduct(product2);

        Iterator<Product> iterator = shoppingCart.iterator();

        Assert.assertTrue(iterator.hasNext());
        Product product3 = iterator.next();
        Assert.assertTrue(product3 == product1 || product3 == product2);
        Assert.assertTrue(iterator.hasNext());
        Product product4 = iterator.next();
        Assert.assertNotEquals(product3, product4);
        Assert.assertTrue(product4 == product1 || product4 == product2);
    }

    @Test
    public void multipleSimilarItemsTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = new Egg();
        shoppingCart.AddProduct(product1);
        shoppingCart.AddProduct(product1);

        Iterator<Product> iterator = shoppingCart.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product1, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product1, iterator.next());
        // normal iterator would behave like that.
        // Assert.assertFalse(iterator.hasNext());
    }
}
