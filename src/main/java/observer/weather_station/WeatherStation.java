package main.java.observer.weather_station;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();

    private int temperature;
    private final int MIN_TEMP = -22;
    private final int MAX_TEMP = 28;

    private volatile boolean isRunning = true;

    public WeatherStation() {
        temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    public synchronized void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.updateTemperature(temperature);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            int sleepTime = random.nextInt(5) + 1;
            try {
                Thread.sleep(sleepTime * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int change = random.nextBoolean() ? 1 : -1;
            int newTemp = temperature + change;

            // Check not to exceed min/max
            if (newTemp < MIN_TEMP) {
                newTemp = MIN_TEMP;
            } else if (newTemp > MAX_TEMP) {
                newTemp = MAX_TEMP;
            }
            temperature = newTemp;

            notifyObservers();
        }
    }

    public void stopStation() {
        isRunning = false;
    }
}
