package io.zipcoder.casino.games.craps;

import io.zipcoder.casino.nuts_n_bolts.MoneyContainer;
import io.zipcoder.casino.nuts_n_bolts.User;

import static io.zipcoder.casino.nuts_n_bolts.Input.getPositiveDoubleInput;

public class CrapsConsoleWIP {

    private CrapsWIP game = new CrapsWIP();
    private User player;
    private boolean isInitialThrow=true;
    private double mainPotBet;


    public CrapsConsoleWIP(){
        player=new User("Uncle Bob", 10_000.0);
    }

    public CrapsConsoleWIP(User user){
        player=user;
    }

    public void run(){
        welcomePlayer();
        game.determineFirstRoller();

    }

    private void initialBet(){

        playerBets();

    }

    private void playerBets() {
        do {
            mainPotBet = getPositiveDoubleInput
                    ("How much would you like to bet? ");
        }while (player.getWallet().getMoney()<mainPotBet);

        game.takeBet(player.getWallet().takeOutMoney(mainPotBet), mc);//player bet
        game.takeBet(mainPotBet);//house bet matches
    }

    private void welcomePlayer(){
        System.out.println("Hello, "+player.getName()+". Welcome to the "+game.getClass().getSimpleName()+" table.");
    }

}
