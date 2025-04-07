package main.java.decorator.customizable_printer;

public class BasicPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
