package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Util.BlackjackValueUtil;
import io.zipcoder.casino.Games.Blackjack;

import java.util.ArrayList;

public class BlackjackPlayer extends Player{
    protected Player rootPlayer;
    protected ArrayList<Card> hand;
    protected boolean canHit;

    public BlackjackPlayer(Player rootPlayer){
        this.name = rootPlayer.getName();
        this.age = rootPlayer.getAge();

        this.canHit = true;
        this.rootPlayer = rootPlayer;
        this.hand = new ArrayList<Card>();
    }

    public Player getRootPlayer() {
        return rootPlayer;
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

    public boolean isCanHit() {
        return canHit;
    }

    public Integer getHandValue(){
        Integer handValue = 0;
        for (Card card:hand) {
            handValue += BlackjackValueUtil.rankParse(card.getRankEnum());
        }
        return handValue;
    }

}
