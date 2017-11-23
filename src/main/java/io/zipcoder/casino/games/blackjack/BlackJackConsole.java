package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.nuts_n_bolts.User;
import java.text.NumberFormat;
import java.util.Random;

import static io.zipcoder.casino.nuts_n_bolts.Input.getPositiveDoubleInput;
import static io.zipcoder.casino.nuts_n_bolts.Input.getStringInput;

public class BlackJackConsole {

    public static void main(String[] args){
        BlackJackConsole console = new BlackJackConsole();
        console.run();
    }

    private BlackJack game = new BlackJack();
    private User player;
    private double potBet;
    private Random rando=new Random();
    private NumberFormat defaultFormat;

    public BlackJackConsole(){
        this(new User("Uncle Bob", 10_000.0));
    }

    public BlackJackConsole(User user){
        player=user;
        defaultFormat=NumberFormat.getCurrencyInstance();
    }

    public void run(){
        welcomePlayer();
        do {
            game = new BlackJack();
            playerBets();
            System.out.println(game.toString());
            playerHitOrStayCycle();
            game.dealerHitUntilFinished();
            System.out.println(game.toString());
            determineWinOrLoss();
        }while(game.play(getStringInput("Continue playing? [Y/N] ")));

    }

    private void determineWinOrLoss(){
        if (game.playerWins()){
            System.out.println("You win! ");
            System.out.println(game.finalTableDisplay());
            settlePlayerWon();
        }
        else{
            System.out.println("You lose. ");
            System.out.println(game.finalTableDisplay());
            settlePlayerLost();
        }
    }

    private void settlePlayerLost(){
        potBet=game.emptyPot();
        System.out.println("You have "+defaultFormat.format(player.getWallet().getMoney())+" " +
                "in your wallet.");
    }
    private void settlePlayerWon(){
        player.getWallet().addMoney(game.emptyPot());
        System.out.println("You have "+defaultFormat.format(player.getWallet().getMoney())+" " +
                "in your wallet.");
    }

    private void playerHitOrStayCycle(){
        while (game.getPlayerScore()<21 &&
               "Y".equalsIgnoreCase(getStringInput("Hit? [Y/N] "))){
            game.playerHit();
            System.out.println(game.toString());
        }
    }

    private void playerBets(){
        potBet=getPositiveDoubleInput("You have "+defaultFormat.format(player.getWallet().getMoney())+". " +
                " How much do you wish to bet? ");
        game.takeBet(player.getWallet().takeOutMoney(potBet));
        System.out.println("Your opponent matches your bet of "+defaultFormat.format(potBet)+". ");
        game.takeBet(potBet);
    }

    private void welcomePlayer(){
        System.out.println("Hello, "+player.getName()+". Welcome to the "+game.getClass().getSimpleName()+" table.");
    }
}
