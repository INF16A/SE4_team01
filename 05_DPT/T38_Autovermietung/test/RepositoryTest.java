import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taskgroup01.task38.Customer;
import taskgroup01.task38.Repository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RepositoryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Repository repository;
    private Customer customer;
    private Customer unauthorizedCustomer;

    @Before
    public void setUp() throws Exception {
        this.repository = new Repository();
        this.customer = new Customer("Hans");
        this.unauthorizedCustomer = new Customer("Franz");
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(System.out);
    }

    @Test
    public void rentVehicle1() {
        repository.rentVehicle(2, customer);
        Assert.assertEquals("Rented car with plate BS-AF2001 to Hans" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void returnVehicleNotAuthorized() {
        repository.rentVehicle(2, customer);
        repository.returnVehicle("BS-AF2001", unauthorizedCustomer);
        Assert.assertTrue(outContent.toString().endsWith("ERROR: You are unauthorized to return the vehicle rented by Hans" + System.lineSeparator()));
    }

    @Test
    public void returnVehicleNotRented() {
        repository.returnVehicle("BS-AF1001", customer);
        Assert.assertEquals("ERROR: Can't return car that is not rented." + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void returnVehicleNotExisting() {
        repository.returnVehicle("bs-af01", customer);
        Assert.assertEquals("ERROR: No vehicle with plate \"bs-af01\" exists" + System.lineSeparator(), outContent.toString());
    }
}