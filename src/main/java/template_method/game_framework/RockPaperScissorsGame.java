package main.java.template_method.game_framework;

import java.util.Random;

public class RockPaperScissorsGame extends Game {
    private Random random;

    private final String[] moves = {"Rock", "Paper", "Scissors"};
    private final int roundsToWin = 3;
    private int numberOfPlayers;
    private int[] wins;

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers != 2) {
            throw new IllegalArgumentException("Error: 2 players is maximum.");
        }

        this.numberOfPlayers = numberOfPlayers;
        this.wins = new int[numberOfPlayers]; // wins[0] = Player1, wins[1] = Player2
        this.random = new Random();

        System.out.println("Initializing Rock-Paper-Scissors Game for " + numberOfPlayers + " players...");
        System.out.println("Win " + roundsToWin + " games to be the champion.");
    }

    @Override
    public boolean endOfGame() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (wins[i] >= roundsToWin) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        int movePlayer1 = random.nextInt(moves.length);
        int movePlayer2 = random.nextInt(moves.length);

        System.out.println("---------------------------------------------------------");
        System.out.println("ROUND: Player 1 chose " + moves[movePlayer1] + " vs. Player 2 chose " + moves[movePlayer2]);

        int winner = determineWinner(movePlayer1, movePlayer2);
        if (winner == 0) {
            System.out.println("RESULT: It's a tie!");
        } else if (winner == 1) {
            System.out.println("RESULT: Player 1 wins this round!");
            wins[0]++;
        } else {
            System.out.println("RESULT: Player 2 wins this round!");
            wins[1]++;
        }

        System.out.println("CURRENT SCORE: Player 1 (" + wins[0] + ") - Player 2 (" + wins[1] + ")");
    }

    private int determineWinner(int move1, int move2) {
        // Wins: 0 = Tie, 1 = Player 1 wins, 2 = Player 2 wins
        // Moves: 0 = Rock, 1 = Paper, 2 = Scissors

        if (move1 == move2) return 0; // Tie

        switch (move1) {
            case 0: // Rock
                return (move2 == 2) ? 1 : 2; // Rock beats Scissors, loses to Paper
            case 1: // Paper
                return (move2 == 0) ? 1 : 2; // Paper beats Rock, loses to Scissors
            case 2: // Scissors
                return (move2 == 1) ? 1 : 2; // Scissors beats Paper, loses to Rock
        }

        return 0;
    }

    @Override
    public void displayWinner() {
        int winner = (wins[0] >= roundsToWin) ? 1 : 2;
        System.out.println("\n******************* Game Over! *******************");
        System.out.println("Player " + winner + " is the champion!");
        System.out.println("FINAL SCORE: Player 1 (" + wins[0] + ") - Player 2 (" + wins[1] + ")");
        System.out.println("**************************************************");
    }
}
