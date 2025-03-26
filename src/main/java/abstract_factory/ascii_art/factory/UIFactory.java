package main.java.abstract_factory.ascii_art.factory;

import main.java.abstract_factory.ascii_art.ui.Button;
import main.java.abstract_factory.ascii_art.ui.Checkbox;
import main.java.abstract_factory.ascii_art.ui.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);

    public abstract TextField createTextField(String text);

    public abstract Checkbox createCheckbox(String text);
}
