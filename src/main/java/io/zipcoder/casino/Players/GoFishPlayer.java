package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.InputOutput.InputOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class GoFishPlayer extends Player {
    public List<Card> cardHand;
    private int numPairs;
    private InputOutput inputOutput = new InputOutput();

    public GoFishPlayer(Player rootPlayer) {
        super(rootPlayer.getName(), rootPlayer.getAge());
        cardHand = new ArrayList<Card>();
        numPairs = 0;
    }

    public GoFishPlayer(){

    }

    public GoFishPlayer(String name) {
        cardHand = new ArrayList<Card>();
        numPairs = 0;
        this.name = name;
    }

    public void addPair() {
         numPairs++;
    }

    public int getNumPairs() {
            return numPairs;
    }

    public void takeTurn() {
        this.pickCard();

    }

    public void showCards() {
        StringBuilder showCardHand = new StringBuilder("\n");
        for (int i = 0; i < cardHand.size(); i++) {
            showCardHand.append((i + 1))
                    .append(": ")
                    .append(this.cardHand.get(i))
                    .append("\n");
        }
        System.out.println(showCardHand.toString());
    }

    public void showOpponents(List<GoFishPlayer> opponents) {
        StringBuilder showOpponents = new StringBuilder();
        for (int i = 0; i < opponents.size(); i++) {
            showOpponents.append((i + 1))
                    .append(": ")
                    .append(opponents.get(i).getName())
                    .append("\n");
        }
        System.out.println(showOpponents.toString());
    }

    public GoFishPlayer pickOpponentToAsk(List<GoFishPlayer> opponents) {
        this.showOpponents(opponents);
        int opponentIndex = inputOutput.promptForInt("Enter the number for the player you want to ask:");
        return opponents.get(opponentIndex -1);
    }

    public Card pickCard() {
        this.showCards();
        int cardIndex = inputOutput.promptForInt("Enter the number of your card choice:");
        return cardHand.get(cardIndex -1);
    }

    public void goFish(Card card) {
        this.cardHand.add(card);

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

}
