package io.zipcoder.casino.casino;

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

    public void startCasino(){}

    private void pickGame(Games game){
        //switch case to game of choice
    }

    private void exitCasino(){}

}
