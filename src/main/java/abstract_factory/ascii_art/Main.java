package main.java.abstract_factory.ascii_art;

import main.java.abstract_factory.ascii_art.factory.AFactory;
import main.java.abstract_factory.ascii_art.factory.BFactory;
import main.java.abstract_factory.ascii_art.factory.UIFactory;
import main.java.abstract_factory.ascii_art.ui.Button;
import main.java.abstract_factory.ascii_art.ui.Checkbox;
import main.java.abstract_factory.ascii_art.ui.TextField;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose UI style (A or B): ");
        String style = sc.nextLine().trim();
        System.out.println();

        UIFactory factory;

        if (style.equalsIgnoreCase("A")) {
            factory = new AFactory();
        } else if (style.equalsIgnoreCase("B")) {
            factory = new BFactory();
        } else {
            throw new IllegalArgumentException("Unknown style. Try again.");
        }

        Button button = factory.createButton("Submit");
        TextField textField = factory.createTextField("Enter name");
        Checkbox checkbox = factory.createCheckbox("X");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\nChanging texts on the Button, TextField, and Checkbox...\n");

        button.setText("Click!");
        textField.setText("Enter code");
        checkbox.setText("");

        button.display();
        textField.display();
        checkbox.display();
    }
}
