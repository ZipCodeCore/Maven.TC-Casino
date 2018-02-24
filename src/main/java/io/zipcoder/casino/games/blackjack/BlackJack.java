package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;
import java.util.Arrays;


public class BlackJack implements Game {

    private Player player;
    static Deck playingDeck;
    static String output;
    private ArrayList<Card> playerValue;
    private ArrayList<Card> dealerValue;
    private ArrayList<Card> splitHandLeft;
    private ArrayList<Card> splitHandRight;
    private int splitHandScoreLeft;
    private int splitHandScoreRight;
    private int playerHandScore;
    private int dealerHandScore;
    private int insuranceBet;

    public BlackJack() {

    }

    public void welcomeToBlackJack() {
        do {
            String intro = "Welcome to BlackJack!\n" +
                    "Press start to start the game.\n" +
                    "Press q to exit if you hate fun.";

            output = IOHandler.promptForStringWithMessage(intro);
            if (output.equalsIgnoreCase("start")) {
                beginGame();
            }
        }
        while (!output.equalsIgnoreCase("q"));
    }

    public void beginGame() {

        Deck playingDeck = new Deck();
        playerValue = new ArrayList<>();
        dealerValue = new ArrayList<>();
        splitHandLeft = new ArrayList<>();
        splitHandRight = new ArrayList<>();

        if(playerValue.size() == 0 && dealerValue.size() == 0){
            playerValue.add(playingDeck.pull(1)[0]);
            dealerValue.add(playingDeck.pull(1)[0]);
        }

        getPlayerCardValue();
        getDealerCardValue();

    }


    public void acePropertiesForPlayer() {
        /**
         * If a Card.Rank.Ace shows up,
         * Ace can be either 1 or 11
         * Dealer must choose 11 if dealerCardValue >= 17
         * Player can choose 11 or 1 no matter what, as long as it does not bust.
         * If a Card[0].Rank.Ace shows up for dealer, the player can place down Insurance bet of .5x bet.
         */
        if (playerValue.get(0).getRank().equals(Rank.ACE) || playerValue.get(1).getRank().equals(Rank.ACE)) {
            String prompt = "What value do you want for your Ace?\n" +
                    " 1 or 11?";
            int output = IOHandler.promptForIntWithMessage(prompt);
            if (output == 1) {
                playerHandScore = 1 + playerValue.get(0).getIntValue();
            }
            if (output == 11) {
                playerHandScore = 11 + playerValue.get(0).getIntValue();
            }
        }
    }

    public void acePropertiesForDealer() {
        if (dealerValue.get(0).getRank().equals(Rank.ACE)) {
            String prompt = "The dealer has an Ace, do you want to put down insurance?\n" +
                    " Yes or No";
            output = IOHandler.promptForStringWithMessage("Yes");
            if (output.equalsIgnoreCase("Yes")) {
                System.out.println("You put down insurance");
            }
            displayDealerHand();

        }
    }

    public Integer getPlayerCardValue() {
        playerHandScore = 0;
       // playerValue.add(playingDeck.pull(1)[0]);
        for (Card pCard : playerValue) {
            playerHandScore += pCard.getIntValue();
        }
        return playerHandScore;
    }

    public Integer getDealerCardValue() {
        dealerHandScore = 0;
      //  dealerValue.add(playingDeck.pull(1)[0]);
        for (Card dCard : dealerValue) {
            dealerHandScore += dCard.getIntValue();
        }
        return dealerHandScore;
    }

    public String displayPlayerHand() {
        String pHandCards = "";
        for (Card card : playerValue) {
            pHandCards += card.toString() + " ";
        }
        return pHandCards;
    }

    public String displayDealerHand() {
        String dHandCards = "";
        for (Card card : dealerValue) {
            dHandCards += card.toString() + " ";
        }
        return dHandCards;
    }

    public boolean isHandSplitable() {
        for (int i = 0; i < playerValue.size() - 1; i++) {
            if (playerValue.get(0).getIntValue() == playerValue.get(1).getIntValue()) {
                return true;
            }
        }
        return false;
    }

    public Integer comparable(Card card1, Card card2) {
        Integer cardVal1 = card1.getIntValue();
        Integer cardVal2 = card2.getIntValue();
        if (cardVal1 > cardVal2) {
            return 1;
        }
        if (cardVal1 < cardVal2) {
            return -1;
        }
        return 0;
    }

    public void splitHandPrompt() {
        if (isHandSplitable() == true) {
            String prompt = "Your split value is " + playerValue.get(0).getIntValue() + ". Do you want to split?";
            output = IOHandler.promptForStringWithMessage(prompt);
            if (output.equalsIgnoreCase("yes")) {
                displaySplitHands();
            }
        }
    }

    public String displaySplitHands() {

        splitHandLeft.addAll(Arrays.asList(playerValue.get(0), playingDeck.pull(1)[0]));
        splitHandRight.addAll(Arrays.asList(playerValue.get(0), playingDeck.pull(1)[0]));

        String leftHand = splitHandLeft.toString();
        String rightHand = splitHandRight.toString();
        String splitHands = leftHand + rightHand;
        return splitHands;
    }

//    public String compareToTheDealer(){
//        while (dealerHandScore < )
//    }

    public String playerHitOrStand() {
        while (playerHandScore < 21) {
            String prompt = "Do you want to hit or stand?";
            output = IOHandler.promptForStringWithMessage(prompt);
            if (output.equalsIgnoreCase("hit")) {
                playerValue.add(playingDeck.pull(1)[0]);
                playerHandScore = getPlayerCardValue();
                System.out.println(playerHandScore);
            }
            if (output.equalsIgnoreCase("stand")) {
                playerHandScore = getPlayerCardValue();
            }
        }
        if (playerHandScore == 21) {
            return "You win!";
        }
        return bust();
    }

    public String bust() {
        return "Over 21, you bust!";
    }

    public String winCondition() {
        if (playerHandScore > dealerHandScore) {
            return "You Win!";
        }
        if (playerHandScore == dealerHandScore) {
            return "You tied";
        }
        if (playerHandScore < dealerHandScore) {
            return "You lost!";
        }
        return playerHitOrStand();
    }

    public void blackJackProperties() {
        /**
         * BlackJack is any combination of Ace and 10, Jack, Queen, King on first deal.
         */
    }

    public void bettingRules() {
        /**
         * Before cards deal, players must make bet.
         * A regular win returns the bet 1x.
         * A lose returns -1x bet.
         * A natural BlackJack gives the bet 1.5x.
         */
    }

    public void play(Player player) {
        welcomeToBlackJack();
    }

    @Override
    public void quitGame() {

    }

    @Override
    public void runWelcome() {

    }

    @Override
    public String getRules() {
        return null;
    }


//    public static void main(String[] args) {
//
//        Deck playingDeck = new Deck();
//        BlackJack blackJack = new BlackJack();
//
//
//        ArrayList<Card> playerValue = new ArrayList<>();
//        ArrayList<Card> dealerValue = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            playerValue.add(playingDeck.pull(1)[0]);
//            dealerValue.add(playingDeck.pull(1)[0]);
//        }
//
//        System.out.println(blackJack.getPlayerCardValue());
//
//
//    }
}
//
//    public void putInsurance(){
//
//    }


//    public void playerDoubleDown(){
//
//    }


//    public void isBlackJack(){
//
//    }
//    public void whoWon(){
//
//    }

//    public void tie(){
//
//    }
//    public void wagerMultiplier(){
//
//    }
