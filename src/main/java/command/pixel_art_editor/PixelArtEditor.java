package main.java.command.pixel_art_editor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private static final int GRID_SIZE = 8;
    private static final int CELL_SIZE = 50;

    private PixelGrid pixelGrid;
    private Rectangle[][] cells;

    private Command moveCursorUpCommand;
    private Command moveCursorDownCommand;
    private Command moveCursorLeftCommand;
    private Command moveCursorRightCommand;
    private Command togglePixelCommand;
    private Command generateCodeCommand;

    @Override
    public void start(Stage primaryStage) {
        pixelGrid = new PixelGrid(GRID_SIZE);

        // UI
        BorderPane root = new BorderPane();
        GridPane gridPane = createPixelGrid();

        // Controls
        TextArea codeOutput = new TextArea();
        codeOutput.setEditable(false);
        codeOutput.setPrefRowCount(12);
        codeOutput.setPrefColumnCount(40);

        // Initialize commands
        moveCursorUpCommand = new MoveCursorUpCommand(pixelGrid);
        moveCursorDownCommand = new MoveCursorDownCommand(pixelGrid);
        moveCursorLeftCommand = new MoveCursorLeftCommand(pixelGrid);
        moveCursorRightCommand = new MoveCursorRightCommand(pixelGrid);
        togglePixelCommand = new TogglePixelCommand(pixelGrid);
        generateCodeCommand = new GenerateCodeCommand(pixelGrid, codeOutput);

        Button generateCodeButton = new Button("Create Code");
        generateCodeButton.setOnAction(e -> generateCodeCommand.execute());

        Label instructionsLabel = new Label(
                "Controls:\n" +
                        "Arrow Keys: Move cursor\n" +
                        "Space: Toggle pixel\n" +
                        "Generate Code: Create Java array"
        );

        VBox controlPanel = new VBox(10, instructionsLabel, generateCodeButton, new Label("Created Code:"), codeOutput);
        controlPanel.setPadding(new Insets(10));

        root.setCenter(gridPane);
        root.setRight(controlPanel);

        Scene scene = new Scene(root);

        // Keyboard controls
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                moveCursorUpCommand.execute();
            } else if (e.getCode() == KeyCode.DOWN) {
                moveCursorDownCommand.execute();
            } else if (e.getCode() == KeyCode.LEFT) {
                moveCursorLeftCommand.execute();
            } else if (e.getCode() == KeyCode.RIGHT) {
                moveCursorRightCommand.execute();
            } else if (e.getCode() == KeyCode.SPACE) {
                togglePixelCommand.execute();
            }
            updateGrid();
        });

        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        updateGrid();
    }

    private GridPane createPixelGrid() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));

        cells = new Rectangle[GRID_SIZE][GRID_SIZE];

        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setStroke(Color.GRAY);
                cell.setFill(Color.WHITE);

                final int cellX = x;
                final int cellY = y;

                cell.setOnMouseClicked(e -> {
                    pixelGrid.setCursorX(cellX);
                    pixelGrid.setCursorY(cellY);
                    togglePixelCommand.execute();
                    updateGrid();
                });

                cells[y][x] = cell;
                gridPane.add(cell, x, y);
            }
        }

        return gridPane;
    }

    private void updateGrid() {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                cells[y][x].setFill(pixelGrid.getPixel(x, y) ? Color.BLACK : Color.WHITE);
                cells[y][x].setStroke(Color.GRAY);
                cells[y][x].setStrokeWidth(1);
            }
        }

        int cursorX = pixelGrid.getCursorX();
        int cursorY = pixelGrid.getCursorY();
        cells[cursorY][cursorX].setStroke(Color.RED);
        cells[cursorY][cursorX].setStrokeWidth(3);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
