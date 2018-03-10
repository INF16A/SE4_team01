package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Figure> circles = new ArrayList<>();
    private List<Figure> blocks = new ArrayList<>();
    int[][] field = new int[Configuration.instance.screenHeight][Configuration.instance.screenWidth];

    public Game() {
        for (int i = 0; i < Configuration.instance.screenHeight; i++) {
            for (int j = 0; j < Configuration.instance.screenWidth; j++) {
                field[i][j] = 0;
            }
        }

        addCircle(new Figure(1, 1));
        addCircle(new Figure(8, 1));
        addCircle(new Figure(9, 1));
        addCircle(new Figure(0, 2));
        addCircle(new Figure(3, 2));
        addCircle(new Figure(5, 2));
        addCircle(new Figure(7, 2));
        addCircle(new Figure(9, 3));
        addCircle(new Figure(2, 4));
        addCircle(new Figure(7, 5));
        addCircle(new Figure(8, 5));
        addCircle(new Figure(3, 6));
        addCircle(new Figure(4, 6));
        addCircle(new Figure(6, 6));
        addCircle(new Figure(0, 7));
        addCircle(new Figure(7, 8));
        addCircle(new Figure(0, 9));
        addCircle(new Figure(3, 9));
        addCircle(new Figure(8, 9));

        addBlock(new Figure(1, 1, false));
        addBlock(new Figure(3, 1, true));

    }

    public List<Figure> getCircles() {
        return circles;
    }

    public List<Figure> getBlocks() {
        return blocks;
    }

    public void addBlock(Figure block) {
        if (!checkBlockPlaceable(block))
            return;

        field[block.getY()][block.getX()] += 10;
        if (block.getOrientation()) { //vertical
            field[block.getY()][block.getX() - 1] += 10;
            field[block.getY()][block.getX() + 1] += 10;
        } else {
            field[block.getY() - 1][block.getX()] += 10;
            field[block.getY() + 1][block.getX()] += 10;
        }

        blocks.add(block);
    }

    public void addCircle(Figure circle) {
        field[circle.getY()][circle.getX()] += 1;
        circles.add(circle);
    }

    public boolean checkBlockPlaceable(Figure block) {
        if (block.getOrientation()) { //vertical
            if (!(block.getX() >= 0 && block.getX() < Configuration.instance.screenWidth))
                return false;
            else if (!(block.getY() >= 1 && block.getY() < Configuration.instance.screenHeight - 1))
                return false;
        } else {
            if (!(block.getX() >= 1 && block.getX() < Configuration.instance.screenWidth - 1))
                return false;
            else if (!(block.getY() >= 0 && block.getY() < Configuration.instance.screenHeight))
                return false;
        }


        int sum = 0;
        sum += field[block.getY()][block.getX()];
        if (block.getOrientation()) { //vertical
            sum += field[block.getY() - 1][block.getX()];
            sum += field[block.getY() + 1][block.getX()];
        } else {
            sum += field[block.getY()][block.getX() - 1];
            sum += field[block.getY()][block.getX() + 1];
        }
        if (sum != 1) { //checks that only on one circle and no other block intersected
            return false;
        }

        return true;
    }

}
