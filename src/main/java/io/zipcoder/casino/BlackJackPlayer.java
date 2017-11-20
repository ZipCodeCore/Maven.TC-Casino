package io.zipcoder.casino;

public class BlackJackPlayer extends Player<BlackJack> {

    public BlackJackPlayer(String name) {
        super(name);
    }

    public boolean hasAceInHand() {
        return false;
    }

    public boolean hasBust() {
        return false;
    }

    public Integer calculatePoints() {
        return 0;
    }

}
