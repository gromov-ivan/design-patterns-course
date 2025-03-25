package main.java.factory_method.rpg_map_generator;

import java.util.Random;

public class WildernessMap extends Map {
    private final Random random = new Random();

    public WildernessMap(int width, int height) {
        super(width, height);
        initializeTiles();
    }

    @Override
    protected Tile createTile() {
        int option = random.nextInt(3);
        return switch (option) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }
}
