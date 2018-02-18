package taskgroup01.task47;

import java.util.ArrayList;
import java.util.List;

class TimeControl {
    static TimeControl timeControl = new TimeControl();
    private int ticksCount;
    private List<ITimeControlled> controllables = new ArrayList<>();

    int getTicksCount() {
        return ticksCount;
    }

    void addToTimeControl(ITimeControlled iTimeControlled) {
        controllables.add(iTimeControlled);
    }

    void removeFromTimeControl(ITimeControlled iTimeControlled) {
        controllables.remove(iTimeControlled);
    }

    void Cycle() {
        System.out.print(ticksCount + "\t");
        //has to be normal for loop because of ConcurrentModification
        for (int i = 0; i < controllables.size(); i++) {
            controllables.get(i).cycle();
        }
        System.out.println();
        ticksCount++;
    }
}
