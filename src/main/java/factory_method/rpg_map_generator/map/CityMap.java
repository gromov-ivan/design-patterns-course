package main.java.factory_method.rpg_map_generator.map;

import main.java.factory_method.rpg_map_generator.tile.BuildingTile;
import main.java.factory_method.rpg_map_generator.tile.ForestTile;
import main.java.factory_method.rpg_map_generator.tile.RoadTile;
import main.java.factory_method.rpg_map_generator.tile.Tile;

import java.util.Random;

public class CityMap extends Map {
    private final Random random = new Random();

    public CityMap(int width, int height) {
        super(width, height);
        initializeTiles();
    }

    @Override
    protected Tile createTile() {
        int option = random.nextInt(3);
        return switch (option) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            default -> new BuildingTile();
        };
    }
}
