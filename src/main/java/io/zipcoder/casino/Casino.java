package io.zipcoder.casino;


public class Casino {

    public static Casino casino = new Casino();

    public static void main(String[] args) {
        Craps craps;

        System.out.println("~~ Welcome to the Basic AF \'Casino\' ~~\n");

        do {
            String userInput = ConsoleInput.getStringInput("Which of our many fabulous games would like to play?\n" +
                    "[ CRAPS ]\t[ BLACKJACK ]\t[ GOFISH ]\t[ ROULETTE ]");
            if ("CRAPS".equalsIgnoreCase(userInput) || "CRABS".equalsIgnoreCase(userInput)) {
                craps = new Craps();
                craps.play();
            } else {
                System.out.println("\nPsshhh, we don't have " + userInput + "! What kind of place do you think this is?\n");
            }
        }while (true);
    }

    //when we have more games add switch statement to select game
}

