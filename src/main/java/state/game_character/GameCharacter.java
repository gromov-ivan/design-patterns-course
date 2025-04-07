package main.java.state.game_character;

import main.java.state.game_character.level.NoviceLevel;

public class GameCharacter {
    private String name;
    private int experience;
    private int health;

    private LevelState currentState;

    public static final int NOVICE_EXP_THRESHOLD = 25;
    public static final int INTERMEDIATE_EXP_THRESHOLD = 50;
    public static final int EXPERT_EXP_THRESHOLD = 100;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 10;

        this.currentState = new NoviceLevel(this);
    }

    // State pattern: delegates behavior to the current state
    public void train() {
        currentState.train();
    }
    public void meditate() {
        currentState.meditate();
    }
    public void fight() {
        currentState.fight();
    }

    public void addExperience(int amount) {
        this.experience += amount;
    }
    public void addHealth(int amount) {
        this.health += amount;
    }
    public void reduceHealth(int amount) {
        this.health -= amount;
        if (health < 0) health = 0;
    }

    public void setState(LevelState newState) {
        this.currentState = newState;
    }

    public String getName() {
        return name;
    }
    public int getExperience() {
        return experience;
    }
    public int getHealth() {
        return health;
    }
    public String getLevelName() {
        return currentState.getLevelName();
    }

    public void displayStatus() {
        System.out.println("\n=== Character Status ===");
        System.out.println("Name: " + name);
        System.out.println("Level: " + getLevelName());
        System.out.println("Experience: " + experience);
        System.out.println("Health: " + health);
        System.out.println("========================\n");
    }
}
