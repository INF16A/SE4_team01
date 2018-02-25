package task17.iterator;

public class Battery {

    public Battery(int stateInPercent) {
        this.stateInPercent = stateInPercent;
    }

    public int getStateInPercent() {
        return stateInPercent;
    }

    public void setStateInPercent(int stateInPercent) {
        if (stateInPercent > 100) {
            stateInPercent = 100;
        }
        System.out.println(this.stateInPercent+"<-"+stateInPercent);
        this.stateInPercent = stateInPercent;
    }

    private int stateInPercent;
}
