package com.example.pureweather.model;

import java.util.List;

public class Weather_App {
    List<Weather> weather;
    Main main;
    Wind wind;

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }
}
