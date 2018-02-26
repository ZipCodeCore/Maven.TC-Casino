package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Util.BlackjackValueUtil;

import java.util.ArrayList;

public class BlackjackPlayer extends Player{

    protected Player rootPlayer;
    protected ArrayList<Card> hand;
    protected boolean canHit;
    public boolean bulkApperception = false;
    public boolean charm = false;

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
        int aceCounter = 0;
        for (Card card:hand) {
            if (card.getRankEnum().equals(Rank.ACE)) aceCounter++;
            handValue += BlackjackValueUtil.rankParse(card.getRankEnum());
        }
        if (aceCounter > 0 && handValue > 21) handValue -= 10;
        return handValue;
    }

    public void payoutWin(int money){
        rootPlayer.wallet.add(money);
    }

    public void payoutLoss(int money){
        rootPlayer.wallet.subtract(money);
    }

}
