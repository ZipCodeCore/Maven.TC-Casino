package io.zipcoder.casino.Player;

import java.util.ArrayList;

public class Dealer extends Player {
    private ArrayList<Class> hand = new ArrayList ();
    public Dealer(String name, int age) {
        super(name, age);
    }
}
