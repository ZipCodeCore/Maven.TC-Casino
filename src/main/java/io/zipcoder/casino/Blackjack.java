package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;

public class Blackjack extends CardGame{
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
        clearPot();
        getBet();
        deal(player,dealer,2);
        askForHitOrStay();
        dealerPlay();
        checkWin();
        if(playAgain()){
            play();
        }else{
            //gameOptions();
        }
    }

    public boolean playAgain(){
        String input = Console.getValidString("Would you like to play again?","yes","no");
        return "yes".equalsIgnoreCase(input);
    }

    public void checkWin(){
        if(playerWins()){
            Console.print("Player wins\n");
            casinoplayer.addToBalance(pot*2);
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

    public void getBet(){
        Console.print("You current balance is "+casinoplayer.getBalance());
        double bet;
        while(true){
            bet = Console.getDouble("How much would you like bet?");
            if(validBet(bet)){
                addToPot(bet);
                break;
            }
            Console.print("Invalid bet");
        }
        casinoplayer.addToBalance(-1*bet);
        addToPot(bet);
    }

    public boolean validBet(double bet){
        return casinoplayer.getBalance() >= bet;
    }

    public void addToPot(double amount) {
        pot += amount;
    }

    public double getPot() {
        return pot;
    }

    public void clearPot(){
        pot = 0;
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
