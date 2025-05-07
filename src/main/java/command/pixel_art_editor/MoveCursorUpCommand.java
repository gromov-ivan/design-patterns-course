package main.java.command.pixel_art_editor;

public class MoveCursorUpCommand implements Command {
    private PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.setCursorY(grid.getCursorY() - 1);
    }
}
