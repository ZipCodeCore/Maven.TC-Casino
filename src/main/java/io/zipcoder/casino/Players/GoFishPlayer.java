package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.InputOutput.InputOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public abstract class GoFishPlayer extends Player {
    protected List<Card> cardHand;
    protected int numPairs;

    protected GoFishPlayer(Player rootPlayer) {
        super(rootPlayer.getName(), rootPlayer.getAge());
        cardHand = new ArrayList<Card>();
        numPairs = 0;
    }

    public GoFishPlayer(String name) {
        cardHand = new ArrayList<>();
        numPairs = 0;
        this.name = name;
    }

    public void addPair() {
         numPairs++;
    }

    public int getNumPairs() {
        return numPairs;
    }


    public void addCardToHand(Card cardToAdd) {
        if (this.hasCard(cardToAdd)) {
            System.out.println("\n" + this.getName() + " made a match. One point.\n");
            this.addPair();
            this.removeMatches(cardToAdd.getRankEnum());
        }
        else {
            this.cardHand.add(cardToAdd);
        }
    }

    public void removeMatches(Rank rankToCompare) {
        Iterator carditr = cardHand.iterator();
        while(carditr.hasNext()) {
            Card card = (Card) carditr.next();
            if(card.getRankEnum().equals(rankToCompare)) {
                carditr.remove();
            }
        }
    }

    public int getCardHandSize() {
        return this.cardHand.size();
    }

    public boolean isHandEmpty(){
        return this.cardHand.isEmpty();
    }

    public Boolean hasCard(Card cardAskedFor) {
        for(Card card : cardHand) {
            if(card.getRankEnum().equals(cardAskedFor.getRankEnum())) {
                return true;
            }
        }
        return false;
    }

    public void removeCard(Card cardToRemove) {
        Iterator carditr = cardHand.iterator();
        while(carditr.hasNext()) {
            Card card = (Card) carditr.next();
            if(card.getRankEnum().equals(cardToRemove.getRankEnum())) {
                carditr.remove();
            }
        }
    }

    public abstract GoFishPlayer pickOpponentToAsk(List<GoFishPlayer> opponents);

    public abstract Card pickCard();
}
