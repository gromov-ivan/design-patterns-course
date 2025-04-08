package main.java.template_method.game_framework;

public class Main {
    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        int numberOfPlayers = 2;

        // Using the Game framework (template method)
        game.play(numberOfPlayers);
    }
}

