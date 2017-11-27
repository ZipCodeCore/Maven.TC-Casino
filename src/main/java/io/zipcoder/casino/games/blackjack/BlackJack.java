package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Gamble;
import io.zipcoder.casino.nuts_n_bolts.MoneyContainer;


import io.zipcoder.casino.nuts_n_bolts.cards.Hand;

import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {

    private MoneyContainer pot;

    private PlayingDeck deck;
    private int playerScore;
    private int dealerScore;
    private Hand player;
    private Hand dealer;

    public BlackJack() {

        pot = new MoneyContainer();
        deck = new PlayingDeck();
        deck.shuffle();
        playerScore = 0;
        dealerScore = 0;
        player = new Hand();
        dealer = new Hand();

        for (int i = 0; i < 2; i++) {
            player.addCard(deck.getAndRemoveCard());
            dealer.addCard(deck.getAndRemoveCard());
        }
    }

    public void takeBet(Double bet) {
        pot.addMoney(bet);
    }


    public Double settleBet(Double winnings) {
        return (pot.takeOutMoney(winnings));
    }

    public Double emptyPot() {
        return pot.takeAllMoney();
    }

    public Double showPot() {
        return pot.getMoney();
    }


    public Integer getPlayerScore() {
        playerScore = 0;
        ArrayList<PlayingCard> handArray = player.getAllCards();


        for (PlayingCard c : handArray) {
            playerScore += cardScore(c, playerScore);
        }

        return playerScore;
    }


    private Integer getDealerScore() {
        dealerScore = 0;
        ArrayList<PlayingCard> handArray = dealer.getAllCards();

        for (PlayingCard c : handArray) {
            dealerScore += cardScore(c, dealerScore);
        }

        return dealerScore;
    }

    public Integer getDealerScoreShowing(){
        return (cardScore(dealer.getAllCards().get(0), 0));
    }

    private Integer cardScore(PlayingCard c, int score) {

        switch (c.getValue().toString()) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
            case "J":
            case "Q":
            case "K":
                return 10;
            default: {
                if (score + 11 > 21) {
                    return 1;
                }
            }
        }
        return 11;
    }

    public void playerHit() {
        player.addCard(deck.getAndRemoveCard());
        playerScore = getPlayerScore();
    }

    public void dealerHit() {
        dealer.addCard(deck.getAndRemoveCard());
        dealerScore = getDealerScore();
    }

    public void dealerHitUntilFinished(){
        while (getDealerScore()<=17 && getPlayerScore()<=21){
            dealer.addCard(deck.getAndRemoveCard());
        }
    }

    public boolean playerWins(){
        return (((getPlayerScore()>getDealerScore())&&(getPlayerScore()<=21)) ||
                (getDealerScore()>21 && getPlayerScore()<=21));
    }

    public String finalTableDisplay(){
        String returnMe="";

        returnMe+="---\nOpponent\n---\n"+getDealerScore()+" Showing\n---\n";
        for (PlayingCard c : dealer.getAllCards()){
            returnMe+=c.toString()+"\n";
        }


        returnMe+="\nPot: "+pot.getMoney()+"\n\n";

        returnMe+="---\nYou\n---\n"+getPlayerScore()+"\n---\n";
        for (PlayingCard c : player.getAllCards()){
            returnMe+=c.toString()+"\n";
        }

        returnMe+="\n\n";

        return returnMe;
    }

    @Override
    public String toString(){
        String returnMe="";

        returnMe+="---\nOpponent\n---\n"+getDealerScoreShowing()+" Showing\n---\n";
        returnMe+=dealer.getAllCards().get(0).toString()+"\n";
        returnMe+="[]\n";


        returnMe+="\nPot: "+pot.getMoney()+"\n\n";

        returnMe+="---\nYou\n---\n"+getPlayerScore()+"\n---\n";
        for (PlayingCard c : player.getAllCards()){
            returnMe+=c.toString()+"\n";
        }

        returnMe+="\n\n";

        return returnMe;
    }

    public boolean play(String userInput) {
        return ("Y".equalsIgnoreCase(userInput));
    }

}