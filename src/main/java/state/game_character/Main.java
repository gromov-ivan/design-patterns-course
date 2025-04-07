package main.java.state.game_character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameCharacter hero = new GameCharacter("John Gromov");

        boolean isGameRunning = true;
        while (isGameRunning) {
            hero.displayStatus();

            String levelName = hero.getLevelName();
            switch (levelName) {
                case "Novice" -> {
                    System.out.println("Choose an action:");
                    System.out.println("[1] Train");
                    System.out.println("[2] Exit game");
                }
                case "Intermediate" -> {
                    System.out.println("Choose an action:");
                    System.out.println("[1] Train");
                    System.out.println("[2] Meditate");
                    System.out.println("[3] Exit game");
                }
                case "Expert" -> {
                    System.out.println("Choose an action:");
                    System.out.println("[1] Train");
                    System.out.println("[2] Meditate");
                    System.out.println("[3] Fight");
                    System.out.println("[4] Exit game");
                }
                case "Master" -> {
                    System.out.println("You have reached the MASTER level! Congratulations!");
                    System.out.println("End credits...");
                    isGameRunning = false;
                }
            }

            // If the user is at Master level, exit the loop
            if (!isGameRunning) break;

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            switch (levelName) {
                case "Novice" -> {
                    if (choice == 1) {
                        hero.train();
                    } else if (choice == 2) {
                        isGameRunning = false;
                    } else {
                        System.out.println("Invalid action for Novice level.");
                    }
                }
                case "Intermediate" -> {
                    if (choice == 1) {
                        hero.train();
                    } else if (choice == 2) {
                        hero.meditate();
                    } else if (choice == 3) {
                        isGameRunning = false;
                    } else {
                        System.out.println("Invalid action for Intermediate level.");
                    }
                }
                case "Expert" -> {
                    if (choice == 1) {
                        hero.train();
                    } else if (choice == 2) {
                        hero.meditate();
                    } else if (choice == 3) {
                        hero.fight();
                    } else if (choice == 4) {
                        isGameRunning = false;
                    } else {
                        System.out.println("Invalid action for Expert level.");
                    }
                }
            }

            if (hero.getHealth() <= 0) {
                System.out.println("""
                        "                                                                                                                                                                                  \s
                                                             ...'''...            ......            .....             ...............                      ..............   ...............                \s
                               .',,;,.           .;;;'.   .',,'......','.         .,;;;,.           .;:;'.            .';:;,''.''',;;,'..        .';;,.    ..,::,''''',:'   ..;:;,''..'',;;;'..            \s
                                 ';:;.           ':;.   .,;,.          .;,.        .;:;.             .:,.              .,:,.        .';:;'.       .;:,.      .::.      '.    .,:;.        ..,:;'.          \s
                                  .;:,.         .;,.   .:;.             .,;'.      .;:,              .:,               .,:,.          ..;:;.      .;:,       .::.             ,:;.           .;:;'         \s
                                   .;:,.       .;'    .:;.                ':,.     .;:,              .:'               .,:,.            .,::'     .;:,       .::.            .,:;.            .,::,.       \s
                                    .;:'      .;'    .;:'                 .,:'     .;:,              .:,               .,:,.             .,::'    .;:,.      .::.             ,:;.             .,::'       \s
                                     .;:'    .;'     ':;.                  .::.    .;:,              .:,               .,:,.              .;:;.   .;:,.      .::.            .,:;.              .;:;.      \s
                                      .;:'  .;'      ,:,.                  .,:,    .;:,              .:,               .,:,.               '::.   .;:,.      .::.            .,:;.               '::'      \s
                                       .;;..,,      .;:,                    ':;.   .;:,              .:,               .,:,.               .::'   .;:,.      .::,''''',;.    .,:;.               .;:'      \s
                                        .:;;,.      .;:,.                   .:;.   .;:,              .:,               .,:,.               .;:'   .;:,.      .::,.....',.    .,:;.               .;:'      \s
                                        .,::'       .;:;.                   .:;.   .;:,              .:,               .,:,.               .;:.   .;:,.      .::.      ..    .,:;.               .;:'      \s
                                         .::.       .,::.                   ':;.   .;:,              .:,               .,:,.               .:;.   .;:,.      .::.            .,:;.               .::.      \s
                                         .::.        .;:,                  .,:'    .;:,              .:'               .,:,.               ':,.   .;:,.      .::.            .,:;.               ':;.      \s
                                         .::.         '::.                 .:;.     ,:,.             .:.               .,:,.              .;:.    .;:,.      .::.            .,:;.              .;:.       \s
                                         .::.          .;;.               .;;.      .;;.            .,,                .,:,.             .,:'     .;:,.      .::.            .,:;.             .,:'        \s
                                         .::.           .,;'             .;;.        .;;.          .,,.                .,:;.            .;;.      .;:,       .::.            .,:;.            .;;'         \s
                                         '::'             .;,..        .,;'           .,;'.      ..,,.                 .;::'         .',;'.       .;:;.      .::;.     ...   .,::'.        ..,;'.          \s
                                        .,;;,..             .',''...'','..              .',,'''',,,.                  .';;;;,''''''',,'..        .,;;;'.    .,;;;;,'..';,.  .';;;;,''''''',,'..            \s
                                                               .......                     ......                         ..........                           .   .....         .........                 \s
                                                                                                                                                                                                            \"""");
                isGameRunning = false;
            }
        }
        scanner.close();
    }
}
