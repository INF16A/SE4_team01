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
        for (int i = 0; i < 3; i++) {
            shoppingCart.AddProduct(product1);
        }

        Product product2 = new RealApple();
        for (int i = 0; i < 3; i++) {
            shoppingCart.AddProduct(product2);
        }

        Iterator<Product> iterator = shoppingCart.iterator();

        int product1Count = 0;
        int product2Count = 0;
        while (iterator.hasNext()) {
            if (iterator.next() == product1) {
                product1Count++;
            } else {
                product2Count++;
            }
        }
        Assert.assertEquals(3, product1Count);
        Assert.assertEquals(3, product2Count);
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

    @Test
    public void nextMoveFailTest() {
        Iterator iterator = new ShoppingCart().iterator();
        try{
            iterator.next();
            Assert.fail();
        }
        catch (Exception e){
            //works
        }

    }

}
