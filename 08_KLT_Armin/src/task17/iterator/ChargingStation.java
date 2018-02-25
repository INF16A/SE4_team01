package task17.iterator;

import java.util.Iterator;

public class ChargingStation implements Iterable<Battery> {
    private Battery battery1;
    private Battery battery2;
    private Battery battery3;

    public void AddBattery(Battery battery){
        if(battery1==null){
            battery1=battery;
        }
        else if(battery2==null){
            battery2=battery;
        }
        else if(battery3==null){
            battery3=battery;
        }
        else {
            System.out.println("No slot for charging available");
        }
    }

    @Override
    public Iterator<Battery> iterator() {
        return new SlotIterator(battery1, battery2, battery3);
    }
}
