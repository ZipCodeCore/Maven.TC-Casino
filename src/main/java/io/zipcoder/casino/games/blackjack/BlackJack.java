package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;

import java.util.Arrays;


public class BlackJack {
    private Deck deck;
    private int playerBet;
    private int playerWallet;
    private int playerValue;
    private int dealerValue;
    private int insuranceBet;

    public BlackJack() {
    Deck playingDeck = new Deck();

    playerValue = 0;
    dealerValue = 0;

     for (int i = 0; i < 2;i++){
         playerValue += playingDeck.pull(1)[0].getRank().getScoreValue();
         dealerValue += playingDeck.pull(1)[0].getRank().getScoreValue();
     }

    }

    public static void main(String[] args) {

        Deck playingDeck = new Deck();

       int playerValue = 0;
       int dealerValue = 0;

        for (int i = 0; i < 2;i++){
            playerValue += playingDeck.pull(1)[0].getRank().getScoreValue();
            dealerValue += playingDeck.pull(1)[0].getRank().getScoreValue();

        }
        System.out.println(playerValue);
        System.out.println(dealerValue);
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
////    public Integer tallyPlayerScore(){
////        playerValue = 0;
////
////    }
//
//    public void tallyDealerScore(){
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
