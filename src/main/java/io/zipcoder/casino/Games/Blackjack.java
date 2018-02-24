package io.zipcoder.casino.Games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Games.Dealer.Dealer;
import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;

import java.util.ArrayList;

public class Blackjack implements Game{

    protected BlackjackPlayer player;
    protected Deck deck;
    protected Dealer bkjkDealer;
    public boolean isPlaying = true;
    protected int betAmount = 0;

    public void startGame(){
        do {
            pregameReset();
            deck = new Deck();
            deck.shuffleDeck();
            initialHand();
            runTurn();
            settleAccount();
            playAgainCheck();
        }
        while (isPlaying);
        endGame();
    }

    public void pregameReset() {
        player.setHand(new ArrayList<>());
        bkjkDealer.setHand(new ArrayList<>());
        player.setCanHit(true);
        setBetAmount(0);
    }

    public void endGame(){
        System.out.println("Ok bye.");
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
        boolean hitchoice = playerHitOption();
        while (player.isCanHit() && hitchoice && player.getHandValue() < 22){
            deal();
            hitchoice = playerHitOption();
        }
        System.out.println("Your final hand value is " + player.getHandValue());
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
        System.out.println("Dealer's final hand value is " + this.bkjkDealer.getHandValue());
    }

    public boolean winCheck(BlackjackPlayer player){
        if (player.getHandValue() == 21 ||
                (player.getHandValue() < 21 && bkjkDealer.getHandValue() < player.getHandValue())){
            return true;
        }
        return false;
    }

    public Boolean playerHitOption(){
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
            System.out.println("You're holding: " + currentHand + "\nWill you hit?\n1 for YES, 2 for NO");
            String userChoice;
            InputOutput inputOutput = new InputOutput();
            userChoice = inputOutput.scanForString();
            if (userChoice.equals("1")) return true;
            else {
                player.setCanHit(false);
                return false;
            }
        }
        return null;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public void playAgainCheck(){
        InputOutput inputOutput = new InputOutput();
        int feedback = inputOutput.promptForInt("How 'bout another hand?\n1 for YES, 2 for NO");
        if (feedback == 2){
            setPlaying(false);
        }
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void settleAccount(){
        if ((player.getHandValue() > bkjkDealer.getHandValue() && player.getHandValue() < 22)) {
            payoutWin();
        } else if (player.getHandValue() > 21){
            payoutLoss();
        } else {
            payoutLoss();
        }
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public void payoutWin(){
        int bet = getBetAmount();
        player.payoutWin(bet);
        System.out.println("You won " + bet + ". Nice work!");
    }

    public void payoutLoss(){
        int bet = getBetAmount();
        player.payoutLoss(bet);
        System.out.println("Rough luck! You're down " + bet + " chips.");
    }
}
