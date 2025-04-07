package main.java.state.game_character;

public abstract class LevelState {
    protected GameCharacter character;

    public LevelState(GameCharacter character) {
        this.character = character;
    }

    public abstract void train();
    public abstract void meditate();
    public abstract void fight();

    public abstract String getLevelName();
}

