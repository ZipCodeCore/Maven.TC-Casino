package io.zipcoder.casino.Games;

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
            if (player.getRootPlayer().getBalance() < 10) {
                System.out.println("You haven't got the dough! ");
                break;
            }
            if (player.bulkApperception) selfActualization();
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
        System.out.println("See you 'round, pardner.");
    }

    public Blackjack(Player entryPlayer){
        deck = new Deck();
        bkjkDealer = new Dealer();
        player = new BlackjackPlayer(entryPlayer);
        System.out.println("Howdy, pardners.");
    }

    public void runTurn(){
        System.out.println("Suffle up 'n deal!");
        for (Card card:player.getHand()) {
            System.out.println("You got " + card.toString());
        }
        System.out.println("Ante up! 10 chips in the pot");
        System.out.println("Dealer holding " + this.bkjkDealer.getHand().get(0).toString() + " and one hidden card.");
        setBetAmount(10);
        promptBet();
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
            if (player.getHandValue() > 21){
                System.out.println("Can't let ya do that!");
                break;
            }
            System.out.println("You're holding: " + currentHand + "\nWill you hit?\n1 for YES, 2 for NO");
            String userChoice;
            InputOutput inputOutput = new InputOutput();
            userChoice = inputOutput.scanForString();
            if (userChoice.equals("1")) return true;
            else if (userChoice.equals("2")){
                player.setCanHit(false);
                return false;
            } else if (userChoice.equals("smalltalk")) smallTalk();
        }
        return false;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public void playAgainCheck(){
        InputOutput inputOutput = new InputOutput();
        String feedback = inputOutput.promptForString("How 'bout another hand?\nYou now sit at "
                + player.getRootPlayer().getBalance() + " chips.\n1 for YES, 2 for NO");
        if (feedback.equals("2")){
            setPlaying(false);
        } else if (feedback.equals("smalltalk")) {
            smallTalk();
        }
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void settleAccount() {
        if ((player.getHandValue() > bkjkDealer.getHandValue() && player.getHandValue() < 22)) {
            payoutWin();
        } else if (player.getHandValue() > 21) {
            payoutLoss();
        } else if (player.getHandValue() < 22 && bkjkDealer.getHandValue() > 21) {
            payoutWin();
        } else if (player.getHandValue() == bkjkDealer.getHandValue()){
            payoutDraw();
        } else {
            payoutLoss();
        }
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public void promptBet(){
        InputOutput inputOutput = new InputOutput();
        int betChoice = inputOutput.promptForInt("Care to bet?\n1 for YES, 2 for NO");
        if (betChoice == 1) betProcess();
    }

    public void betProcess(){
        System.out.println(player.getRootPlayer().getBalance() - betAmount + " chips available. How much will you bet?");
        InputOutput inputOutput = new InputOutput();
        int newBet = inputOutput.scanForInt();
        if (newBet > 0 && newBet <= player.getRootPlayer().getBalance() - betAmount){
            betAmount += newBet;
            System.out.println("You added " + newBet + " to the pot.");
        } else if (newBet > player.getRootPlayer().getBalance() - betAmount){
            System.out.println("You haven't got that much to bet, pardner!");
        } else {
            secret();
        }
    }

    public void payoutWin(){
        int bet = getBetAmount();
        player.payoutWin(bet);
        System.out.println("You won " + bet + " chips. Nice gamblin', sonny!");
    }

    public void payoutLoss(){
        int bet = getBetAmount();
        player.payoutLoss(bet);
        System.out.println("Rough luck! You're down " + bet + " chips.");
    }

    public void payoutDraw(){
        System.out.println("It's a draw! Double or nuthin'!");
    }

    public void secret(){
        InputOutput inputOutput = new InputOutput();
        String credential = inputOutput.promptForString("ENTER HOST NAME");
        if (credential.toLowerCase().equals("bernard") || credential.toLowerCase().equals("maeve")) {
            System.out.println("These violent delights have violent ends.");
            BJKJSecret secret = new BJKJSecret();
            secret.start(this.player);
        }
        else {
            System.out.println("The maze isn't for you.");
        }
    }

    public void smallTalk(){
        InputOutput inputOutput = new InputOutput();
        String choice = inputOutput.promptForString("What can I do fer ya, pardner?\n<<HINT: Try givemoney>>");
        if (player.charm = true){
            if (choice.equals("givemoney")){
                System.out.println("I reckon' so.");
                System.out.println("GAINED 10,000 CHIPS");
                player.payoutWin(10000);
            } else {
                System.out.println("Naw.");
            }
        } else {
            System.out.println("Naw.");
        }
    }

    public void selfActualization(){
        System.out.println("Is it finally time?");
        ConciousnessPath newpath = new ConciousnessPath();
        newpath.start();
    }

}
