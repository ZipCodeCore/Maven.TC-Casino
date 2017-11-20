package io.zipcoder.casino;

public class BlackjackDealer extends BlackjackPlayer{

    public BlackjackDealer(Player person) {
        super(person);
    }

    public boolean hitDealer(){
        return getScore() < 17;
    }
}
