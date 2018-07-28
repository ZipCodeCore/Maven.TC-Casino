package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJackGambler extends CardPlayer {

    private Integer chipCount;

    public BlackJackGambler(Player player, Integer chipCount) {
        super(player);
        this.chipCount = chipCount;
    }

    public Integer getChipCount() {
        return chipCount;
    }

    public void addChips(Integer amount) {
        chipCount += amount;
    }

    public Integer tradeInChips() {
        Integer chips = chipCount;
        chipCount = 0;
        return chips;
    }

    public Integer placeBet(Integer amount) {
        if (wagerAvailable(amount))
            chipCount -= amount;
        else {
            amount = chipCount;
            chipCount = 0;
        }

        return amount;
    }

    private boolean wagerAvailable(Integer bet) {
        if (bet > chipCount)
            return false;
        else return true;
    }

    public int getHandTotal() {
        int total = 0;
        String card;
        int aces = 0;
        for (Card c : getHand()) {
            card = c.getRank().toString();
            if ("JACK".equals(card) || "QUEEN".equals(card) || "KING".equals(card))
                total += 10;
            else if ("ACE".equals(card.toString())) {
                total += 11;
                aces++;
            } else total += c.getValue();
        }
        while (total > 21 && aces != 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    public String showHand() {
        return getName() + ": " + handToString() + " Total: " + getHandTotal();
    }

}
