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

    protected ArrayList<BlackjackPlayer> playerList;
    protected Deck deck;
    protected Dealer bkjkDealer;
    public InputOutput inputOutput = new InputOutput();

    public void startGame(){
        deck = new Deck();
        deck.shuffleDeck();
        initialHand();
        for (BlackjackPlayer currentPlayer : playerList){
            runTurn(currentPlayer);
        }
    }

    public void endGame(){

    }

    public Blackjack(Player... players){
        deck = new Deck();
        bkjkDealer = new Dealer();
        playerList = new ArrayList<>();
        for (Player rootPlayer:players) {
            playerList.add(new BlackjackPlayer(rootPlayer));
        }
    }

    public void runTurn(BlackjackPlayer currentPlayer){
        for (Card card:currentPlayer.getHand()) {
            System.out.println(card.toString());
        }

        dealerTurn();
    }

    public void deal(BlackjackPlayer currentPlayer){
        Card temp = this.deck.deck.get(0);
        currentPlayer.addToHand(temp);
        this.deck.deck.remove(0);
    }

    public void dealToDealer(){
        Card temp = this.deck.deck.get(0);
        this.bkjkDealer.addToHand(temp);
        this.deck.deck.remove(0);
    }

    public void initialHand(){
        for (BlackjackPlayer thisPlayer:this.playerList) {
            this.deal(thisPlayer);
            this.deal(thisPlayer);
        }
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
        BlackjackPlayer player = this.playerList.get(0);
        for (Card card : player.getHand()){
            currentHand.append(card.toString() + " | ");
        }
        Boolean x = runPlayerHit(currentHand, player);
        if (x != null) return x;
        return x;
    }

    public Boolean runPlayerHit(StringBuilder currentHand, BlackjackPlayer player) {
        while (player.isCanHit()) {
            System.out.println("You're holding: " + currentHand + "Will you hit? 1 for YES, 2 for NO");
            String userChoice;
            userChoice = inputOutput.scanForString();
            if (userChoice.equals("1")) return true;
            else return false;
        }
        return null;
    }


}
