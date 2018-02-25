package ProductsTest;

import Task_I06.Product.Product;
import Task_I06.ProductsRepository;
import org.junit.Assert;
import org.junit.Test;

public class ProductsTest {

    @Test
    public void testPrices() throws Exception {
        for (Class c : ProductsRepository.instance.productClasses) {
            Product product = (Product) c.newInstance();
            Assert.assertTrue(product.getPrice() > 0);
            Assert.assertTrue(Double.isFinite(product.getPrice()));
        }
    }

    @Test
    public void testNames() throws Exception {
        for (Class c : ProductsRepository.instance.productClasses
                ) {
            Product product = (Product) c.newInstance();
            Assert.assertTrue(product.getName().length() > 0);
        }
    }
}
