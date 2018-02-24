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
        this.hand = new ArrayList<>();
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

    public void setCanHit(boolean bool){
        this.canHit = bool;
    }

    public Integer getHandValue(){
        Integer handValue = 0;
        for (Card card:hand) {
            handValue += BlackjackValueUtil.rankParse(card.getRankEnum());
        }
        return handValue;
    }

    public void payoutWin(int money){
        rootPlayer.wallet.add(money);
    }

    public void payoutLoss(int money){
        rootPlayer.wallet.subtract(money);
    }

}
