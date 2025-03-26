package main.java.factory_method.rpg_map_generator.map;

import main.java.factory_method.rpg_map_generator.tile.Tile;

public abstract class Map {
    protected Tile[][] tiles;
    protected int width;
    protected int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];
    }

    public void initializeTiles() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tiles[row][col] = createTile();
            }
        }
    }

    public void display() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print(tiles[row][col].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    protected abstract Tile createTile();
}
