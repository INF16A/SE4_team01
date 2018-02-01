import org.junit.Assert;

import java.util.Map;

public class AssertMap<K, V> {
    public void AssertMapContains(Map<K, V> values, Map<K, V> itemsToContain) {
        Assert.assertEquals(itemsToContain.size(), values.size());
        values.forEach((K, V) -> {
            Assert.assertTrue(itemsToContain.containsKey(K));
            Assert.assertEquals(itemsToContain.get(K), V);
        });
    }
}