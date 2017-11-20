package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

import static io.zipcoder.casino.Card.FaceValue.*;

public class GoFish extends CardGame<GoFish> {

    public final int MIN_NUMBER_OF_PLAYERS = 2;
    public final int MAX_NUMBER_OF_PLAYERS = 5;
    private final HashMap<Card.FaceValue, Integer> pointValues = new HashMap<Card.FaceValue, Integer>();
    private int numPlayers = 0;
    private int numInitialCards = 0;


    public GoFish() {
        super(1);
        setPointValues();
    }

    public void setNumInitialCards() {
        numPlayers = getNumPlayers();
        if(numPlayers >= MIN_NUMBER_OF_PLAYERS && numPlayers <= 3) {
            numInitialCards = 7;
        } else {
            numInitialCards = 5;
        }
    }

    public void dealInitialCards() {
        for(int i = 0; i < numInitialCards; i++) {
            for(Player<GoFish> player : getPlayers()) {
                GoFishPlayer goFishPlayer = (GoFishPlayer) player;
                goFishPlayer.addCardToHand(drawFromStock());
            }
        }
    }

    public void playerGoFish(GoFishPlayer player) {
        player.goFish(this.drawFromStock());
    }

    public GoFishPlayer determineWinner() {
        int maxPoints = 0;
        GoFishPlayer winner = null;
        for(Player<GoFish> player : getPlayers()) {
            GoFishPlayer goFishPlayer = (GoFishPlayer) player;
            int score = 0;
            for(CardPile book : goFishPlayer.getBooks()) {
                score += pointValues.get(book.getCard(0).getFaceValue());
            }
            if(score > maxPoints) {
                winner = goFishPlayer;
            }
        }
        return winner;
    }

    @Override
    public void setPointValues() {
        pointValues.put(TWO, 1);
        pointValues.put(THREE, 2);
        pointValues.put(FOUR, 3);
        pointValues.put(FIVE, 4);
        pointValues.put(SIX, 5);
        pointValues.put(SEVEN, 6);
        pointValues.put(EIGHT, 7);
        pointValues.put(NINE, 8);
        pointValues.put(TEN, 9);
        pointValues.put(JACK, 10);
        pointValues.put(QUEEN, 11);
        pointValues.put(KING, 12);
        pointValues.put(ACE, 13);
    }
}
