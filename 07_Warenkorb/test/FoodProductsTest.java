import Task_I06.Product.FoodProduct;
import Task_I06.Product.FoodProducts.*;
import Task_I06.Product.NonFoodProduct;
import Task_I06.Product.Product;
import org.junit.Assert;
import org.junit.Test;

public class FoodProductsTest {
    private Class[] foodProducts = new Class[]{
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
    public void testFoodProductClasses() throws Exception {
        Class nonFoodClass = NonFoodProduct.class;
        Class foodClass = FoodProduct.class;
        for (Class c : foodProducts
                ) {
            Product product = (Product) c.newInstance();
            Assert.assertFalse(nonFoodClass.isInstance(product));
            Assert.assertTrue(foodClass.isInstance(product));
        }
    }
}
