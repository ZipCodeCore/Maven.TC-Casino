package io.zipcoder.casino;


public class Casino {
    enum Games {
        BLACKJACK, CRAPS, GOFISH, LEAVE
    }
    private final String games = "BlackJack, Craps, GoFish, or leave.";
    public void start() {
        printWelcomeMessage();
        //goToGameConsole();
    }
    private void printWelcomeMessage() {
        Console.print("Welcome to the Casino!");
    }
    private String getGameToBePlayedFromUser() {
        String response = Console.getStringInput("What game would you like to play today? (" + games + ")");
        return response;
    }
    private void printLeaveMessage() {
        Console.print("\nThanks for your money! Please come back to give us more!");
    }
    private void printIncorrectInputMessage() {
        Console.print("\nInvalid game. Please enter " + games);
    }
    private Games validateGameChoice() {
        String desiredGame;
        Games game;
        do {
            desiredGame = getGameToBePlayedFromUser();
            desiredGame = desiredGame.toUpperCase();
            try {
                game = Games.valueOf(desiredGame);
                break;
            } catch (IllegalArgumentException e) {
                printIncorrectInputMessage();
            }
        } while(true);
        return game;
    }
//    private void goToGameConsole() {
//        Games gameChoice = validateGameChoice();
//        switch (gameChoice) {
//            case BLACKJACK:
//                BlackJackMenu.run();
//                break;
//            case CRAPS:
//                CrapsConsole.run();
//                break;
//            case GOFISH:
//                GoFishConsole.run();
//                break;
//            case LEAVE:
//                printLeaveMessage();
//                break;
//            default:
//                printIncorrectInputMessage();
//        } // End switch statement.
}
