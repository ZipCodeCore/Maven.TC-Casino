package io.zipcoder.casino;

public class CrapsPlayer extends Player<CrapsPlayer> implements Gamble {

    private Card cardsInHand;

    CrapsPlayer(String name, Double money) {
        super(name, money);
    }

    public Double bet(Double bet) {
        return null;
    }

    public static void firstRoll() {
    }

    //We won't be using this method of course, since Craps is a dice game, but I HAD to put this Override method here
    //to fulfill a contract we entered with our arrangement of abstracts and interfaces... it's just one of those
    //things we didn't anticipate when we were making the UML and now we are stuck with...
    @Override
    public void addCardToHand(Card newCard) {
        cardsInHand.add(newCard);
    }
}
