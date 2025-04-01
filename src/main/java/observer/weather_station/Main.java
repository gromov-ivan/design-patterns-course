package main.java.observer.weather_station;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation();
        station.start();

        WeatherObserver display1 = new Display("Observer 1");
        WeatherObserver display2 = new Display("Observer 2");
        WeatherObserver display3 = new Display("Observer 3");

        station.addObserver(display1);
        station.addObserver(display2);
        station.addObserver(display3);

        Thread.sleep(7_000);

        System.out.println("\nRemoving Observer 1...\n");
        station.removeObserver(display1);

        Thread.sleep(7_000);

        station.stopStation();
        station.join();
    }
}

