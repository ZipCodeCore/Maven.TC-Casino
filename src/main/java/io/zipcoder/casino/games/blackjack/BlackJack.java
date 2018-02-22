package io.zipcoder.casino.games.blackjack;


import io.zipcoder.casino.games.Deck;

public class BlackJack {

    private Deck deck;
    private int playerBet;
    private int playerWallet;
    private int playerValue;
    private int dealerValue;
    private Deck playerHand;
    private Deck dealerHand;
    private int insuranceBet;

    public BlackJack(){
        deck = new Deck();
        playerValue = 0;
        dealerValue = 0;
        playerHand = new Deck();
        dealerHand = new Deck();

        for (int i = 0; i < 2; i++){
            playerHand.pull(1);
            dealerHand.pull(1);
        }
    }

    public Integer cardValue(){
        return deck.pull(1)[0].getValue();
    }

    public void splitCards(){

    }
    public void putInsurance(){

    }
    public void playerHit(){

    }
    public void playerStand(){

    }
//    public Integer tallyPlayerScore(){
//        playerValue = 0;
//
//    }

    public void tallyDealerScore(){

    }
    public void playerDoubleDown(){

    }
    public void getTotal(){

    }
    public void checkHand(){

    }
    public void isBlackJack(){

    }
    public void whoWon(){

    }
    public void bust(){

    }
    public void tie(){

    }
    public void wagerMultiplier(){

    }
}
