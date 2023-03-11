package com.example.weatherapp.ModelInJava;


import java.util.List;

public class ModelResponse {
    String base;
    Clouds clouds;
    int cod;
    Coord coord;
    int dt;
    int id;
    Main main;
    String name;
    Sys sys;
    int timezone;
    int visibility;
    List<Weather> weather;
    Wind wind;
    //val base: String,
    //val clouds: Clouds,
    //val cod: Int,

    public Wind getWind() {
        return wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public int getVisibility() {
        return visibility;
    }

    public int getTimezone() {
        return timezone;
    }

    public Sys getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    public int getId() {
        return id;
    }

    public int getDt() {
        return dt;
    }

    public Coord getCoord() {
        return coord;
    }

    public int getCod() {
        return cod;
    }

    public Clouds getClouds() {
        return clouds;
    }
    //val coord: Coord,
    //val dt: Int,
    //val id: Int,
    //val main: Main,
    //val name: String,
    //val sys: Sys,
    //val timezone: Int,
    //val visibility: Int,
    //val weather: List<Weather>,
    //val wind: Wind

    public String getBase() {
        return base;
    }
}
