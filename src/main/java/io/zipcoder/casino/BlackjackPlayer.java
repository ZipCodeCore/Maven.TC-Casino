package io.zipcoder.casino;

import io.zipcoder.casino.Deck.Card;

public class BlackjackPlayer extends CardPlayer{

    public BlackjackPlayer(Player person) {
        super();
    }

    public int getScore() {
        int sum = 0;
        for(Card card: hand) {
            sum += card.getValue();
        }

        if(isAceInHand() && sum <= 11) {
            sum += 10;
        }
        return sum;
    }

    private boolean isAceInHand() {
        for(Card card: hand) {
            if(card.getValue() == 1) {
                return true;
            }
        }
        return false;
    }

}
