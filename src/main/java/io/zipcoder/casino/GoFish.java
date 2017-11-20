package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;
import java.util.Random;

public class GoFish extends CardGame {

    GoFishPlayer player;
    GoFishPlayer dealer;


    public GoFish(Player player) {
        this.player = new GoFishPlayer(player);
        Player dealer = new Player("Dealer", 0, 0);
        this.dealer = new GoFishPlayer(dealer);
    }

    public void goFishStart() {
        deal(player, dealer, 7);
        boolean playing = true;
        while (playing) {
            playerTurn();
            dealerTurn();
            playing = checkForWin();
        }

    }

    private boolean checkForWin() {
        if (deck.getAllCards().size() == 0) {
            compareBooks();
            return false;
        }
        return true;
    }

    private void playerTurn() {
        boolean playing = true;
        while (playing) {
            checkForBooks(player);
            Console.print(player.getStringDisplayHand());
            String askCard = Console.getString("Enter card you are looking for: ");
            if (isCardInHand(askCard, dealer.getHand())) {
                swapCard(dealer, player, askCard);
            } else {
                Console.print("GO FISH!");
                giveCard(player);
                playing = false;
            }
        }
    }


    private void dealerTurn() {
        boolean playing = true;
        while (playing) {
            checkForBooks(dealer);
            Console.print("Opponent looking for card...");
            Card dealerCard = dealerFindCard();
            Console.print("Do you have any: " + dealerCard.getGoFishValue() + " ?");
            if (isCardInHand(dealerCard.getGoFishValue(), player.getHand())) {
                swapCard(player, dealer, dealerCard.getGoFishValue());
            } else {
                Console.print("Guess I'll go fish...");
                giveCard(dealer);
                playing = false;
            }


        }
    }

    private Card dealerFindCard() {
        Random r = new Random();
        int x = r.nextInt(dealer.getHand().size());
        return dealer.getHand().get(x);
    }

    private boolean isCardInHand(String askCard, ArrayList<Card> hand) {
        for (Card card : hand) {
            if (askCard.equals(card.getGoFishValue())) {
                return true;
            }
        }
        return false;
    }

    private void swapCard(CardPlayer player1, CardPlayer player2, String cardValue) {
        for (Card card : player1.getHand()) {
            if (cardValue.equals(card.getGoFishValue())) {
                player2.addCard(player1.removeCard(card));
            }
        }
    }

    private Card checkForBooks(GoFishPlayer player) {

        for (Card card1 : player.getHand()) {
            int num = 0;
            for (Card card2 : player.getHand())
                if (card1 == card2)
                    num++;
            if (num == 4) {
                for (int i = 0; i < 4; i++)
                    player.getHand().remove(card1);
                player.setBookCounter(1);
                return card1;
            }
        }
        return null;

    }

    private void compareBooks() {
        if (player.getBookCounter() > dealer.getBookCounter()) {
            System.out.println("You win!");
        } else if (player.getBookCounter() < dealer.getBookCounter()) {
            System.out.println("You lose!");
        } else {
            System.out.println("Tie!");
        }
    }


}
