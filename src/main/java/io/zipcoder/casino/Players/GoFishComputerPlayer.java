package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.InputOutput.InputOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GoFishComputerPlayer extends GoFishPlayer {
    private Random rand;

    public GoFishComputerPlayer(String name) {
        super(name);
        rand = new Random();
    }

    public int getNumPairs() {
        return numPairs;
    }

    @Override
    public GoFishPlayer pickOpponentToAsk(List<GoFishPlayer> opponents) {
        int opponentIndex = rand.nextInt(opponents.size());
        return opponents.get(opponentIndex);
    }

    @Override
    public Card pickCard() {
        int cardIndex = rand.nextInt(this.cardHand.size());
        return this.cardHand.get(cardIndex);
    }

}

