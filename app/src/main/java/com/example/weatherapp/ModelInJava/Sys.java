package com.example.weatherapp.ModelInJava;

public class Sys {
    String country;
    int id;
    int sunrise;
    int sunset;
    int type;

    @Override
    public String toString() {
        return "Sys{" +
                "country='" + country + '\'' +
                ", id=" + id +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", type=" + type +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
