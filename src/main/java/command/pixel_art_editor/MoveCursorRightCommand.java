package main.java.command.pixel_art_editor;

public class MoveCursorRightCommand implements Command {
    private PixelGrid grid;
    
    public MoveCursorRightCommand(PixelGrid grid) {
        this.grid = grid;
    }
    
    @Override
    public void execute() {
        grid.setCursorX(grid.getCursorX() + 1);
    }
}