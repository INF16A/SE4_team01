public class ClimbCommand implements ICommand {

    private Airplane airplane;

    public ClimbCommand(Airplane p) {
        this.airplane = p;
    }

    @Override
    public void execute() {
        airplane.emergencyClimb();
    }
}
