package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.Wallet;

import java.util.ArrayList;

public class WarPlayer extends Player {

    public ArrayList<Card> currentHand;

    public WarPlayer() {
        super.name = "";
        super.age = Integer.MAX_VALUE;
    }

    public WarPlayer(String name, Integer age) {
        super.name = name;
        super.age = age;
    }

    public void setCurrentHand(Card card) {
        //currentHand = new ArrayList<>();
        currentHand.add(card);
    }

    public void setName(String name) {
        super.name = name;
    }

    public void setAge(int age) {
        super.age = age;
    }

}
