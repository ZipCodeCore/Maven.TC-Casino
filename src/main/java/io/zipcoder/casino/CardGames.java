package io.zipcoder.casino;

public abstract class CardGames implements Game {
    protected Player player = PlayerWarehouse.getCurrentPlayer();
    protected Deck deck;

    public CardGames() {
        player = new Player();
        deck = new Deck();
        deck.shuffle();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void dealCard(Player playerToReceiveCard){
        Card card = getDeck().getCard();
        playerToReceiveCard.addToHand(card);
    }
}