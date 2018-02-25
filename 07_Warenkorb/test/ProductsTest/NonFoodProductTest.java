package ProductsTest;

import Task_I06.Product.NonFoodProduct;
import Task_I06.Product.Product;
import Task_I06.ProductsRepository;
import org.junit.Assert;
import org.junit.Test;

public class NonFoodProductTest {
    @Test
    public void NonFoodProductsStructuralTest() throws Exception {
        for (Class c : ProductsRepository.instance.nonFoodProductClasses) {
            Product product = (Product) c.newInstance();
            Assert.assertTrue(NonFoodProduct.class.isInstance(product));
        }
    }
}
