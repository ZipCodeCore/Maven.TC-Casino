package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;
import java.util.Arrays;


public class BlackJack {

        private int playerBet;
        static long playerWallet;
        private ArrayList<Card> playerValue;
        private ArrayList<Card> dealerValue;
        private ArrayList<Card> splitHandLeft;
        private ArrayList<Card> splitHandRight;
        private int splitHandScoreLeft;
        private int splitHandScoreRight;
        private int playerHandScore;
        private int dealerHandScore;
        private int insuranceBet;

        Deck playingDeck;
        String output;

        public BlackJack(Deck playingDeck) {
        this.playingDeck = playingDeck;
        playerValue = new ArrayList<>();
        dealerValue = new ArrayList<>();
        splitHandLeft = new ArrayList<>();
        splitHandRight = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            playerValue.add(playingDeck.pull(1)[0]);
            dealerValue.add(playingDeck.pull(1)[0]);
        }

    }

    public Integer getPlayerCardValue(){
        playerHandScore = 0;
        for (Card pCard : playerValue){
            playerHandScore += pCard.getIntValue();
        }
        return playerHandScore;
    }
    public Integer getDealerCardValue(){
        dealerHandScore = 0;
        for (Card dCard : dealerValue){
            dealerHandScore += dCard.getIntValue();
        }
        return dealerHandScore;
    }

    public String displayPlayerHand(){
        String pHandCards = "";
        for(Card card: playerValue){
            pHandCards += card.toString() + ",";
        }
        return pHandCards;
    }
    public String displayDealerHand() {
        String dHandCards = "";
        for (Card card : dealerValue) {
            dHandCards+= card.toString() + ",";
        }
        return dHandCards;
    }

    public boolean isHandSplitable(){
        for (int i = 0; i < playerValue.size() -1; i++) {
            if (playerValue.get(0).getIntValue() == playerValue.get(1).getIntValue()){
                return true;
            }
        }
        return false;
    }
    public void splitHandPrompt(){
        if (isHandSplitable() == true){
            String prompt = "Your split value is " + playerValue.get(0).getIntValue() + ". Do you want to split?";
            output = IOHandler.promptForStringWithMessage(prompt);
        if (output.equalsIgnoreCase("yes")){
            displaySplitHands();
        }
        }
    }

    public String displaySplitHands(){
        splitHandLeft.addAll(Arrays.asList(playerValue.get(0), playingDeck.pull(1)[0]));
        splitHandRight.addAll(Arrays.asList(playerValue.get(0), playingDeck.pull(1)[0]));

        String leftHand = splitHandLeft.toString();
        String rightHand = splitHandRight.toString();
        String splitHands = leftHand + rightHand;
        return splitHands.toString();
    }
    public Integer playerHitOrStand(){
        if(playerHandScore < 21){
            String prompt = "Do you want to hit or stand?";
            output = IOHandler.promptForStringWithMessage(prompt);
            if(output.equalsIgnoreCase("hit")) {
                playerValue.add(playingDeck.pull(1)[0]);
                playerHandScore = getPlayerCardValue();
                return playerHandScore;
            }
            if(output.equalsIgnoreCase("stand")){
               playerHandScore = getPlayerCardValue();
            }
        }
        return playerHandScore;
    }

    public static void main(String[] args) {

        String output;
        Deck playingDeck = new Deck();
            BlackJack blackJack = new BlackJack(playingDeck);
            int playerBet;
         long playerWallet;
         ArrayList<Card> playerValue;
         ArrayList<Card> dealerValue;
         int playerHandScore;
         int dealerHandScore;
         int insuranceBet;
         Integer splitNum = 0;

        playerValue = new ArrayList<>();
        dealerValue = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            playerValue.add(playingDeck.pull(1)[0]);
            dealerValue.add(playingDeck.pull(1)[0]);
        }
        System.out.println(blackJack.displayPlayerHand());
        System.out.println(blackJack.playerHitOrStand());

    }
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
//    public void bust(){
//
//    }
//    public void tie(){
//
//    }
//    public void wagerMultiplier(){
//
//    }
