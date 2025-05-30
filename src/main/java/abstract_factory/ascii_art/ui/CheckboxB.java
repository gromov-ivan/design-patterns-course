package main.java.abstract_factory.ascii_art.ui;

public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("B-Checkbox (" + text + ")");
    }
}
