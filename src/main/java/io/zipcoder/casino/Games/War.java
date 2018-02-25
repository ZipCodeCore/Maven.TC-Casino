package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.WarPlayer;

import java.util.Scanner;

public class War implements Game {

   private Integer playerPoints;
   private Integer player2Points;
   private WarPlayer player1;
   private WarPlayer player2;
   private Deck warDeck;

   private boolean isPlaying = true;

    public void startGame(){
        player1 = new WarPlayer();
        player2 = new WarPlayer("Computer", 25);
        warDeck = new Deck();

        System.out.println(displayLogo());

        do {
            deal();
            takeTurn();
        }
        while(isPlaying);
    }

    public void endGame(){
        System.out.println("Thank you for playing War. Comeback soon");
        isPlaying = false;
    }

    public void deal() {

        warDeck.shuffleDeck();

//        for(int i = 0; i < warDeck.deck.size(); i++) {
//            player1.currentHand.add(warDeck.deck.get(i));
//            warDeck.deck.remove(i);
//            player2.currentHand.add(warDeck.deck.get(i));
//            warDeck.deck.remove(i);
//        }
        do {
            player1.currentHand.add(warDeck.deck.get(0));
            warDeck.deck.remove(0);
            player2.currentHand.add(warDeck.deck.get(0));
            warDeck.deck.remove(0);

        } while (warDeck.deck.size() > 0);
    }

    public void takeTurn() {
        Scanner input = new Scanner(System.in);
        String deal = input.nextLine();
        int counter = 0;
        while(deal != null) {
            if(player1.currentHand.size() == 0) {
                continue;
            }
            counter++;
            System.out.println(player1.currentHand.get(0).toCardArt());
            System.out.println(player2.currentHand.get(0).toCardArt());
            System.out.println(counter);
            compareCards(player1.currentHand.get(0), player2.currentHand.get(0));

            player1.currentHand.remove(0);
            player2.currentHand.remove(0);
        }
        //playAgain();
    }

    public void compareCards(Card card1, Card card2) {

       /* if (card1.getRankEnum().getRankValue() == card2.getRankEnum().getRankValue()) {
            itIsWar(card1, card2);
        } else */if(card1.getRankEnum().getRankValue() > card2.getRankEnum().getRankValue()) {
            awardPoint(player1);
            System.out.println("WINNER: " + player1.getName());
            System.out.println("===========================");
        } else {
            awardPoint(player2);
            System.out.println("WINNER: " + player2.getName());
            System.out.println("===========================");
        }
    }

    public void itIsWar(Card card1, Card card2) {
        System.out.println("=================================");
        System.out.println(displayItIsWarLogo());
        System.out.println("=================================");

        for(int i = 0; i < 5; i++) {
            System.out.println("1. | " + player1.currentHand.get(0));
            System.out.println("2. | " + player2.currentHand.get(0));

            compareCards(player1.currentHand.get(0), player2.currentHand.get(0));

            player1.currentHand.remove(0);
            player2.currentHand.remove(0);
        }

    }

    public void awardPoint(WarPlayer player) {
        player.addPoint();
    }

    public Integer doesUserWantToPlayAgain() {
        InputOutput io = new InputOutput();
        Integer yesOrNo = io.promptForInt("Do you want to play again? (\n1. Yes\n2. No)");
        return yesOrNo;
    }

    public void playAgain() {
        if(doesUserWantToPlayAgain() == 1) {
            isPlaying = true;
        } else {
            isPlaying = false;
        }
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

    public String displayItIsWarLogo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n" +
                "   |\\                     /)\n" +
                " /\\_\\\\__               (_//\n" +
                "|   `>\\-`     _._       //`)\n" +
                " \\ /` \\\\  _.-`:::`-._  //\n" +
                "  `    \\|`    :::    `|/\n" +
                "        |     :::     |\n" +
                "        |.....:::.....|\n" +
                "        |:::::::::::::|\n" +
                "        |     :::     |\n" +
                "        \\     :::     /\n" +
                "         \\    :::    /\n" +
                "          `-. ::: .-'\n" +
                "           //`:::`\\\\\n" +
                "          //   '   \\\\\n" +
                "         |/         \\\\" + "\n\n");

        return sb.toString();
    }

    public static void main(String[] args) {
        War war = new War();
        System.out.println(war);
    }
}
