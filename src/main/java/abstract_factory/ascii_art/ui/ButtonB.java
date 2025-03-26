package main.java.abstract_factory.ascii_art.ui;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("* B-Button *****");
        System.out.println("*    " + text + "    *");
        System.out.println("****************");
    }
}
