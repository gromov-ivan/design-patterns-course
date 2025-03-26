package main.java.abstract_factory.ascii_art.ui;

public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("┌─ A-Field ─────────┐");
        System.out.println("│ " + text + "        │");
        System.out.println("└───────────────────┘");
    }
}
