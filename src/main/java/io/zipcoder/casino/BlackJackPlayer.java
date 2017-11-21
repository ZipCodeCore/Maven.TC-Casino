package io.zipcoder.casino;

import static io.zipcoder.casino.Card.FaceValue.ACE;

public class BlackJackPlayer extends Player<BlackJack> {

    public BlackJackPlayer(String name) {
        super(name);
    }

    public boolean hasAceInHand() {
        return hasCardsOfRank(ACE);
    }
}
