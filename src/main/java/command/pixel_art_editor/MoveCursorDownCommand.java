package main.java.command.pixel_art_editor;

public class MoveCursorDownCommand implements Command {
    private PixelGrid grid;
    
    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }
    
    @Override
    public void execute() {
        grid.setCursorY(grid.getCursorY() + 1);
    }
}