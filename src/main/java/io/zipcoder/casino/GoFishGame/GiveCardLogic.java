package io.zipcoder.casino.GoFishGame;

import io.zipcoder.casino.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GiveCardLogic {
    private Player currentPlayer;
    private Deck deck;
    private Card cardAskedFor;
    private Integer numOfCompletedSuits;


    public GiveCardLogic(Player currentPlayer, Deck aDeck, Integer numOfCompletedSuits, Card cardAskedFor) {
        this.currentPlayer = currentPlayer;
        this.deck = aDeck;
        this.numOfCompletedSuits = numOfCompletedSuits;
        this.cardAskedFor = cardAskedFor;
    }

    public void cardFoundInHand(boolean isCardInHand) {
        if (isCardInHand) {
            checkForPairOf4(currentPlayer);
        }
    }


    public void drawWhenCardNotFound(boolean isCardInHand) {
        if (!isCardInHand) {
            if (deck.getAllCards().size() > 0) {
                Console.print("\nGo Fish, you got it wrong.\n");
                Card cardDrawnFromDeck = deck.getCard();
                Console.print("You just drew a " + cardDrawnFromDeck+"\n");
                GoFishConsole.printSizeOfDrawPile(deck);
                currentPlayer.addToHand(cardDrawnFromDeck);
                cardAskedFor = cardDrawnFromDeck;
            }
        }
    }


    public Boolean drewCardAskedFor(Card cardPicked) {
        if (cardPicked.equals(cardAskedFor)) {
            Console.print("Yay! You drew the card you asked for, go again.");
            checkForPairOf4(currentPlayer);
            return true;
        }
        else {
            return false;
        }
    }

    public void checkForPairOf4(Player aPlayer) {
        Map<String, Integer> myMap = new HashMap<>();


        for (Card aCard : aPlayer.getHand()) {
            if (myMap.containsKey(aCard.toString().substring(0, 2))) {
                Integer count = myMap.get(aCard.toString().substring(0,2));
                count++;
                myMap.put(aCard.toString().substring(0,2), count);
            }
            else {
                myMap.put(aCard.toString().substring(0, 2), 1);
            }
        }

        myMap.forEach((faceValue,cardCount) -> {
            if (cardCount.equals(4)) {
                aPlayer.setHand(aPlayer.getHand().stream().filter(card -> !card.toString().substring(0,2)
                        .equals(faceValue)).collect(Collectors.toCollection(ArrayList::new)));

                numOfCompletedSuits++;
                currentPlayer.addPointToScore();
                Console.print("\nYay! You just got a completed set of four " + faceValue + "'s. " +
                        currentPlayer.getName() + "'s current score is " + currentPlayer.getScore()+".");
                //drawWhenHandEmpty(playerPicked);
            }
        });
    }

    private void drawWhenHandEmpty(Player aPlayer, Deck deck) {
        if (aPlayer.getHand().size() == 0) {
            Console.print(aPlayer.getName() + "'s hand is empty. Draw 5 cards or the rest of the cards left in the draw pile.\n");
            Card aCard;
            for (int x = 0; x <= 5; x++) {
                if (deck.getAllCards().size() > 0) {
                    aCard = deck.getCard();
                    aPlayer.addToHand(aCard);
                }
            }
            GoFishConsole.printSizeOfDrawPile(deck);
        }
    }

}
