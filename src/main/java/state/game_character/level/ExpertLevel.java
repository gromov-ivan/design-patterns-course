package main.java.state.game_character.level;

import main.java.state.game_character.GameCharacter;
import main.java.state.game_character.LevelState;

public class ExpertLevel extends LevelState {

    public ExpertLevel(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("You train and gain 3 XP!");
        character.addExperience(3);
        checkLevelUp();
    }

    @Override
    public void meditate() {
        System.out.println("You meditate deeply and gain 10 HP.");
        character.addHealth(10);
        checkLevelUp();
    }

    @Override
    public void fight() {
        System.out.println("You engage in a tough fight! Lose 5 HP, gain 8 XP.");
        character.reduceHealth(5);
        character.addExperience(8);
        checkLevelUp();
    }

    private void checkLevelUp() {
        if (character.getExperience() >= GameCharacter.EXPERT_EXP_THRESHOLD) {
            System.out.println("You have advanced to Master Level!");
            character.setState(new MasterLevel(character));
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}