package main.java.command.pixel_art_editor;

public class PixelGrid {
    private boolean[][] grid;
    private int cursorX;
    private int cursorY;
    private int size;

    public PixelGrid(int size) {
        this.size = size;
        grid = new boolean[size][size];
        cursorX = 0;
        cursorY = 0;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }

    public void setCursorX(int x) {
        if (x >= 0 && x < size) {
            cursorX = x;
        }
    }

    public void setCursorY(int y) {
        if (y >= 0 && y < size) {
            cursorY = y;
        }
    }

    public void togglePixel(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            grid[y][x] = !grid[y][x];
        }
    }

    public boolean getPixel(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return grid[y][x];
        }
        return false;
    }

    public String generateCode() {
        StringBuilder code = new StringBuilder();
        code.append("int[][] pixelArt = {\n");
        for (int y = 0; y < size; y++) {
            code.append("    {");
            for (int x = 0; x < size; x++) {
                code.append(grid[y][x] ? "1" : "0");
                if (x < size - 1) {
                    code.append(", ");
                }
            }
            code.append("}");
            if (y < size - 1) {
                code.append(",");
            }
            code.append("\n");
        }
        code.append("};");
        return code.toString();
    }
}