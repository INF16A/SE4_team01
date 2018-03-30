package main;

import java.util.List;

public class Solver implements Runnable {
    private Game game;
    private Application application;

    private int startingCircleCount;

    public Solver(Game g, Application app) {
        game = g;
        application = app;
    }

    public void start() {
        List<Figure> remainingCircles = game.getCircles();
        startingCircleCount = remainingCircles.size();
        recursiveSolve(remainingCircles, 0);
        return;
    }

    private boolean recursiveSolve(List<Figure> remainingCircles, int beginIndex) {
        Figure currentCircle = remainingCircles.get(beginIndex);
        Figure block = new Figure(currentCircle.getX(), currentCircle.getY(), false);
        int circX = currentCircle.getX(), circY = currentCircle.getY();
        int offset[] = {-1, 0, 1};
        for (int i = 0; i < 6; i++) {
            application.update();
            //generate all 6 block positions over a circle
            block.setX(circX + (i < 3 ? offset[i % 3] : 0));
            block.setY(circY + (i < 3 ? 0 : offset[i % 3]));
            block.setOrientation(i > 3);

            if (game.addBlock(block)) { // check if block is placeable in the current orientation
                int touching = game.countTouchingBlocks(block);
                // check if block placement was target-aimed
                if (touching == 1 || touching == 0 && remainingCircles.size() == startingCircleCount || touching == 2 && remainingCircles.size() == 0) {
                    remainingCircles.remove(currentCircle); //remove circle as a block was placed over it successfully
                    if(remainingCircles.size() == 0) {
                        application.update();
                        return true;
                    }
                    if(!recursiveSolve(remainingCircles, 0)) { //if there was no solution found for the current constellation
                        //remove the block that is part of the issue (backtracking)
                        game.removeBlock(block);
                        remainingCircles.add(currentCircle);
                    }
                }
            }
        }
        beginIndex++;
        if(beginIndex == remainingCircles.size())
            return false;
        return recursiveSolve(remainingCircles, beginIndex);
    }


    @Override
    public void run() {
        start();
    }
}
