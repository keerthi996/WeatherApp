package com.example.weatherapp.ModelInJava;

public class Wind {
    int deg;
    double speed;

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "deg=" + deg +
                ", speed=" + speed +
                '}';
    }
}
