package io.zipcoder.casino;

public class Player<T extends Game> {

    private String name;
    private Double money;
    private CardPile hand = new CardPile();

    public Player(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public void receiveWinnings(Double money) {
        this.money += money;
    }

    public void bet(Double money) {
        this.money -= money;
    }

    public CardPile getHand() {
        return hand;
    }

    public void cashOut() {
        money = 0.0;
    }
}
