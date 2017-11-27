package io.zipcoder.casino;

public class GameInterface {


    public void playCraps() {


        String playAgain;


        do {Craps craps = new Craps();
           // CrapsPlayer player = new CrapsPlayer();
            System.out.println("Welcome to the craps table.");



         //   int numberOfPlayer = Console.getUserInputInteger("Welcome to the craps table. How many people are playing?");
            //creates players

           // for(int i = 1; i <= numberOfPlayer; i++){
                craps.createOnePlayer(Console.getUserInputString("Player name:"));
            //}

             //get players bets
//            for(int b = 0; b <= numberOfPlayer; b++){
//                System.out.println(craps.crapsPlayers.get(b).getName());
//                Double playerBet = craps.crapsPlayers.get(b).bet(Console.getUserInputDouble(" please place bet"));
//                System.out.println(craps.crapsPlayers.get(b).getName()+" you bet " + playerBet);
//            }


                CrapsPlayer.crapPlayerMoney(Console.getUserInputDouble("How many chips would you like to purchase?"));


//            craps.takePlayerBet(Consol.Input)
//            craps.playersFirstRoll(Console.)

//           if()
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
            String dealersTurn = "no";

            while (playersTurn.equals("yes") && dealersTurn.equals("no")) {

                while (playersTurn.equals("yes")) {
                    BlackJack.giveCardToPlayer();
                    BlackJack.giveCardToPlayer();
                    System.out.println("Your hand's total is: " + BlackjackPlayer.viewHand(blackjackPlayer));
                    String hitOrStay = Console.getUserInputString("Do you want to stay? Yes or no...");

                    if (hitOrStay.equalsIgnoreCase("yes")) {
                        BlackjackPlayer.hitStay("yes");
                        BlackJack.endTurn();
                        dealersTurn = "yes";
                        playersTurn = "no";
                        break;
                    }
                    while (hitOrStay.equalsIgnoreCase("no")) {
                        BlackjackPlayer.hitStay("no");
                        System.out.println("Your card was: " + BlackjackPlayer.viewHand(blackjackPlayer));
//                        if (blackjackPlayer.getHandValue() == 21) {
//                            System.out.println("You win!");
//                            playAgain = Console.getUserInputString("Do you want to play another game of Blackjack?");
//                        }
//                        if (blackjackPlayer.getHandValue() > 21) {
//                            System.out.println("You busted");
//                            playAgain = Console.getUserInputString("Do you want to play another game of Blackjack?");
//                        }
                        String hitOrStayAgain = Console.getUserInputString("Do you want to stay? Yes or no...");
                        if (hitOrStayAgain.equalsIgnoreCase("yes")) {
                            BlackJack.endTurn();
                            playersTurn = "no";
                            dealersTurn = "yes";
                            break;
                        }
                    }
                }

                while (dealersTurn.equals("yes") && playersTurn.equals("no")) {

                    while (dealersTurn.equals("yes")) {
                        BlackJack.giveCardToPlayer();
                        System.out.println("The dealer's card was: " + BlackjackPlayer.viewHand(blackjackPlayer));
                        String hitOrStay = Console.getUserInputString("Does the dealer want to stay? Yes or no...");
//                        if (blackjackPlayer.getHandValue() == 21) {
//                            System.out.println("The dealer won!");
//                            playAgain = Console.getUserInputString("Do you want to play another game of Blackjack?");
//                        }
//                        if (blackjackPlayer.getHandValue() > 21) {
//                            System.out.println("The dealer busted");
//
                        if (hitOrStay.equalsIgnoreCase("yes")) {
                            BlackjackPlayer.hitStay("yes");
                            BlackJack.endTurn();
                            dealersTurn = "no";
                            playersTurn = "yes";
                            break;
                        }
                        while (hitOrStay.equalsIgnoreCase("no")) {
                            BlackjackPlayer.hitStay("no");
                            System.out.println("The dealer's card was: " + BlackjackPlayer.viewHand(blackjackPlayer));

                            String hitOrStayAgain = Console.getUserInputString("Does the dealer want to stay? Yes or no...");
                            if (hitOrStayAgain.equalsIgnoreCase("yes")) {
                                BlackJack.endTurn();
                                dealersTurn = "no";
                                playersTurn = "yes";
                                break;
                            }
                        }
                    }
                }
            }

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

        do {
            System.out.println("Welcome to the Go Fish table!!!");

            for (int i = 0; i <= 1; i++) {
                goFish.createOnePlayer(Console.getUserInputString("What is your name?"));
            }

            goFish.goFishPlayers.get(0).dealGoFishHand(goFish.goFishPlayers, goFishDeck);

            goFish.showEverybodysHand();

            goFish.askOtherPlayerForCard();


            int cardToAskFor = Console.getUserInputInteger("What card do you want to ask for? \nPlease input the index of the card 1 through " + goFish.goFishPlayers.get(0).getHandList().size() + "!");

            goFish.askFirstPlayerForCard();

        } while (playAgain.equals("no"));
        CardGames cardGames = new CardGames();
        cardGames.chooseGameType();

    }

}


