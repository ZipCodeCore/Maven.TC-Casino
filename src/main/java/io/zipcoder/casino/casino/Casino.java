package io.zipcoder.casino.casino;

import io.zipcoder.casino.games.blackjack.BlackJack;
import io.zipcoder.casino.games.gofish.GoFish;
import io.zipcoder.casino.nuts_n_bolts.Input;
import io.zipcoder.casino.nuts_n_bolts.User;

public class Casino {

    private static Casino INSTANCE = null;
    private User user;
    CasinoConsole casinoConsole = new CasinoConsole();

    private Casino(){}

    public static Casino getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Casino();
        }
        return INSTANCE;
    }

    public void startCasino(){
        casinoWelcome();
        this.user = casinoConsole.createUser();
        do {
            playGameOrExit(Input.getStringInput("prompt"));
        } while(true);
    }

    private void casinoWelcome() {
        System.out.println("Welcome to Uncle Bob's Backyard Casinooooooooo!");
    }

    private void playGameOrExit(String input){
        switch(CasinoMenuChoices.valueOf(input)){
            case EXIT:

                break;
            case CRAPS:
//                if(enoughMoney()){
//                    Craps craps = new Craps();
//                    craps.play();
//                } else {
//                    System.out.println("This is a big boy game, come back with a fuller wallet!");
//                }
                break;
            case GOFISH:
                GoFish goFish = new GoFish(user);
                goFish.start();
                break;
            case BLACKJACK:
//                if(enoughMoney()){
//                    BlackJack blackJack = new BlackJack();
//                    blackjack.play();
//                } else {
//                    System.out.println("This is a big boy game, come back with a fuller wallet!");
//                }
                break;
        }
    }

    private void exitCasino(){
        if(user.getWallet().getMoney() < 10d){
            System.out.println("You's broke, see ya next paycheck!");
        } else {
            System.out.println("Hope to see ya again soon!");
        }
        System.exit(0);
    }



}
