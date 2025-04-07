package main.java.state.game_character.level;

import main.java.state.game_character.GameCharacter;
import main.java.state.game_character.LevelState;

public class NoviceLevel extends LevelState {

    public NoviceLevel(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("You train and gain 5 XP!");
        character.addExperience(5);

        if (character.getExperience() >= GameCharacter.NOVICE_EXP_THRESHOLD) {
            System.out.println("You have advanced to Intermediate Level!");
            character.setState(new IntermediateLevel(character));
        }
    }

    @Override
    public void meditate() {

    }

    @Override
    public void fight() {

    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}

