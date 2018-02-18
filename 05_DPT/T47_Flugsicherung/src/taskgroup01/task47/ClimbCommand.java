package taskgroup01.task47;

public class ClimbCommand implements ICommand {

    private IEmergencyClimbable airplane;

    ClimbCommand(IEmergencyClimbable p) {
        this.airplane = p;
    }

    @Override
    public void execute() {
        airplane.emergencyClimb();
    }
}
