package taskgroup01.task38;

public abstract class Vehicle {
    private int type = 0;
    private String licensePlate;
    private Customer rentedBy;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    String getLicensePlate() {
        return licensePlate;
    }

    Customer getRentedBy() {
        return rentedBy;
    }

    void setRentedBy(Customer rentedBy) {
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
