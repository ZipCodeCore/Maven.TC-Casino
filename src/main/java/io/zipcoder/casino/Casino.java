package io.zipcoder.casino;


public class Casino {

    public static Casino casino = new Casino();

    public static void main(String[] args) {
        Craps craps;

        System.out.println("\t\t~~ Welcome to the Crap's Casino ~~\n" +
                "Where the only game to play is craps and you better like it!");

        do {
            String userInput = ConsoleInput.getStringInput("Which of our many fabulous games would like to play?\n" +
                    "[ CRAPS ]\t[ BLACKJACK ]\t[ GOFISH ]\t[ ROULETTE ]");
            if ("CRAPS".equalsIgnoreCase(userInput) || "CRABS".equalsIgnoreCase(userInput)) {
                craps = new Craps();
                craps.play();
            } else {
                System.out.println("\nPyshc, we don't have " + userInput + "! What kind of place do you think this is?!\n");
            }
        } while (true);
    }
}

