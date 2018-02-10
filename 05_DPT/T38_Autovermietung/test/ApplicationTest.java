import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taskgroup01.task38.Application;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApplicationTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final String exitCommand = System.lineSeparator() + "exit";
    private final String initialMessage = "Commands: RENT <type (number)>, RETURN <id>, EXIT";

    @Before
    public void setOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    private String runApplicationWithCommand(String cmd) {
        ByteArrayInputStream in = new ByteArrayInputStream(cmd.getBytes());
        System.setIn(in);
        Application.main();
        String[] outLines = outContent.toString().split(System.lineSeparator());
        return outLines[outLines.length - 1];
    }

    @Test
    public void testEmptyMessage() {
        Assert.assertEquals("Please enter a valid command.", runApplicationWithCommand("" + exitCommand));
    }

    @Test
    public void testExitCommand() {
        Assert.assertEquals(initialMessage, runApplicationWithCommand("exit"));
    }

    @Test
    public void testNotExistingType() {
        String output = runApplicationWithCommand("RENT 0" + exitCommand);
        Assert.assertEquals("Invalid vehicle type.", output);
    }

    @Test
    public void rentVehicleType1() {
        String output = runApplicationWithCommand("RENT 1" + exitCommand);
        Assert.assertEquals("Rented car with plate BS-AF1002 to CLI User", output);
    }

    @Test
    public void reservationMessageVehicleType1() {
        String output = runApplicationWithCommand(
                "rent 1" + System.lineSeparator() +
                        "rent 1" + System.lineSeparator() +
                        "rent 1" + System.lineSeparator() +
                        "return BS-AF1001" +
                        exitCommand);
        Assert.assertEquals("Customer CLI User, your reserved car is now available.", output);
    }

    @Test
    public void rentReservedVehicleType1() {
        String output = runApplicationWithCommand(
                "rent 1" + System.lineSeparator() +
                        "rent 1" + System.lineSeparator() +
                        "rent 1" + System.lineSeparator() +
                        "return BS-AF1001" + System.lineSeparator() +
                        "rent 1" +
                        exitCommand);
        Assert.assertEquals("Rented car with plate BS-AF1001 to CLI User", output);
    }

    @Test
    public void rentVehiclesType1Completely() {
        String output = runApplicationWithCommand(
                "rent 1" + System.lineSeparator() +
                        "rent 1" + System.lineSeparator() +
                        "rent 1" +
                        exitCommand);
        Assert.assertEquals("No car of the requested type available, a reservation will be remembered.", output);
    }


    @Test
    public void returnNotRentedVehicle() {
        String output = runApplicationWithCommand(
                "return BS-AF1002" +
                        exitCommand);
        Assert.assertEquals("ERROR: Can't return car that is not rented.", output);

    }

    @Test
    public void returnRentedVehicle() {
        String output = runApplicationWithCommand(
                "return BS-AF1001" +
                        exitCommand);
        Assert.assertEquals("Successfully returned vehicle", output);
    }

    @Test
    public void returnNotExistingVehicle() {
        String output = runApplicationWithCommand(
                "return BS-AF01" +
                        exitCommand);
        Assert.assertEquals("ERROR: No vehicle with plate \"bs-af01\" exists", output);
    }


    @After
    public void restoreOutStream() {
        System.setOut(System.out);
    }

}
