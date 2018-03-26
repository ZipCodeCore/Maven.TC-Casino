package io.zipcoder.casino.GoFishGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Console;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class AskForCardLogic {
    private Player currentPlayer;
    private Player playerPicked;
    private Card cardAskedFor;

    public AskForCardLogic(TurnOfGoFish aTurnOfGoFish) {
        this.currentPlayer = aTurnOfGoFish.getCurrentPlayer();
        this.playerPicked = aTurnOfGoFish.getPlayerPicked();
    }

    public Card pickCardFromOwnHand(Integer cardIndex) {
        Card aCard = null;
        try {
            cardAskedFor = currentPlayer.getHand().get(cardIndex);
            aCard = currentPlayer.getHand().get(cardIndex);
            System.out.println(currentPlayer.getName()+" picked: " + cardAskedFor.toString());

        } catch (IndexOutOfBoundsException | NullPointerException e) {
            cardIndex = Console.getIntegerInput("Please pick a card you'd like to ask for.");
            pickCardFromOwnHand(cardIndex);
            //e.printStackTrace();
        }
        return aCard;
    }


    public boolean isCardFound() {
        ArrayList<Card> handOfPlayerPicked = playerPicked.getHand();
        boolean cardFound = false;
        for (int x = 0; x < handOfPlayerPicked.size(); x++) {
            if (handOfPlayerPicked.get(x).equals(cardAskedFor)) {
                Card theCardFound = handOfPlayerPicked.get(x);
                currentPlayer.addToHand(theCardFound);
                handOfPlayerPicked.remove(theCardFound);
                Console.print("\nYay! " + this.playerPicked.getName() + " had a " + theCardFound.toString() + "!");
                Console.print("You get to go again!");
                //drawWhenHandEmpty(this.playerPicked, deck);
                x--;
                cardFound = true;
            }
        }
        return cardFound;
    }
}
