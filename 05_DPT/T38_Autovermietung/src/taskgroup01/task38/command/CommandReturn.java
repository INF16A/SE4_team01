package taskgroup01.task38.command;

import taskgroup01.task38.Customer;
import taskgroup01.task38.Repository;

public class CommandReturn implements ICommand{
    private Customer customer;
    private String plate;
    private Repository repository;

    public CommandReturn(Customer customer, String plate, Repository repository) {
        this.customer = customer;
        this.plate = plate;
        this.repository = repository;
    }

    public void execute() {
        repository.returnVehicle(plate, customer);
    }
}
