import org.junit.Assert;
import org.junit.Test;

public class SorterTest {
    int[] testDataUneven = new int[]{4, 2, 3};
    int[] expectedDataUneven = new int[]{2, 3, 4};

    int[] testDataEven = new int[]{4, 2, 1, 3};
    int[] expectedDataEven = new int[]{1, 2, 3, 4};

    @Test
    public void testSortUneven() {
        Sorter instance = Sorter.getInstance();

        instance.port.sort(testDataUneven);
        Assert.assertArrayEquals(expectedDataUneven, testDataUneven);
    }

    @Test
    public void testSort() {
        Sorter instance = Sorter.getInstance();

        instance.port.sort(testDataEven);
        Assert.assertArrayEquals(expectedDataEven, testDataEven);
    }
}
