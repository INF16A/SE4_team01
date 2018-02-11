import org.junit.Assert;

import java.util.List;

public class AssertList<E> {
    public static void assertIntListContains(List<Integer> values, int... itemsToContain) {
        Assert.assertEquals(itemsToContain.length, values.size());
        for (int i = 0; i < itemsToContain.length; i++) {
            Assert.assertTrue(values.contains(itemsToContain[i]));
        }
    }

    @SafeVarargs
    public final void assertListContains(List<E> values, E... itemsToContain) {
        Assert.assertEquals(itemsToContain.length, values.size());
        for (E anItemsToContain : itemsToContain) {
            Assert.assertTrue(values.contains(anItemsToContain));
        }
    }
}



