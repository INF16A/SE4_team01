import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecordLineTest {
    RecordLine recordLine;

    @Before
    public void setUp() throws Exception {
        recordLine = new RecordLine(0,
                1,
                2,
                'A',
                3,
                "Name",
                4,
                5,
                6);
    }

    @Test
    public void getId() {
        Assert.assertEquals(3, recordLine.getProductId());
    }

    @Test
    public void getCustomerId() {
        Assert.assertEquals(1, recordLine.getCustomerId());
    }

    @Test
    public void getCustomerTownId() {
        Assert.assertEquals(2, recordLine.getCustomerTownId());
    }

    @Test
    public void getCustomerRegion() {
        Assert.assertEquals('A', recordLine.getCustomerRegion());
    }

    @Test
    public void getProductId() {
        Assert.assertEquals(3, recordLine.getProductId());
    }

    @Test
    public void getProductName() {
        Assert.assertEquals("Name", recordLine.getProductName());
    }

    @Test
    public void getProductPrice() {
        Assert.assertEquals(4, recordLine.getProductPrice());
    }

    @Test
    public void getQuanitity() {
        Assert.assertEquals(4, recordLine.getProductPrice());
    }

    @Test
    public void getDeliveryTimeInHours() {
        Assert.assertEquals(6, recordLine.getDeliveryTimeInHours());
    }

    @Test
    public void TestToString() {
        Assert.assertEquals(
                "RecordLine{id=0, customerId=1, customerTownId=2, customerRegion=A, productId=3, productName='Name', productPrice=4, quantity=5, deliveryTimeInHours=6}",
                recordLine.toString());
    }
}