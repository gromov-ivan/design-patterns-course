package main.java.abstract_factory.ascii_art.ui;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("== B-Field =======");
        System.out.println("= " + text + "     =");
        System.out.println("==================");
    }
}
