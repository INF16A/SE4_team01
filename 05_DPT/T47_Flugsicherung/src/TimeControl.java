import java.util.ArrayList;
import java.util.List;

public class TimeControl {
    private List<ITimeControlled> controllables = new ArrayList<>();

    public void AddToTimeControl(ITimeControlled iTimeControlled) {
        controllables.add(iTimeControlled);
    }

    public void RemoveFromTimeControl(ITimeControlled iTimeControlled) {
        controllables.remove(iTimeControlled);
    }

    public void Cycle() {
        for (int i = 0; i < controllables.size(); i++) {
            controllables.get(i).Cycle();
        }
    }
}
