package main;

public class Figure {
    private int x;
    private int y;
    private Boolean orientation;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }

    public String toString() {
        return "x=" + Integer.toString(x) + ", y=" + Integer.toString(y) + (orientation == null ? "" : ", or=" + (orientation ? "vert" : "horz"));
    }
}