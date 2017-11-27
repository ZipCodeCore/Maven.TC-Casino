package io.zipcoder.casino;

public class GameInterface {


    public void playCraps() {


        String playAgain;

        do {Craps craps = new Craps();

            int numberOfPlayer = Console.getUserInputInteger("Welcome to the craps table. How many people are playing?");
            //creates players
            for(int i = 1; i <= numberOfPlayer; i++){
                craps.createOnePlayer(Console.getUserInputString("Player name:"), Console.getUserInputDouble("How much money would you like to bring to the table?"));
            }

             //get players bets
            for(int b = 0; b <= numberOfPlayer; b++){
                System.out.println(craps.crapsPlayers.get(b).getName());
                Double playerBet = craps.crapsPlayers.get(b).bet(Console.getUserInputDouble(" please place bet"));
                System.out.println(craps.crapsPlayers.get(b).getName()+" you bet " + playerBet);
            }


//           if(craps.firstRollChecker())
//
//
//            System.out.println(craps.firstRoll(craps.crapsPlayers.get(0)));
//
//
//            System.out.println(craps.nextRoll(craps.crapsPlayers.get(0)));
//
//
//           do{
//               int firstRol = craps.firstRoll(craps.crapsPlayers.get(0));
//            }while(firstRol != 1 || 2);







            playAgain = Console.getUserInputString("Do you want to continue playing?");
            //first.getName();
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


