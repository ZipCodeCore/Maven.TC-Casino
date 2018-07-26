package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackjackPlayer extends Player<BlackjackPlayer> implements Comparable<BlackjackPlayer>, Gamble {

    private String name;
    private Double money;
    private static ArrayList<Card> cardsInHand;

    BlackjackPlayer(String name, Double money) {
        this.name = name;
        this.money = money;
        cardsInHand = new ArrayList<>();

    }

    static void hitStay(String userAnswer) {
        if (userAnswer.equalsIgnoreCase("yes")) {
            BlackJack.endTurn();
        } else if (userAnswer.equalsIgnoreCase("no")) {
            BlackJack.giveCardToPlayer();
        } else {
            System.out.println("This table is for serious players only, take your money and get out of here!");
        }
    }

    //Stubbed this method out b/c may be needed in console/actual game-play integration... delete it if not...
    public int compareTo(BlackjackPlayer p) {

        return 0;
    }

    public String getName() {
        return name;
    }

    Double checkBalance() {
        return money;
    }

    public Double bet(Double bet) {
        money -= bet;
        return bet;
    }

    public void addCardToHand(Card newCard) {
        cardsInHand.add(newCard);
    }


    static int viewHand(BlackjackPlayer blackjackPlayer) {
        Integer handString = null;
        for (Card card : cardsInHand) {
            handString = card.getCardsValue();
        }
        return handString;
    }

    int getHandValue() {
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

    ArrayList<Card> getHandList() {
        return cardsInHand;
    }

    void addWinnings(Double winnings) {
        money += winnings;
    }

}
