package main;

public class Figure {
    private int x;
    private int y;
    private boolean orientation;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Figure(int x, int y, boolean orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getOrientation() {
        return orientation;
    }
}
