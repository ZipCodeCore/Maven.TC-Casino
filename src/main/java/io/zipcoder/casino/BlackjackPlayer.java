package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackjackPlayer extends Player<BlackjackPlayer> implements Comparable<BlackjackPlayer>, Gamble {

    public String name;
    private Double money;
    private static ArrayList<Card> cardsInHand;

    BlackjackPlayer(String name, Double money) {
        this.name = name;
        this.money = money;
        this.cardsInHand = new ArrayList<>();

    }

    public boolean hitStay(String userAnswer) {
        if (userAnswer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    //Stubbed this method out b/c may be needed in console/actual game-play integration... delete it if not...
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

    public static String viewHand() {
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
            if (card.getCardsValue() == 11)
                acesCount++;
            total += card.getCardsValue();
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
