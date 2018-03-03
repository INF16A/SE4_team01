package main;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application extends javafx.application.Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private Simulation simulation;
    private ISimulationExecution simulationExecution;
    private SimulationExecutor executor;
    private ExecutorService drawExecutor;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.simulation = new Simulation(100, 0.9f);
        this.simulationExecution=new SimulationParallelExecution(simulation);
        this.executor = new SimulationExecutionTimed(simulationExecution, 1);
        this.drawExecutor = Executors.newSingleThreadExecutor();

        primaryStage.setTitle("NaSch-Modell");

        Canvas canvas = new Canvas(1000, 500);
        WritableImage wi = new WritableImage(1000, 500);
        PixelWriter pw = wi.getPixelWriter()/*canvas.getGraphicsContext2D().getPixelWriter()*/;
        this.executor.AddListener(new ISimulationObserver() {
            private final int lineCount = 500;
            private int currentLine = 0;
            private Color vehicleColor = new Color(1, 0, 0, 1);
            private Color noVehicleColor = new Color(0, 0, 0, 1);
            private Color nextLineColor = new Color(0, 1, 0, 1);

            @Override
            public void stepFinished() {
                System.out.println(currentLine);
                final int lineToDraw = currentLine;
                final int lineToClear = getNextLine();
                nextLine();
                drawExecutor.submit(() -> {
                    for (int i = 0; i < 1000; i++) {
                        pw.setColor(i, lineToDraw, noVehicleColor);
                    }
                    simulation.getVehicles().stream().map(Vehicle::getPosition).forEach(position -> pw.setColor(position, lineToDraw, vehicleColor));
                    for (int i = 0; i < 1000; i++) {
                        pw.setColor(i, lineToClear, nextLineColor);
                    }
                });
            }

            private int getNextLine() {
                return (currentLine + 1) % lineCount;
            }

            private void nextLine() {
                currentLine++;
                if (currentLine == lineCount) {
                    this.currentLine = 0;
                }
            }
        });
        ImageView imageView = new ImageView(wi);
        Group root = new Group();
        root.getChildren().add(canvas);
        root.getChildren().add(imageView);
        primaryStage.setScene(new Scene(root, 1000, 500));
        executor.start();
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("ending");
        executor.stop();
        drawExecutor.shutdown();
        System.out.println("ended");
    }
}
