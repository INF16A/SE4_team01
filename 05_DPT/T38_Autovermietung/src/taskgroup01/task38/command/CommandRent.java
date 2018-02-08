package taskgroup01.task38.command;

import taskgroup01.task38.Customer;
import taskgroup01.task38.Repository;

public class CommandRent implements ICommand {
    private Customer customer;
    private int vehicleType;
    private Repository repository;

    public CommandRent(Customer customer, int vehicleType, Repository repository) {
        this.customer = customer;
        this.vehicleType = vehicleType;
        this.repository = repository;
    }

    public void execute() {
        repository.rentVehicle(vehicleType, customer);
    }
}
