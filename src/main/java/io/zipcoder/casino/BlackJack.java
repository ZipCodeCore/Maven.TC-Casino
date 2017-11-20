package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackJack extends CardGame implements Gamble {

    public final int MIN_NUMBER_OF_PLAYERS = 2;
    public final int MAX_NUMBER_OF_PLAYERS = 7;
    private Player<BlackJack> dealer;
    private HashMap<Player<BlackJack>, Double> bets = new HashMap<Player<BlackJack>, Double>();

    public BlackJack(int numStandardDecks) {
        super(numStandardDecks);
    }

    public void dealInitialCards() {

    }

    public void dealCardToHand(BlackJackPlayer player) {

    }

    public void putCardsInDiscardPile() {

    }

    public void shuffleCardsWhenStockIsEmpty() {

    }

    public ArrayList<Player<BlackJack>> determineWinners() {
        return null;
    }

    public void takeBet(Double amount) {

    }

    public void payOutBets() {

    }

    @Override
    public void setPointValues() {

    }
}
