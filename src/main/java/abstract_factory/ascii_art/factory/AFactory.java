package main.java.abstract_factory.ascii_art.factory;

import main.java.abstract_factory.ascii_art.ui.*;

public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}
