package taskgroup01.task38;

public class Vehicle {
    private int type = 0;
    private String licensePlate;
    private Customer rentedBy;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Customer getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(Customer rentedBy) {
        this.rentedBy = rentedBy;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return licensePlate + " : " + ((rentedBy == null) ? "free" : rentedBy.toString());
    }
}
