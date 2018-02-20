package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Interfaces.Gamble;

public class Blackjack extends CardGame implements Gamble{
    BlackjackPlayer player;
    BlackjackDealer dealer;
    private double pot = 0;

    public BlackjackPlayer getPlayer() {
        return player;
    }
    public BlackjackDealer getDealer() {
        return dealer;
    }

    public Blackjack(Player player){
        this.player = new BlackjackPlayer(player);
        Player dealer = new Player("Dealer",0,0);
        this.dealer = new BlackjackDealer(dealer);
    }

    public void start(){
        Console.print("Welcome to BlackJack");
        play();
    }

    public void play(){
        pot = takeBet();
        System.out.println(pot);
        deal(player,dealer,2);
        askForHitOrStay();
        dealerPlay();
        checkWin();
        if(playAgain()){
            play();
        }else{
            gameOptions();
        }
    }

    public boolean playAgain(){
        String input = Console.getValidString("Would you like to play again?","yes","no");
        return "yes".equalsIgnoreCase(input);
    }

    public void checkWin(){
        if(playerWins()){
            Console.print("Player wins\n");
            casinoplayer.addToBalance(pot);
        }else{
            Console.print("Dealer wins\n");
        }
        Console.print("Dealer had\n"+dealer.getStringDisplayHand());
        Console.print("Score of "+dealer.getScore());
    }

    public void askForHitOrStay(){
        Console.print("Dealer is showing\n"+dealer.getHand().get(0).toString());
        String hitOrStay;
        do{
            printHand(player);
            Console.print("Score of "+player.getScore() + "\n");
            if(player.getScore()>=21){
                return;
            }
            hitOrStay = Console.getValidString("Would you like to hit or stay?","hit","stay");
            if("hit".equalsIgnoreCase(hitOrStay)){
                player.addCard(deck.getCard());
            }else {
                return;
            }
        }while(true);
    }

    public void dealerPlay(){
        while(dealer.hitDealer()){
            dealer.addCard(deck.getCard());
        }
    }

    public double takeBet(){
        Console.print("You current balance is "+format.format(casinoplayer.getBalance()));
        double bet;
        while(true){
            bet = Console.getDouble("How much would you like bet?");
            if(casinoplayer.getBalance() >= bet){
                casinoplayer.addToBalance(-1*bet);
                return bet;
            }
            Console.print("Invalid bet");
        }
    }

    public boolean playerWins(){
        if((player.getScore() == 21 && dealer.getScore() != 21) ||
                (player.getScore() < 21 && dealer.getScore() < player.getScore()) ||
                (player.getScore() < 21 && dealer.getScore() > 21)) {
            return true;
        }
        return false;
    }
}
