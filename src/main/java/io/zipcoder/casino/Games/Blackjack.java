package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Games.Dealer.Dealer;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;

import java.util.ArrayList;

public class Blackjack implements Game{

    protected ArrayList<BlackjackPlayer> playerList;
    protected Deck deck;
    protected Dealer bkjkDealer;

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
        System.out.println(this.deck.deck.size());
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
        
    }

}
