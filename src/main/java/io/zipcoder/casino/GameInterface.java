package io.zipcoder.casino;

public class GameInterface {

    public static void playCraps() {

        String playAgain;
        do {

            System.out.println("Welcome to the craps table. How many people are playing");
            CrapsPlayer first = new CrapsPlayer(Console.getUserInputString("What is the first players name?"), Console.getUserInputDouble("How much money are you bringing to the table?"));
            first.firstRoll();
            playAgain = Console.getUserInputString("Do you want to continue playing?");
            first.getName();
        } while (playAgain.equals("no"));


    }

    public static void playBlackjack() {

        String playAgain = "";

        do {

            System.out.println("Welcome to the Blackjack table");

//            int numberOfPlayers = Console.getUserInputInteger("How many players are there?");
//            for(int i = 0; i < numberOfPlayers; i++){
//                BlackJack.createOnePlayer(Console.getUserInputString("What is your name?"), Console.getUserInputDouble("How much money do you have?"));
//            }

            BlackjackPlayer blackjackPlayer = new BlackjackPlayer(Console.getUserInputString("What is your name?"),
                    Console.getUserInputDouble("How much money are you bringing to the table?"));
            BlackJack.blackjackPlayers.add(blackjackPlayer);
            blackjackPlayer.bet(Console.getUserInputDouble("How much do you want to bet on this game?"));
            BlackJack.start();
            System.out.println("The dealer's card was: " + BlackjackPlayer.viewHand(blackjackPlayer));
            BlackJack.endTurn();
            String playersTurn = "yes";

            while (playersTurn.equals("yes")) {
                BlackJack.giveCardToPlayer();
                BlackJack.giveCardToPlayer();
                System.out.println("Your card was: " + BlackjackPlayer.viewHand(blackjackPlayer));
                String hitOrStay = Console.getUserInputString("Do you want to stay? Yes or no...");

                if (hitOrStay.equalsIgnoreCase("yes"))
                    BlackjackPlayer.hitStay("yes");
                while (hitOrStay.equalsIgnoreCase("no")) {
                    BlackjackPlayer.hitStay("no");
                    System.out.println("Your card was: " + BlackjackPlayer.viewHand(blackjackPlayer));
                    String hitOrStayAgain = Console.getUserInputString("Do you want to stay? Yes or no...");
                    if (hitOrStayAgain.equalsIgnoreCase("yes"))
                    playersTurn = "no";
                    break;

                }

            }

            playAgain = Console.getUserInputString("Do you want to play another game of Blackjack?");
            //the below line to retrieve the same player name from previous game if player wants to continue may fail...
            //so may need to rewrite, won't know until we test the game-play from console itself
            blackjackPlayer.getName();
        } while (playAgain.equals("no"));


    }


    public static void playGoFish() {


    }
}

