package taskgroup01.task47;

public class ClimbCommand implements ICommand {

    private IEmergencyClimbable airplane;

    public ClimbCommand(IEmergencyClimbable p) {
        this.airplane = p;
    }

    @Override
    public void execute() {
        airplane.emergencyClimb();
    }
}
