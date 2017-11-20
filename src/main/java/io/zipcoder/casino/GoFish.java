package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GoFish extends CardGame {

    GoFishPlayer player;
    GoFishPlayer dealer;


    public GoFish(Player player) {
        this.player = new GoFishPlayer(player);
        Player dealer = new Player("Dealer",0,0);
        this.dealer = new GoFishPlayer(dealer);
    }

    public void goFishStart() {
        deal(player,dealer,7);
        playerTurn();


    }

    private void playerTurn() {
        boolean playing = true;
        while (playing) {
            Console.print(player.getStringDisplayHand());
            Card askCard = getCard("Give me all your: ");
            if (isCardInHand(askCard, dealer.getHand())) {
                dealer.getHand().remove(askCard);
                player.addCard(askCard);
            } else {
                Console.print("GO FISH!");
                giveCard(player);
                playing = false;
            }
        checkForBooks(player);
        }
    }


    private boolean dealerAsk() {
        boolean playing = true;
        while(playing){
            dealerFindCard()

        }
    }

    private Card dealerFindCard(){

        return null;
    }

    private boolean isCardInHand(Card askCard, ArrayList<Card> hand) {
        for (Card card : hand) {
            if (card.getValue().equals(askCard.getValue())) {
                return true;
            }
        }
        return false;
    }

    private Card getCard(String prompt) {
        String input = Console.getString("Give me all your: ");

        }

        return null;

    }

    private void removeCard(Card card, ArrayList<Card> hand) {

    }

    private Card checkForBooks(GoFishPlayer player) {

        for (Card card1 : player.getHand()) {
            int num = 0;
            for (Card card2 : player.getHand())
                if (card1 == card2)
                    num++;
            if (num == 4) {
                for (int i = 0; i < 4; i++)
                    player.getHand().remove(card1);
                player.setBookCounter(1);
                return card1;
            }
        }
        return null;

    }

    private void compareBooks() {
        if (player.getBookCounter() > dealer.getBookCounter()) {
            System.out.println("You win!");
        } else if (player.getBookCounter() < dealer.getBookCounter()) {
            System.out.println("You lose!");
        } else {
            System.out.println("Tie!");
        }
    }


}
