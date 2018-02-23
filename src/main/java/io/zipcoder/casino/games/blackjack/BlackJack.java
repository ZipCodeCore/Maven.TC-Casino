package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;
import io.zipcoder.casino.utils.IOHandler;
import java.util.Arrays;


public class BlackJack {

        private int playerBet;
        static long playerWallet;
        private int playerValue;
        private int dealerValue;
        private int insuranceBet;
        private Integer splitNum = 0;
        Deck playingDeck;

        public BlackJack(Deck playingDeck) {
        this.playingDeck = playingDeck;
        playerValue = 0;
        dealerValue = 0;
    }
    public Integer dealPlayerHandValue(){
        for (int i = 0; i < 2; i++) {
            playerValue += playingDeck.pull(1)[0].getIntValue();
        }
        return playerValue;
    }
    public Integer dealDealerHandValue(){
        for (int i = 0; i < 2; i++) {
            dealerValue += playingDeck.pull(1)[0].getIntValue();
        }
        return dealerValue;
    }
    public String displayPlayerHand(){
        String handCards = "";
        Deck playerHand = new Deck();
        for(int i = 0; i < 2; i++){
            handCards += Arrays.toString(playerHand.pull(1));
        }
        return handCards;
    }

    public boolean isHandSplitable(){
    Integer card1 = playingDeck.pull(1)[0].getIntValue();
    Integer card2 = playingDeck.pull(1)[0].getIntValue();
            if (card1.equals(card2)){
                splitNum += card1;
                return true;
            } else return false;
    }
    public void splitHand(){
        Integer splitHand = splitNum;
        if (isHandSplitable() == true){
            splitHand += playingDeck.pull(1)[0].getIntValue();
        }
    }

    public static void main(String[] args) {

    }
}
//    public Integer cardValue(){
//
//    }

//    public void splitCards(){
//        //if cardValue == cardValue
//        //new hand
//            //another hit
//            //double bet
//
//    }
//    public void putInsurance(){
//
//    }
//    public void playerHit(){
//
//    }
//    public void playerStand(){
//
//    }

//    public void playerDoubleDown(){
//
//    }
//    public void getTotal(){
//
//    }
//    public void checkHand(){
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
