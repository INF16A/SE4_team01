package ProductsTest;

import Task_I06.Product.FoodProduct;
import Task_I06.Product.Product;
import Task_I06.ProductsRepository;
import org.junit.Assert;
import org.junit.Test;

public class FoodProductsTest {
    @Test
    public void FoodProductsStructuralTest() throws Exception {
        for (Class c : ProductsRepository.instance.foodProductClasses) {
            Product product = (Product) c.newInstance();
            Assert.assertTrue(FoodProduct.class.isInstance(product));
        }
    }
}
