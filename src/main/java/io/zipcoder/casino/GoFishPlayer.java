package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFishPlayer extends Player {
    private int score;
    private ArrayList<Card> hand = new ArrayList<Card>();


    public Card drawCard(Deck deck) {
        Card playerCard = deck.getCards().remove(0);
        return playerCard;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public boolean checkHandForCard(Rank rank){
        for(Card card: hand){
            if(card.getRank() == rank) return true;
        }return false;

    }

    public Card giveCard(Rank rank){
        for(Card card: hand){
            if(card.getRank() == rank){
                hand.remove(card);
                return card;
            }
        }
        return null;
    }

    public boolean checkFourOfAKind(){
        for(Card card: hand){
            
        }
    }

    public void drawFiveCards(){

    }


}
