package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.BlackjackCard;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.Games.Blackjack;

import java.util.ArrayList;

public class BlackjackPlayer extends Player{
    protected Player rootPlayer;
    protected ArrayList<BlackjackCard> hand;
    protected boolean canHit;

    public BlackjackPlayer(Player rootPlayer){
        this.name = rootPlayer.getName();
        this.age = rootPlayer.getAge();
        this.canHit = true;
        this.rootPlayer = rootPlayer;
        this.hand = new ArrayList<BlackjackCard>();
    }

    public Player getRootPlayer() {
        return rootPlayer;
    }

    public void setHand(ArrayList<BlackjackCard> hand){
        this.hand = hand;
    }

    public void addToHand(BlackjackCard card){
        this.hand.add(card);
    }

    public ArrayList<BlackjackCard> getHand() {
        return hand;
    }

    public boolean isCanHit() {
        return canHit;
    }

    public Integer getHandValue(){
        Integer handValue = 0;
        for (BlackjackCard card:hand) {
            handValue += card.getBlackjackRankEnum().getRankValue();
        }
        return handValue;
    }

}
