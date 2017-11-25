package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJack extends CardGame implements PlayForMoney {
    private Bank house;
    private Deck gameDeck;
    BlackJackPlayer blackJackPlayer;

    ArrayList<Double> moneyfromPlayers = new ArrayList<Double>();

    public ArrayList<Card> getDeckCards() {

        return null;
    }

    public double betReceiveFromPlayers() {

        for(Double amountInGame: moneyfromPlayers){
            moneyfromPlayers.add(blackJackPlayer.getBet());
            return amountInGame;
        }
        return 0;
    }

    public void resolveBets() {
    }

    public void bet(CrapsBetType betType, double betAmount) {

    }

    public void takeBet(Double betAmount) {

    }
    public void dealNewHand() {

    }

    public double betInplay() {
        return 0;
    }

    public void hand(Card card1, Card card2) {

        card1.getSuit();

    }


    public void scoreHand() {

    }

    public double makeBet(Double amount) {
        return 0;
    }

    public double collectWinnings(boolean isWin) {
        return 0;
    }
}
