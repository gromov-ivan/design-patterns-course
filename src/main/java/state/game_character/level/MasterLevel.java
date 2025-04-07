package main.java.state.game_character.level;

import main.java.state.game_character.GameCharacter;
import main.java.state.game_character.LevelState;

public class MasterLevel extends LevelState {

    public MasterLevel(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {

    }

    @Override
    public void meditate() {

    }

    @Override
    public void fight() {

    }

    @Override
    public String getLevelName() {
        return "Master";
    }
}

