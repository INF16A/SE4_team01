import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AssertListTest {
    @Test
    public void testIntListContainsSequenceMatch() {
        int[] rawData = new int[]{1, 2, 3};
        List<Integer> list = Arrays.asList(1, 2, 3);
        AssertList.assertIntListContains(list, rawData);
    }

    @Test
    public void testIntListContainsUnordered() {
        int[] rawData = new int[]{3, 2, 1};
        List<Integer> list = Arrays.asList(1, 2, 3);
        AssertList.assertIntListContains(list, rawData);
    }

    @Test
    public void testIntListContainsFail() {
        try {
            int[] rawData = new int[]{1, 2, 3};
            List<Integer> list = Arrays.asList(2, 2, 3);
            AssertList.assertIntListContains(list, rawData);

            Assert.fail();
        } catch (AssertionError e) {
            //works
        }
    }


    @Test
    public void testListContainsSequenceMatch() {
        Integer[] rawData = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.asList(rawData);
        new AssertList().assertListContains(list, (Object[]) rawData);
    }

    @Test
    public void testListContainsUnordered() {
        Integer[] rawData = new Integer[]{3, 2, 1};
        List<Integer> list = Arrays.asList(1, 2, 3);
        new AssertList().assertListContains(list, (Object[]) rawData);
    }

    @Test
    public void testListContainsFail() {
        try {
            Integer[] rawData = new Integer[]{1, 2, 3};
            List<Integer> list = Arrays.asList(2, 2, 3);
            new AssertList().assertListContains(list, (Object[]) rawData);

            Assert.fail();
        } catch (AssertionError e) {
            //works
        }
    }
}


