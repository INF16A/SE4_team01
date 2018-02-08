package taskgroup01.task38.command;

import taskgroup01.task38.Repository;
import taskgroup01.task38.Vehicle;

public class CommandReturn implements ICommand{
    private Vehicle vehicle;
    private Repository repo;

    public CommandReturn(Vehicle vehicle, Repository repo) {
        this.vehicle = vehicle;
        this.repo = repo;
    }

    public void execute() {
        repo.returnVehicle(vehicle);
    }
}
