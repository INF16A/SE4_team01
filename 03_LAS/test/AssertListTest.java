import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AssertListTest {
    @Test
    public void TestIntListContainsSequenceMatch() {
        int[] rawData = new int[]{1, 2, 3};
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3});
        AssertList.AssertIntListContains(list, rawData);
    }
    @Test
    public void TestIntListContainsUnordered() {
        int[] rawData = new int[]{3,2,1};
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3});
        AssertList.AssertIntListContains(list, rawData);
    }
    @Test
    public void TestIntListContainsFail() {
        try {
            int[] rawData = new int[]{1, 2, 3};
            List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3});
            AssertList.AssertIntListContains(list, rawData);

            Assert.fail();
        }
        catch (Exception e){

        }
    }
}

