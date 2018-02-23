package io.zipcoder.casino.Games.Dealer;

import io.zipcoder.casino.GameTools.Deck.BlackjackCard;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.Games.Blackjack;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<BlackjackCard> hand;

    public void setHand(ArrayList<BlackjackCard> hand){
        this.hand = hand;
    }

    public void addToHand(BlackjackCard card){
        this.hand.add(card);
    }

    public ArrayList<BlackjackCard> getHand() {
        return hand;
    }

    public Integer getHandValue(){
        Integer handValue = 0;
        for (BlackjackCard card:hand) {
            handValue += card.getBlackjackRankEnum().getRankValue();
        }
        return handValue;
    }

    public boolean canHit(){
        if (getHandValue() < 17) return true;
        return false;
    }

}
