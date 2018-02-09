package taskgroup01.task38;

public class Customer implements IReservationListener{
    private String name = "";

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void reservationNotification() {
        System.out.println("Customer " + name + ", your reserved car is now available.");
    }

    @Override
    public String toString() {
        return name;
    }
}
