package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Deck.Card;
import io.zipcoder.casino.Deck.Deck;

abstract class CardGame {
    Deck deck = new Deck();

    public void deal(Player player,Player dealer,int amount){
        clearHands(player,dealer);
        for(int i =0;i<amount;i++){
            dealer.addCard(deck.getCard());
            player.addCard(deck.getCard());
        }
    }

    public boolean giveCard(Player player){
        Card addCard = deck.getCard();
        if(addCard != null){
            player.addCard(deck.getCard());
            return true;
        }
        return false;
    }

    public void clearHands(Player player,Player dealer){
        player.clearHand();
        dealer.clearHand();

    }

    public void printHand(Player player){
        Console.print("You have\n"+ player.getStringDisplayHand());
    }

}
