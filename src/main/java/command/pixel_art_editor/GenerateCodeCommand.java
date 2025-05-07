package main.java.command.pixel_art_editor;

import javafx.scene.control.TextArea;

public class GenerateCodeCommand implements Command {
    private PixelGrid grid;
    private TextArea outputTextArea;
    
    public GenerateCodeCommand(PixelGrid grid, TextArea outputTextArea) {
        this.grid = grid;
        this.outputTextArea = outputTextArea;
    }
    
    @Override
    public void execute() {
        String code = grid.generateCode();
        outputTextArea.setText(code);
        System.out.println(code);
    }
}