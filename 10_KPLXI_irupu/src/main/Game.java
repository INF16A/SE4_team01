package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Solver solver;
    private List<Figure> circles = new ArrayList<>();
    private List<Figure> blocks = new ArrayList<>();
    int[][] field = new int[Configuration.instance.screenHeight][Configuration.instance.screenWidth];

    public Game(Application app) {
        solver = new Solver(this, app);
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
    }

    public void solve() {
        Thread thread = new Thread(solver);
        thread.start();
    }

    public List<Figure> getCircles() {
        return new ArrayList<>(circles); //return copy of list, not a reference
    }

    public void addCircle(Figure circle) {
        field[circle.getY()][circle.getX()] += 1;
        circles.add(circle);
    }

    public List<Figure> getBlocks() {
        return new ArrayList<>(blocks); //return copy of list, not a reference
    }

    public void removeBlock(Figure block) {
        blocks.remove(block);
    }

    public boolean addBlock(Figure block) {
        if (!checkBlockPlaceable(block))
            return false;
        addBlockNoCheck(block);
        return true;
    }

    public void addBlockNoCheck(Figure block) {
        int x = block.getX(), y = block.getY();
        field[y][x] += 10;
        if (!block.getOrientation()) { //horizontal  not vertical todo
            if (x > 0)
                field[y][x - 1] += 10;
            if (x < Configuration.instance.screenWidth)
                field[y][x + 1] += 10;
        } else {
            if (y > 0)
                field[y - 1][x] += 10;
            if (y < Configuration.instance.screenHeight)
                field[y + 1][x] += 10;
        }

        blocks.add(block);
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

    public int countTouchingBlocks(Figure block) {
        List<Figure> compareBlocks = getBlocks();
        int count = 0;
        for (Figure cb : compareBlocks) {
            int xDist = Math.abs(block.getX() - cb.getX());
            int yDist = Math.abs(block.getY() - cb.getY());
            if (cb.getOrientation() != block.getOrientation()) { //contradicting orientations, same pattern for horz/vert or vert/horz
                if (xDist == 2 && yDist <= 1 || yDist == 2 && xDist <= 1) { //check for all possible locations that would be touching the current block
                    count++;
                }
            } else { //same orientation
                int a, b;
                if (block.getOrientation()) { //if both are vertical
                    a = xDist;
                    b = yDist;
                } else { //if both are vertical, flip the pattern for what coordinates to look for
                    a = yDist;
                    b = xDist;
                }
                if (a == 1 && b <= 2 || b == 3 && a == 0) { //check for all possible offsets that would be touching the current block
                    count++;
                }
            }
        }
        return count;
    }

}
