import Task_I06.Product.FoodProduct;
import Task_I06.Product.FoodProducts.*;
import Task_I06.Product.NonFoodProduct;
import Task_I06.Product.NonFoodProducts.*;
import Task_I06.Product.Product;
import org.junit.Assert;
import org.junit.Test;

public class NonFoodProductsTest {
    private Class[] nonFoodProducts = new Class[]{Blanket.class,
            Book.class,
            Candle.class,
            Carpet.class,
            Chair.class,
            Clock.class,
            Computer.class,
            Flower.class,
            FlowerPot.class,
            Fork.class,
            Knife.class,
            Lamp.class,
            LightBulb.class,
            Lighter.class,
            Mirror.class,
            Painting.class,
            PictureFrame.class,
            Pillow.class,
            Printer.class,
            SafetyMatches.class,
            Shampoo.class,
            Spoon.class,
            Table.class,
            Tablet.class,
            TV.class};


    @Test
    public void testNonFoodProductClasses() throws Exception {
        Class nonFoodClass = NonFoodProduct.class;
        Class foodClass = FoodProduct.class;
        for (Class c : nonFoodProducts
                ) {
            Product product = (Product) c.newInstance();
            Assert.assertTrue(nonFoodClass.isInstance(product));
            Assert.assertFalse(foodClass.isInstance(product));
        }
    }


}
