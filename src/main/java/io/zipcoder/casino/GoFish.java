package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFish extends CardGames {

    private ArrayList<GoFishPlayer> goFishPlayers = new ArrayList<>();
    private Deck goFishDeck;
    private Player activePlayer1;
    private Player activePlayer2;


    public GoFish() {
        start();
    }

    protected void start() {

        GoFishPlayer goFishPlayer1 = new GoFishPlayer("AA-Wrong");
        GoFishPlayer goFishPlayer2 = new GoFishPlayer("Cifu");
        goFishPlayers.add(goFishPlayer1);
        goFishPlayers.add(goFishPlayer2);
        activePlayer1 = goFishPlayer1;
        activePlayer2 = goFishPlayer2;
        Deck goFishDeck = new Deck();
        goFishDeck.populate();
        goFishDeck.shuffle();
        //giveCardToPlayer();

        goFishPlayer1.dealGoFishHand(goFishPlayers, goFishDeck);
    }
    public void giveCardToPlayer() {
        Card card = this.goFishDeck.dealOneRandomCard();
        this.activePlayer1.addCardToHand(card);
        this.activePlayer2.addCardToHand(card);
    }

    public ArrayList<GoFishPlayer> getPlayers() {
        return goFishPlayers;
    }

    public GoFishPlayer getPlayerAtIndex(int index) {
        return goFishPlayers.get(index);
    }


    public Player getActivePlayer() {
        return activePlayer1;
    }
}
