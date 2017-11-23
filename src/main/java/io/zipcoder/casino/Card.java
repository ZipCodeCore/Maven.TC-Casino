package io.zipcoder.casino;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Rank rank,Suit suit){
        this.suit = suit;
        this.rank = rank;
    }




    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank.getSymbol() + suit.getCardSymbol();
    }


}