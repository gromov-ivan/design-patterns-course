package main.java.factory_method.rpg_map_generator.tile;

public class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void action() {
    }
}
