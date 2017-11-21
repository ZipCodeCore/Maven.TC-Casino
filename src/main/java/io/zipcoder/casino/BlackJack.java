package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

import static io.zipcoder.casino.Card.FaceValue.*;

public class BlackJack extends CardGame<BlackJack> implements Gamble {

    public final int MIN_NUMBER_OF_PLAYERS = 1;
    public final int MAX_NUMBER_OF_PLAYERS = 7;
    private final HashMap<Card.FaceValue, Integer> pointValues = new HashMap<Card.FaceValue, Integer>();
    private BlackJackPlayer dealer = new BlackJackPlayer("Dealer");
    private HashMap<Player<BlackJack>, Double> bets = new HashMap<Player<BlackJack>, Double>();
    private ArrayList<BlackJackPlayer> winners = new ArrayList<>();
    private ArrayList<BlackJackPlayer> push = new ArrayList<>();

    public BlackJack(int numStandardDecks) {
        super(numStandardDecks);
        setPointValues();
    }

    @Override
    public ArrayList<BlackJackPlayer> getPlayers() {
        return (ArrayList<BlackJackPlayer>) players;
    }

    public BlackJackPlayer getDealer() {
        return dealer;
    }

    public void dealInitialCards() {
        for(int i = 0; i < 2; i++) {
            for(BlackJackPlayer player : getPlayers()) {
                if(bets.containsKey(player)) {
                    dealCardToHand(player);
                }
            }
            dealCardToHand(dealer);
        }
    }

    public void dealCardToHand(BlackJackPlayer player) {
        shuffleCardsWhenStockIsEmpty();
        player.addCardToHand(drawFromStock());
    }

    public void putCardsInDiscardPile() {
        discardCards(dealer.getHand());
        for(BlackJackPlayer player : getPlayers()) {
            discardCards(player.getHand());
        }
    }

    public void shuffleCardsWhenStockIsEmpty() {
        if(getStockPile().numCards() == 0) {
            shuffleDiscardPileBackToStock();
        }
    }

    public Integer calculatePlayerScore(BlackJackPlayer player) {
        int score = 0;
        for(Card card : player.getHand().getCards()) {
            score += pointValues.get(card.getFaceValue());
        }
        if(player.hasAceInHand() && score <= 11) {
            score += 10;
        }
        return score;
    }

    public boolean playerHasBust(BlackJackPlayer player) {
        if(calculatePlayerScore(player) > 21) {
            return true;
        }
        else {
            return false;
        }
    }

    public void determineWinners() {
        if(playerHasBust(dealer)) {
            for(BlackJackPlayer player : getPlayers()) {
                if (!playerHasBust(player)) {
                    winners.add(player);
                }
            }
        }
        else {
            for(BlackJackPlayer player : getPlayers()) {
                if(bets.containsKey(player)) {
                    if (calculatePlayerScore(player) > calculatePlayerScore(dealer)) {
                        winners.add(player);
                    } else if (calculatePlayerScore(player).equals(calculatePlayerScore(dealer))) {
                        push.add(player);
                    }
                }
            }
        }
    }

    @Override
    public void takeBet(Player player, Double amount) {
        bets.put(player, amount);
        player.bet(amount);
    }

    public void payOutBets() {
        for(BlackJackPlayer player : winners) {
            Double amountWon = bets.get(player) * 2;
            player.receiveWinnings(amountWon);
        }
        for(BlackJackPlayer player : push) {
            Double amountWon = bets.get(player);
            player.receiveWinnings(amountWon);
        }
        clearAllBets();
    }

    public void clearAllBets() {
        bets.clear();
        winners.clear();
        push.clear();
    }

    public HashMap<Player<BlackJack>, Double> getBets() {
        return bets;
    }

    @Override
    public void setPointValues() {
        pointValues.put(TWO, 2);
        pointValues.put(THREE, 3);
        pointValues.put(FOUR, 4);
        pointValues.put(FIVE, 5);
        pointValues.put(SIX, 6);
        pointValues.put(SEVEN, 7);
        pointValues.put(EIGHT, 8);
        pointValues.put(NINE, 9);
        pointValues.put(TEN, 10);
        pointValues.put(JACK, 10);
        pointValues.put(QUEEN, 10);
        pointValues.put(KING, 10);
        pointValues.put(ACE, 1);
    }
}
