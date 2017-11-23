package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.nuts_n_bolts.User;
import java.text.NumberFormat;
import java.util.Random;

public class BlackJackConsole {

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



    private void welcomePlayer(){
        System.out.println("Hello, "+player.getName()+". Welcome to the "+game.getClass().getSimpleName()+" table.");
    }
}
