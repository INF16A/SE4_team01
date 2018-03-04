package main;

public class Vehicle {
    public final int maxSpeed = 5;
    public final int wrapAround = 1000;
    private int speed;
    private int position;

    public Vehicle(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= maxSpeed) {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void decelerate() {
        if (speed > 0) {
            speed--;
        } else {
            speed = 0; //clamping
        }
    }

    public void accelerate() {
        if (speed < maxSpeed) {
            speed++;
        } else {
            speed = maxSpeed; //clamping
        }
    }

    public void setPosition(int position) {
        if (position >= 0 && position <= wrapAround) {
            this.position = position;
        }
    }

    public int getPosition() {
        if(position < 0) {
            System.out.println("ohoh");
            throw new Error("oops");
        }
        return position;
    }

    public void moveForwards() {
        position = (position + speed) % wrapAround;
    }
}
