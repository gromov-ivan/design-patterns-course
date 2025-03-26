package main.java.factory_method.rpg_map_generator.tile;

import main.java.factory_method.rpg_map_generator.map.CityMap;
import main.java.factory_method.rpg_map_generator.map.Map;
import main.java.factory_method.rpg_map_generator.map.WildernessMap;

import java.util.Scanner;

public class Game {
    public static Map createMap(String mapType, int width, int height) {
        if ("city".equalsIgnoreCase(mapType)) {
            return new CityMap(width, height);
        } else if ("wilderness".equalsIgnoreCase(mapType)) {
            return new WildernessMap(width, height);
        } else {
            throw new IllegalArgumentException("Unknown map type. Try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter map type (city or wilderness): ");
        String type = scanner.nextLine();

        int width = 15;
        int height = 10;

        Map map = createMap(type, width, height);
        map.display();
    }
}
