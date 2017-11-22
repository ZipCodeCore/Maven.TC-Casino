package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackjackPlayer extends Player<BlackjackPlayer> implements Comparable<BlackjackPlayer>, Gamble {

    private String name;
    private Double money;
    private ArrayList<Card> cardsInHand;

    BlackjackPlayer(String name, Double money) {
        super.name = name;
        super.money = money;
        this.cardsInHand = new ArrayList<>();
    }

    public boolean hitStay(String userAnswer) {
        if (userAnswer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    public Double bet() {
        return null;
    }

    public int compareTo(BlackjackPlayer p) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public Double checkBalance() {
        return money;
    }

    public Double bet(Double bet) {
        money -= bet;
        return bet;
    }

    public void addCardToHand(Card newCard) {
        cardsInHand.add(newCard);
    }

    public String viewHand() {
        String handString = "";
        for (Card card : cardsInHand) {
            handString += card.toString();
        }
        return handString;
    }

    public int getHandValue() {
        int total = 0;
        int acesCount = 0;

        for (Card card : cardsInHand) {
            if (CardValue.getValue() == 11)
                acesCount++;
            total += CardValue.getValue();
        }

        if (total > 21) {
            while (acesCount > 0) {
                total -= 10;
                acesCount--;
            }
        }
        return total;
    }

    public ArrayList<Card> getHandList() {
        return cardsInHand;
    }

    public void addWinnings(Double winnings) {
        money += winnings;
    }

}