package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends CardGame {

    private int playerBookCount = 0;
    private int dealerBookCount = 0;
    Player dealer = new Player("Dealer", 0, 6);

    public GoFish() {

    }

    public void goFishStart() {
        deal(casinoplayer, dealer, 7);
        playerTurn();


    }

    private void playerTurn() {
        boolean playing = true;
        while (playing) {
            Console.print(casinoplayer.getStringDisplayHand());
            Card askCard = getCard("Give me all your: ");
            if (isCardInHand(askCard, dealer.getPlayerHand())) {
                dealer.getPlayerHand().remove(askCard);
                casinoplayer.addCard(askCard);
            } else {
                Console.print("GO FISH!");
                giveCard(casinoplayer);
                playing = false;
            }
        }
    }


    private boolean dealerAsk() {
        return false;
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

    private Card checkForBooks(Player player) {
        ArrayList<Card> hand = player.getPlayerHand();
        for (Card card1 : hand) {
            int num = 0;
            for (Card card2 : hand)
                if (card1 == card2)
                    num++;
            if (num == 4) {
                for (int i = 0; i < 4; i++)
                    hand.remove(card1);
                //ADD TO PLAYER BOOK COUNT
                return card1;
            }
        }
        return null;

    }

    private void compareBooks() {
        if (playerBookCount > dealerBookCount) {
            System.out.println("You win!");
        } else if (playerBookCount < dealerBookCount) {
            System.out.println("You lose!");
        } else {
            System.out.println("Tie!");
        }
    }


}
