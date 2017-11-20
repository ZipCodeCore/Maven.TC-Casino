package io.zipcoder.casino.casino;



public class Casino {

    private static Casino INSTANCE = null;
    private Player player;

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
