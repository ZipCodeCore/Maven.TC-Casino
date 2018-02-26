package io.zipcoder.casino.Players;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.InputOutput.InputOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GoFishHumanPlayer extends GoFishPlayer{
    private InputOutput inputOutput = new InputOutput();

    public GoFishHumanPlayer(Player rootPlayer) {
        super(rootPlayer);
    }

    public String showCards() {
        StringBuilder showCardHand = new StringBuilder("\n");
        for (int i = 0; i < cardHand.size(); i++) {
            showCardHand.append((i + 1))
                    .append(": ")
                    .append(this.cardHand.get(i))
                    .append("\n");
        }
        System.out.println(showCardHand.toString());
        return showCardHand.toString();
    }

    public String showOpponents(List<GoFishPlayer> opponents) {
        StringBuilder showOpponents = new StringBuilder();
        for (int i = 0; i < opponents.size(); i++) {
            showOpponents.append((i + 1))
                    .append(": ")
                    .append(opponents.get(i).getName())
                    .append("\n");
        }
        System.out.println(showOpponents.toString());
        return showOpponents.toString();
    }

    public GoFishPlayer pickOpponentToAsk(List<GoFishPlayer> opponents) {
        this.showOpponents(opponents);
        int opponentIndex = inputOutput.promptForInt("Enter the number for the player you want to ask:");
        try {
            return opponents.get(opponentIndex - 1);
        } catch(IndexOutOfBoundsException name) {
            System.out.println("\tTry again. Please enter one of the numbers shown.\n");
            return pickOpponentToAsk(opponents);
        }
    }

    public Card pickCard() {
        this.showCards();
        int cardIndex = inputOutput.promptForInt("Enter the number of your card choice:");
        try {
            return cardHand.get(cardIndex - 1);
        } catch (IndexOutOfBoundsException name) {
            System.out.println("\tTry again. Please enter one of the numbers shown.\n");
            return pickCard();
        }
    }

}
