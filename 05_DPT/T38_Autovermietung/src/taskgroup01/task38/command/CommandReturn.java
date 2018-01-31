package taskgroup01.task38.command;

import taskgroup01.task38.Vehicle;

public class CommandReturn implements ICommand{
    private Vehicle vehicle;

    public CommandReturn(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void execute() {

    }
}
