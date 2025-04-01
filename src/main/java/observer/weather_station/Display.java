package main.java.observer.weather_station;

public class Display implements WeatherObserver {
    private final String observerName;

    public Display(String name) {
        this.observerName = name;
    }

    @Override
    public void updateTemperature(int newTemperature) {
        System.out.println(observerName + " | Temperature: " + newTemperature + "°C");
    }
}

