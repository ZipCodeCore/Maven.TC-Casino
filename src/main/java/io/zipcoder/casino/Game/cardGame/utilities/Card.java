package io.zipcoder.casino.Game.cardGame.utilities;

public class Card implements Comparable<Card> {
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


    @Override
    public int compareTo(Card anyCard) {

        if (getRank().compareTo(anyCard.getRank()) > 0) {
            return 1;
        } else if (getRank().compareTo(anyCard.getRank()) < 0) {
            return -1;
        } else {
            return getSuit().compareTo(anyCard.getSuit());
        }
    }
}






