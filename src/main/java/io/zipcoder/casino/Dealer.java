package io.zipcoder.casino;

public class Dealer extends BlackJackGambler{


    public Dealer() {
        super(new Player("Dealer",0, false),10);
    }

    public String showOneCard() {
        return "Dealer Top Card: " + getHand().get(0);
    }

    public void resetHand() {
        clearHand();
    }

}
