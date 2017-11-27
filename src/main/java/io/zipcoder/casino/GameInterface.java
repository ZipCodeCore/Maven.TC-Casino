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

        String playAgain;
        do {

            System.out.println("Welcome to the Blackjack table");
            BlackjackPlayer blackjackPlayer = new BlackjackPlayer(Console.getUserInputString("What is your name?"),
                    Console.getUserInputDouble("How much money are you bringing to the table?"));
            BlackJack.start();
            playAgain = Console.getUserInputString("Do you want to play another game of Blackjack?");
            //the below line to retrieve the same player name from previous game if player wants to continue may fail...
            //so may need to rewrite, won't know until we test the game-play from console itself
            blackjackPlayer.getName();
        } while (playAgain.equals("no"));
        CardGames cardGames = new CardGames();
        cardGames.chooseGameType();

    }


    public static void playGoFish() {
        GoFish goFish = new GoFish();
        Deck goFishDeck = new Deck();
        goFishDeck.populate();
        goFishDeck.shuffle();
        String playAgain = null;

        do{
            System.out.println("Welcome to the Go Fish table!!!");

            for(int i =0; i <= 1; i++) {
                goFish.createOnePlayer(Console.getUserInputString("What is your name?"));
            }

            goFish.goFishPlayers.get(0).dealGoFishHand(goFish.goFishPlayers,goFishDeck);

            goFish.showEverybodysHand();

            goFish.askOtherPlayerForCard();


            int cardToAskFor = Console.getUserInputInteger("What card do you want to ask for? \nPlease input the index of the card 1 through " + goFish.goFishPlayers.get(0).getHandList().size() + "!");

            goFish.askFirstPlayerForCard();

        } while (playAgain.equals("no"));
        CardGames cardGames = new CardGames();
        cardGames.chooseGameType();

        }

    }


