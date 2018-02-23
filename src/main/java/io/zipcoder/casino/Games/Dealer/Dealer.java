package io.zipcoder.casino.Games.Dealer;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Util.BlackjackValueUtil;
import io.zipcoder.casino.Games.Blackjack;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand;

    public Dealer(){
        hand = new ArrayList<Card>();
    }

    public void setHand(ArrayList<Card> hand){
        this.hand = hand;
    }

    public void addToHand(Card card){
        this.hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public Integer getHandValue(){
        Integer handValue = 0;
        for (Card card:hand) {
            handValue += BlackjackValueUtil.rankParse(card.getRankEnum());
        }
        return handValue;
    }

    public boolean canHit(){
        if (getHandValue() < 17) return true;
        return false;
    }

}
