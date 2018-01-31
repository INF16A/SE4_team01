package taskgroup01.task47;

import java.util.ArrayList;
import java.util.List;

public class TimeControl {
    public static TimeControl timeControl = new TimeControl();

    public int getTicksCount() {
        return ticksCount;
    }

    private int ticksCount;
    private List<ITimeControlled> controllables = new ArrayList<>();

    public void AddToTimeControl(ITimeControlled iTimeControlled) {
        controllables.add(iTimeControlled);
    }

    public void RemoveFromTimeControl(ITimeControlled iTimeControlled) {
        controllables.remove(iTimeControlled);
    }

    public void Cycle() {
        System.out.print(ticksCount+"\t");
        for (int i = 0; i < controllables.size(); i++) {
            controllables.get(i).Cycle();
        }
        System.out.println();
        ticksCount++;
    }
}
