package taskgroup01.task38.command;

import taskgroup01.task38.Vehicle;

public class CommandRent implements ICommand {
    private Vehicle vehicle;

    public CommandRent(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void execute() {

    }
}
