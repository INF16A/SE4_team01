package main;

public class Vehicle {
    private final int maxSpeed = 5;
    private final int wrapAround = 1000;
    private int speed;
    private int position;

    Vehicle(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public void setSpeed(int speed) {
        if(speed >= 0 && speed <= maxSpeed) {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void decelerate() {
        if(speed > 0) {
            speed--;
        }
    }

    public void accelerate() {
        if(speed < maxSpeed) {
            speed++;
        }
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void moveForwards() {
        position = (position + speed) % wrapAround;
    }
}
