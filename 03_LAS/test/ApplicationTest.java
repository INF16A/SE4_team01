import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class ApplicationTest {

    @Test
    public void TestAssertListContainsLength() {
    }

    @Before
    public void setUp() throws Exception {
        query = new Application();
    }

    IQuery query;

    @Test
    public void executeSQL01() {
        Assert.assertEquals(1_000_000, query.executeSQL01());
    }

    @Test
    public void executeSQL02() {
        Assert.assertEquals(65_157, query.executeSQL02());

    }

    @Test
    public void executeSQL03() {
        Assert.assertEquals(25174, query.executeSQL03());
    }

    @Test
    public void executeSQL04() {
        Assert.assertEquals(273, query.executeSQL04());

    }

    @Test
    public void executeSQL05() {
        AssertList.AssertIntListContains(query.executeSQL05(), 614041, 651807, 798192);
    }

    @Test
    public void executeSQL06() {
        AssertList.AssertIntListContains(query.executeSQL06(), 970370);
    }

    @Test
    public void executeSQL07() {
        Map<Character, Long> m = new TreeMap<>();
        m.put('D', 126065L);
        m.put('G', 153623L);
        m.put('C', 118360L);
        m.put('A', 181494L);
        m.put('E', 135157L);
        m.put('B', 135671L);
        m.put('F', 149630L);
        new AssertMap<Character,Long>().AssertMapContains(query.executeSQL07(), m);
    }

    @Test
    public void executeSQL08() {
        Map<Integer, Long> m = new TreeMap<>();
        m.put(6, 113L);
        m.put(9, 111L);
        m.put(8, 108L);
        m.put(2, 106L);
        m.put(7, 116L);
        m.put(3, 106L);
        m.put(10, 117L);
        m.put(1, 112L);
        m.put(5, 111L);
        m.put(4, 98L);
        new AssertMap<Integer, Long>().AssertMapContains(query.executeSQL08(), m);

    }

    @Test
    public void executeSQL09() {
        Map<Character, Long> m = new TreeMap<>();
        m.put('A', 49029L);
        m.put('C', 31797L);
        m.put('B', 36502L);
    }

    @Test
    public void executeSQL10() {
        Map<Character, Long> m = new TreeMap<>();
        m.put('E', 29631L);
        m.put('A', 48721L);
        m.put('C', 22018L);
        new AssertMap<Character, Long>().AssertMapContains(query.executeSQL10(), m);
    }

    @Test
    public void executeSQL11() {
        Map<Character, Long> m = new TreeMap<>();
        m.put('A', 231L);
        m.put('E', 150L);
        m.put('F', 236L);
        m.put('G', 118L);
        new AssertMap<Character, Long>().AssertMapContains(query.executeSQL11(), m);
    }

    @Test
    public void executeSQL12() {
        Map<Integer, Long> m = new TreeMap<>();
        m.put(40, 27L);
        m.put(30, 28L);
        m.put(10, 25L);
        m.put(50, 26L);
        m.put(20, 28L);
        new AssertMap<Integer, Long>().AssertMapContains(query.executeSQL12(), m);
    }
}