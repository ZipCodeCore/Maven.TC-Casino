package io.zipcoder.casino.Game.cardGame.utilities;

public class Card {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        StringBuilder card = new StringBuilder();
        card.append(suit.getSuitSymbols() + " " + rank + " " + suit.getSuitSymbols());

        return card.toString();
    }
}






