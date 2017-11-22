package io.zipcoder.casino.casino;

import io.zipcoder.casino.games.gofish.GoFish;
import io.zipcoder.casino.nuts_n_bolts.Input;
import io.zipcoder.casino.nuts_n_bolts.User;

public class Casino {

    private static Casino INSTANCE = null;
    private User user;

    private Casino(){}

    public static Casino getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Casino();
        }
        return INSTANCE;
    }

    public void startCasino(){
        casinoWelcome();
        this.user = createUser(Input.getStringInput("What's yo name, good lookin'?"),
                Input.getPositiveDoubleInput("How much you puttin' up?"));
        do {
            CasinoMenu.INSTANCE.display();
        } while(true);
    }

    private void casinoWelcome() {
        System.out.println("Welcome to Uncle Bob's Backyard Casinooooooooo!");
    }

    void exitCasino(){
        if(user.getWallet().getMoney() < 10d){
            System.out.println("You's broke, see ya next paycheck!");
        } else {
            System.out.println("Hope to see ya again soon!");
        }
        System.exit(0);
    }

    User createUser(String name, Double money) {
        return new User(name, money);
    }

}
