package main.java.abstract_factory.ascii_art.ui;

public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("╔═ A-Button ═══════╗");
        System.out.println("║      " + text + "      ║");
        System.out.println("╚══════════════════╝");
    }
}
