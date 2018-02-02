import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class AssertMapTest {
    @Test
    public void TestMapContainsSequenceMatch() {
        Map<Integer, Character> map = new TreeMap<>();
        map.put(1, 'A');
        map.put(2, 'B');

        Map<Integer, Character> testMap = new TreeMap<>();
        testMap.put(2, 'B');
        testMap.put(1, 'A');

        new AssertMap<Integer, Character>().AssertMapContains(map, testMap);
    }

    @Test
    public void TestMapContainsUnordered() {
        Map<Integer, Character> map = new TreeMap<>();
        map.put(1, 'A');
        map.put(2, 'B');

        Map<Integer, Character> testMap = new TreeMap<>();
        testMap.put(1, 'A');
        testMap.put(2, 'B');

        new AssertMap<Integer, Character>().AssertMapContains(map, testMap);
    }

    @Test
    public void TestMapContainsFail() {
        try {
            Map<Integer, Character> map = new TreeMap<>();
            map.put(1, 'A');
            map.put(2, 'B');

            Map<Integer, Character> testMap = new TreeMap<>();
            testMap.put(2, 'B');

            new AssertMap<Integer, Character>().AssertMapContains(map, testMap);
            Assert.fail();
        } catch (AssertionError e) {
            //works
        }
    }
}
