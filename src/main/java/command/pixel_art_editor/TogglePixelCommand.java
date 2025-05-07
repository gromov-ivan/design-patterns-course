package main.java.command.pixel_art_editor;

public class TogglePixelCommand implements Command {
    private PixelGrid grid;
    
    public TogglePixelCommand(PixelGrid grid) {
        this.grid = grid;
    }
    
    @Override
    public void execute() {
        grid.togglePixel(grid.getCursorX(), grid.getCursorY());
    }
}