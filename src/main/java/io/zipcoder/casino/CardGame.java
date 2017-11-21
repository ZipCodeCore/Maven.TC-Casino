package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Deck.Card;
import io.zipcoder.casino.Deck.Deck;

abstract class CardGame extends Casino {
    Deck deck = new Deck();

    public void deal(CardPlayer player,CardPlayer dealer,int amount){
        clearHands(player,dealer);
        deck.shuffle();
        for(int i =0;i<amount;i++){
            dealer.addCard(deck.getCard());
            player.addCard(deck.getCard());
        }
    }

    public boolean giveCard(CardPlayer player) {
        Card addCard = deck.getCard();
        if (addCard != null) {
            player.addCard(deck.getCard());
            return true;
        }
        return false;
    }

    public void clearHands(CardPlayer player, CardPlayer dealer) {
        player.clearHand();
        dealer.clearHand();

    }

    public void printHand(CardPlayer player) {
        Console.print("You have\n" + player.getStringDisplayHand());
    }


    public void testDeal(CardPlayer player, int amount) {
        for (int i = 0; i < amount; i++) {
            player.addCard(deck.getCard());
        }
    }
}