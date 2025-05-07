package main.java.command.pixel_art_editor;

public class MoveCursorLeftCommand implements Command {
    private PixelGrid grid;
    
    public MoveCursorLeftCommand(PixelGrid grid) {
        this.grid = grid;
    }
    
    @Override
    public void execute() {
        grid.setCursorX(grid.getCursorX() - 1);
    }
}