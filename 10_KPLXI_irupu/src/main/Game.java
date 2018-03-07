package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Figure> circles = new ArrayList<>();
    List<Figure> blocks = new ArrayList<>();

    public Game() {
        circles.add(new Figure(1, 1));
        circles.add(new Figure(8, 1));
        circles.add(new Figure(9, 1));
        circles.add(new Figure(0, 2));
        circles.add(new Figure(3, 2));
        circles.add(new Figure(5, 2));
        circles.add(new Figure(7, 2));
        circles.add(new Figure(9, 3));
        circles.add(new Figure(2, 4));
        circles.add(new Figure(7, 5));
        circles.add(new Figure(8, 5));
        circles.add(new Figure(3, 6));
        circles.add(new Figure(4, 6));
        circles.add(new Figure(6, 6));
        circles.add(new Figure(0, 7));
        circles.add(new Figure(7, 8));
        circles.add(new Figure(0, 9));
        circles.add(new Figure(3, 9));
        circles.add(new Figure(8, 9));

        blocks.add(new Figure(1, 1, false));
        blocks.add(new Figure(3, 1, true));
    }

    public List<Figure> getCircles() {
        return circles;
    }

    public List<Figure> getBlocks() {
        return blocks;
    }
}
