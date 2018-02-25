import Task_I06.Product.Product;
import Task_I06.ProductsRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ProductRepositoryTest {
    @Test
    public void generateRandomProductTest() {
        Product product = ProductsRepository.instance.getRandomProduct();
        Assert.assertTrue(Arrays.stream(ProductsRepository.instance.productClasses).anyMatch(i -> i.isInstance(product)));
    }
}
