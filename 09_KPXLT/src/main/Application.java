package main;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private SimulationExecutor executor;
    private BufferedImageOutput bufferedImageOutput;
    private final int height = 500;
    private final int width = 1000;

    private ImageView view;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Simulation simulation = new Simulation(100, 0.8f);
        ISimulationExecution simulationExecution = new SimulationExecutionParallel(simulation);
        this.executor = new SimulationExecutorMultiThreaded(simulationExecution);
        this.bufferedImageOutput = new BufferedImageOutput(simulation, width, height);
        this.executor.addListener(bufferedImageOutput);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Image image = bufferedImageOutput.getImage();
                if (image != null) {
                    view.setImage(image);
                }
            }
        };
        timer.start();

        primaryStage.setWidth(width);
        primaryStage.setHeight(height);

        primaryStage.setResizable(false);
        primaryStage.setTitle("NaSch-Modell");

        view = new ImageView();
        view.setCache(false);
        Group root = new Group();
        root.getChildren().add(view);
        primaryStage.setScene(new Scene(root, new Color(0, 0, 0, 1)));
        executor.start();
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("ending");
        executor.stop();
        System.out.println("ended");
    }
}
