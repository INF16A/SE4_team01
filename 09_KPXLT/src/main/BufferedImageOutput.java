package main;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class BufferedImageOutput implements ISimulationObserver {

    public BufferedImageOutput(Simulation sim) {
        this.image = new WritableImage(width, initialHeight);
        this.reader = image.getPixelReader();
        this.writer = image.getPixelWriter();
        this.simulation = sim;
    }

    private Simulation simulation;
    private final int width = 1000;
    private final int initialHeight = 1;
    private int currentHeight = initialHeight;
    private int heightCounter = 0;

    public WritableImage getImage() {
        return finishedImage;
    }

    private WritableImage finishedImage;
    private WritableImage image;
    private PixelWriter writer;
    private PixelReader reader;
    private Color noVehicleColor = new Color(0, 0, 0, 1);

    private Color getColorBySpeed(int speed) {
        return new Color((5f - speed) / 5f, speed / 5f, 0, 1);
    }

    @Override
    public void stepFinished() {
        heightCounter++;
        if (currentHeight <= heightCounter) {
            finishedImage = image;
            currentHeight += initialHeight;

            image = new WritableImage(width, currentHeight);
            writer = image.getPixelWriter();
            for (int x = 0; x < finishedImage.getWidth(); x++) {
                for (int y = 0; y < finishedImage.getHeight(); y++) {
                    writer.setColor(x, y, reader.getColor(x, y));
                }
            }
            reader = image.getPixelReader();
        }
        //shift
        for (int y = currentHeight - 2; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y + 1, reader.getColor(x, y));
            }
        }
        for (int x = 0; x < width; x++) {
            writer.setColor(x, 0, noVehicleColor);
        }
        simulation.getVehicles().forEach(vehicle -> writer.setColor(vehicle.getPosition(), 0, getColorBySpeed(vehicle.getSpeed())));
    }

}
