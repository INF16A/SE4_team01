package main;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("NaSch-Modell");
        Canvas canvas = new Canvas(1000, 500);
        WritableImage wi = new WritableImage(1000, 500);
        PixelWriter pw = wi.getPixelWriter()/*canvas.getGraphicsContext2D().getPixelWriter()*/;
        pw.setColor(5, 5, new Color(1, 0, 0, 1));
        ImageView imageView = new ImageView(wi);
        Group root = new Group();
        root.getChildren().add(canvas);
        root.getChildren().add(imageView);
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }
}
