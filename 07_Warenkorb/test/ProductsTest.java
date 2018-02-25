import Task_I06.Product.FoodProducts.*;
import Task_I06.Product.NonFoodProducts.*;
import Task_I06.Product.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductsTest {
    private Class[] products = new Class[]{Blanket.class,
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
            TV.class,
            Banana.class,
            Bread.class,
            Cake.class,
            Carrot.class,
            Cheese.class,
            Coffee.class,
            Cookie.class,
            Egg.class,
            Fish.class,
            IceCream.class,
            Juice.class,
            Lemon.class,
            Milk.class,
            Mushroom.class,
            Oil.class,
            Orange.class,
            Pear.class,
            PineApple.class,
            RealApple.class,
            Salt.class,
            Sausage.class,
            SparklingWater.class,
            Strawberry.class,
            Tea.class,
            Wine.class
    };

    @Test
    public void testPrices() throws Exception {
        for (Class c : products
                ) {
            Product product = (Product) c.newInstance();
            Assert.assertTrue(product.getPrice() > 0);
            Assert.assertTrue(Double.isFinite(product.getPrice()));
        }
    }

    @Test
    public void testNames() throws Exception {
        for (Class c : products
                ) {
            Product product = (Product) c.newInstance();
            Assert.assertTrue(product.getName().length() > 0);
        }
    }
}
