package main.java.state.game_character.level;

import main.java.state.game_character.GameCharacter;
import main.java.state.game_character.LevelState;

public class IntermediateLevel extends LevelState {

    public IntermediateLevel(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("You train and gain 4 XP!");
        character.addExperience(4);
        checkLevelUp();
    }

    @Override
    public void meditate() {
        System.out.println("You meditate and gain 5 HP.");
        character.addHealth(5);
        checkLevelUp();
    }

    @Override
    public void fight() {

    }

    private void checkLevelUp() {
        if (character.getExperience() >= GameCharacter.INTERMEDIATE_EXP_THRESHOLD) {
            System.out.println("You have advanced to Expert Level!");
            character.setState(new ExpertLevel(character));
        }
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}

