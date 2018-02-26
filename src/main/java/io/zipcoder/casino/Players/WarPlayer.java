package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.Wallet;

import java.util.ArrayList;

public class WarPlayer extends Player {

    public ArrayList<Card> currentHand;
    public Integer points = 0;

    public WarPlayer() {
        super.name = "";
        super.age = Integer.MAX_VALUE;
        this.currentHand = new ArrayList<>();
        this.points = 0;
    }

    public WarPlayer(String name, Integer age) {
        super.name = name;
        super.age = age;
        this.currentHand = new ArrayList<>();
        this.points = 0;
    }

    public WarPlayer(Player player) {
        this.name = player.getName();
        this.age = player.getAge();
        this.currentHand = new ArrayList<>();
        this.points = 0;
    }

    public void addToHand(Card card) {
        currentHand.add(card);
    }

    public void setName(String name) {
        super.name = name;
    }

    public void setAge(int age) {
        super.age = age;
    }

    public String getName() {
        return super.getName();
    }

    public Integer getAge() {
        return super.getAge();
    }

    public Integer getPoints() {
        return this.points;
    }

    public void addPoint(Integer points) {
        this.points += points;
    }

    public void resetPoints() {
        this.points = 0;
    }

}
