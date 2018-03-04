package main;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class BufferedImageOutput implements ISimulationObserver {

    public BufferedImageOutput(Simulation sim, int width, int height) {
        this.height = height;
        this.width = width;
        this.image = new WritableImage(width, height);
        this.reader = image.getPixelReader();
        this.writer = image.getPixelWriter();
        this.simulation = sim;
    }

    private Simulation simulation;
    private final int width;
    private final int height;

    public WritableImage getImage() {
        if (isFinished) {
            return image;
        }
        return null;
    }

    private WritableImage image;
    private PixelWriter writer;
    private PixelReader reader;
    private Boolean isFinished = true;
    private Color noVehicleColor = new Color(0, 0, 0, 1);

    private Color getColorBySpeed(int speed) {
        return new Color((5f - speed) / 5f, speed / 5f, 0, 1);
    }

    @Override
    public void stepFinished() {
        isFinished = false;
        for (int y = height - 2; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y + 1, reader.getColor(x, y));
            }
        }
        for (int x = 0; x < width; x++) {
            writer.setColor(x, 0, noVehicleColor);
        }
        simulation.getVehicles().forEach(vehicle -> writer.setColor(vehicle.getPosition(), 0, getColorBySpeed(vehicle.getSpeed())));
        isFinished = true;
    }

}
