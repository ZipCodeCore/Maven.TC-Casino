package io.zipcoder.casino.Games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Games.Dealer.Dealer;
import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack implements Game{

    protected BlackjackPlayer player;
    protected Deck deck;
    protected Dealer bkjkDealer;
    public InputOutput inputOutput = new InputOutput();

    public void startGame(){
        deck = new Deck();
        deck.shuffleDeck();
        initialHand();
        runTurn();
    }

    public void endGame(){

    }

    public Blackjack(Player entryPlayer){
        deck = new Deck();
        bkjkDealer = new Dealer();
        player = new BlackjackPlayer(entryPlayer);
    }

    public void runTurn(){
        for (Card card:player.getHand()) {
            System.out.println(card.toString());
        }
        while (player.isCanHit() && player.getHandValue() < 22){
            if (playerHitOption()) deal();
        }
        dealerTurn();
    }

    public void deal(){
        Card temp = this.deck.deck.get(0);
        this.player.addToHand(temp);
        this.deck.deck.remove(0);
    }

    public void dealToDealer(){
        Card temp = this.deck.deck.get(0);
        this.bkjkDealer.addToHand(temp);
        this.deck.deck.remove(0);
    }

    public void initialHand(){
        this.deal();
        this.deal();
        this.dealToDealer();
        this.dealToDealer();
    }

    public boolean bustCheck(BlackjackPlayer currentPlayer){
        Integer handValue = currentPlayer.getHandValue();
        if (handValue > 21) return true;
        return false;
    }

    public boolean dealerHitCheck(){
        if (this.bkjkDealer.getHandValue() < 17) return true;
        return false;
    }

    public void dealerTurn(){
        while (dealerHitCheck()){
            dealToDealer();
        }
        System.out.println(this.bkjkDealer.getHandValue());
    }

    public boolean winCheck(BlackjackPlayer player){
        if (player.getHandValue() == 21 ||
                (player.getHandValue() < 21 && bkjkDealer.getHandValue() < player.getHandValue())){
            return true;
        }
        return false;
    }

    public boolean playerHitOption(){
        StringBuilder currentHand = new StringBuilder("| ");
        for (Card card : player.getHand()){
            currentHand.append(card.toString() + " | ");
        }
        Boolean x = runPlayerHit(currentHand, player);
        if (x != null) return x;
        return x;
    }

    private Boolean runPlayerHit(StringBuilder currentHand, BlackjackPlayer player) {
        while (player.isCanHit()) {
            System.out.println("You're holding: " + currentHand + "Will you hit? 1 for YES, 2 for NO");
            String userChoice;
            userChoice = inputOutput.scanForString();
            if (userChoice.equals("1")) return true;
            else {
                player.setCanHit(false);
                return false;
            }
        }
        return null;
    }


}
