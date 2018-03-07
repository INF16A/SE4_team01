package main;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game();

        Group root = new Group();
        int width = Configuration.instance.screenWidth * Configuration.instance.cellSize;
        int height = Configuration.instance.screenHeight * Configuration.instance.cellSize;

        Scene s = new Scene(root, width, height);
        Canvas canvas = new Canvas(width, height);
        root.getChildren().add(canvas);

        primaryStage.setScene(s);
        primaryStage.setTitle("Irupu");
        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawLines(gc);
        drawBlocks(gc, game.getBlocks());
        drawCircles(gc, game.getCircles());
    }

    private void drawLines(GraphicsContext gc) {
        int cs = Configuration.instance.cellSize;
        int width = Configuration.instance.screenWidth * Configuration.instance.cellSize;
        int height = Configuration.instance.screenHeight * Configuration.instance.cellSize;
        for (int i = 0; i < Configuration.instance.screenWidth; i++) {
            gc.strokeLine(i * cs, 0, i * cs, height);
        }
        for (int i = 0; i < Configuration.instance.screenHeight; i++) {
            gc.strokeLine(0, i * cs, width, i * cs);
        }
    }

    private void drawCircles(GraphicsContext gc, List<Figure> circles) {
        for (Figure f : circles) {
            int x = f.getX() * Configuration.instance.cellSize;
            int y = f.getY() * Configuration.instance.cellSize;
            gc.strokeOval(5 + x, 5 + y, 20, 20);
        }
    }

    private void drawBlocks(GraphicsContext gc, List<Figure> blocks) {
        for (Figure f : blocks) {
            int cs = Configuration.instance.cellSize;
            int x = f.getX() * cs;
            int y = f.getY() * cs;
            gc.setFill(new Color(0, 0, 0, 0.25));
            gc.setStroke(Color.BLACK);
            if (f.getOrientation()) { //vertical
                gc.fillRect(x + 1, y - cs + 1, cs - 2, cs * 3 - 2);
                gc.strokeRect(x + 1, y - cs + 1, cs - 2, cs * 3 - 2);
            } else { //horizontal
                gc.fillRect(x - cs + 1, y + 1, cs * 3 - 2, cs - 2);
                gc.strokeRect(x - cs + 1, y + 1, cs * 3 - 2, cs - 2);
            }
            gc.setFill(Color.BLACK);
        }
    }


}
