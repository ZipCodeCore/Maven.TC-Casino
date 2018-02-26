package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;

import io.zipcoder.casino.InputOutput.InputOutput;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.Players.WarPlayer;


public class War implements Game {


   public WarPlayer player1;
   public WarPlayer player2;
   public Deck warDeck;

   private boolean isPlaying = true;

    public War(Player player) {
        warDeck = new Deck();
        player1 = new WarPlayer(player);
        player2 = new WarPlayer("Computer", 25);
    }

    public void startGame(){

        System.out.println(displayLogo());

        do {
            if(warDeck.deck.size() == 0){
                warDeck = new Deck();
            }
            player1.resetPoints();
            player2.resetPoints();
            deal();
            takeTurn();
            displayWinner();
            playAgain();

        }
        while(isPlaying);
        endGame();
    }

    public void endGame(){
        System.out.println("Thank you for playing War. Comeback soon\n");
        isPlaying = false;
    }

    public void deal() {
        warDeck.shuffleDeck();

        do {
            player1.currentHand.add(warDeck.deck.get(0));
            warDeck.deck.remove(0);
            player2.currentHand.add(warDeck.deck.get(0));
            warDeck.deck.remove(0);

        } while (warDeck.deck.size() > 0);
    }

    public void takeTurn() {
        InputOutput io = new InputOutput();
        String deal = io.promptForString("Press Enter to play a card");

        do {
            if(player1.currentHand.size() == 0) {
                break;
            }
            System.out.println(player1.currentHand.get(0).toCardArt());
            System.out.println(player2.currentHand.get(0).toCardArt());

            compareCards(player1.currentHand.get(0), player2.currentHand.get(0));

            deal = io.promptForString("Press Enter to play another");

            player1.currentHand.remove(0);
            player2.currentHand.remove(0);

        } while(deal.equals(""));
    }

    public void compareCards(Card card1, Card card2) {
        if (card1.getRankEnum().getRankValue() == card2.getRankEnum().getRankValue()) {
            System.out.println("TIE");
            System.out.println(player1.getName() + " | " + player1.getPoints());
            System.out.println(player2.getName() + " | " + player2.getPoints());
            System.out.println("===========================");
        } else if(card1.getRankEnum().getRankValue() > card2.getRankEnum().getRankValue()) {
            awardPoint(player1);
            System.out.println("WINNER: " + player1.getName());
            System.out.println(player1.getName() + " | " + player1.getPoints());
            System.out.println(player2.getName() + " | " + player2.getPoints());
            System.out.println("===========================");
        } else {
            awardPoint(player2);
            System.out.println("WINNER: " + player2.getName() + " | " + player2.getPoints());
            System.out.println(player1.getName() + " | " + player1.getPoints());
            System.out.println(player2.getName() + " | " + player2.getPoints());
            System.out.println("===========================");
        }
    }

    public void awardPoint(WarPlayer player) {
        player.addPoint(2);
    }

    public String highestPoints() {
        if(player1.getPoints() > player2.getPoints()) {
            return "Winner is " + player1.getName();
        } else if (player2.getPoints() > player1.getPoints()){
            return "Winner is " + player2.getName();
        } else {
            return "There is no winner in this war";
        }
    }

    public String doesUserWantToPlayAgain() {
        boolean properEntry = false;
        String yesOrNo;
        InputOutput io = new InputOutput();

        do {
            yesOrNo = io.promptForString("\nDo you want to play again? (Y/N)");
            if(yesOrNo.equals("Y") || yesOrNo.equals("N")){
                properEntry = true;
            }
        } while(!properEntry);
        return yesOrNo;

    }

    public void playAgain() {
        if(doesUserWantToPlayAgain().equals("Y")) {
            this.isPlaying = true;
        } else {
            this.isPlaying = false;
        }
    }


    public void displayWinner() {
        System.out.println(highestPoints());
    }

    public String displayLogo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nWELCOME TO" + "\n" +
                "\n" +
                "                          \n" +
                "██╗    ██╗ █████╗ ██████╗ \n" +
                "██║    ██║██╔══██╗██╔══██╗\n" +
                "██║ █╗ ██║███████║██████╔╝\n" +
                "██║███╗██║██╔══██║██╔══██╗\n" +
                "╚███╔███╔╝██║  ██║██║  ██║\n" +
                " ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝  ╚═╝\n" +
                "                          \n");
        return sb.toString();
    }

}
