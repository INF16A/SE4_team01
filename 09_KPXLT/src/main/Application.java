package main;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;

public class Application extends javafx.application.Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private Simulation simulation;
    private SimulationExecutor executor;
    private BufferedImageOutput bufferedImageOutput;
    private final int lineWidth = 1000;
    private final int lineHeight = 5;

    private Canvas canvas;
    private ImageView view;
    private WritableImage wi;
    private Group root;
    private ExecutorService service;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.simulation = new Simulation(100, 0.8f);
        ISimulationExecution simulationExecution = new SimulationExecutionParallel(simulation);
        this.executor = new SimulationExecutorMultiThreaded(simulationExecution);
        this.bufferedImageOutput = new BufferedImageOutput(simulation);

        this.executor.addListener(bufferedImageOutput);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                view.setImage(bufferedImageOutput.getImage());
            }
        };
        timer.start();
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setTitle("NaSch-Modell");
        wi = new WritableImage(lineWidth, lineHeight);

        view = new ImageView(wi);
        view.setCache(true);
        root = new Group();
        root.getChildren().add(view);
        primaryStage.setScene(new Scene(root));
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
