package io.zipcoder.casino;

public class CardPlayer<T extends CardGame<T>> extends Player<T> {

    private CardPile hand = new CardPile();

    public CardPlayer(String name) {
        super(name);
    }

    public void addCardToHand(Card card) {
        hand.addCardToPile(card);
    }

    public void addCardsToHand(CardPile cardPile) {
        hand.addCardsToPile(cardPile);
    }

    public boolean hasCardsOfRank(Card.FaceValue rank) {
        CardPile hand = this.getHand();
        for(Card.Suit suit : Card.Suit.values()) {
            Card cardToCheck = new Card(rank, suit);
            if(hand.contains(cardToCheck)) {
                return true;
            }
        }
        return false;
    }

    public CardPile getHand() {
        return hand;
    }
}
