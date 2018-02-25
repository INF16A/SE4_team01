package Task_I06;

import Task_I06.Product.FoodProduct;
import Task_I06.Product.FoodProducts.*;
import Task_I06.Product.NonFoodProduct;
import Task_I06.Product.NonFoodProducts.*;
import Task_I06.Product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsRepository {
    public static final ProductsRepository instance = new ProductsRepository();
    public final Class[] nonFoodProductClasses;
    public final Class[] foodProductClasses;
    public final Class[] productClasses = new Class[]{
            Blanket.class,
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
    private Random random = new Random();
    private ProductsRepository() {
        List<Class> nonFoodProducts = new ArrayList<>();
        List<Class> foodProducts = new ArrayList<>();
        for (Class productClass :
                productClasses) {
            try {
                Product product = (Product) productClass.newInstance();
                if (NonFoodProduct.class.isInstance(product)) {
                    nonFoodProducts.add(productClass);
                    continue;
                }
                if (FoodProduct.class.isInstance(product)) {
                    foodProducts.add(productClass);
                    continue;
                }
                System.out.println("Structural Error, skipping class: " + productClass.getSimpleName());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(" skipping class: " + productClass.getSimpleName());
            }
        }
        nonFoodProductClasses = new Class[nonFoodProducts.size()];
        nonFoodProducts.toArray(nonFoodProductClasses);
        foodProductClasses = new Class[foodProducts.size()];
        foodProducts.toArray(foodProductClasses);
    }

    public Product getRandomProduct() {
        try {
            return (Product) productClasses[random.nextInt(productClasses.length)].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

}
