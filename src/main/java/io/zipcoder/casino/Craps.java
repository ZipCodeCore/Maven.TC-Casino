package io.zipcoder.casino;

import java.util.ArrayList;

public class Craps extends DiceGames implements Dice {

CrapsPlayer player;
double pot;
   ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();

    public int getDiceRollTotal() {
        return diceRollTotal;
    }

    int diceRollTotal;

    public void createOnePlayer(String name) {
        CrapsPlayer newCrapsPlayer = new CrapsPlayer(name);
        crapsPlayers.add(newCrapsPlayer);
    }

//    public void createOnePlayer(String name){
//        CrapsPlayer newCrapsPlayer = new CrapsPlayer(name);
//    }

    public void crapPlayerMoney(){
        //add chips to player player.addChips()
        CrapsPlayer crapsPlayerBet = new CrapsPlayer() ;
    }

    public void playersFirstRoll(){

        setDiceRollTotal();
        player.setPlayerPoint(getDiceRollTotal());
    }

    //playerBet(Double bet){
    // pot =return double player.bet(bet)
    // }

    public Double addWinnings() {
        Double moMoney = 25.00;
        for (CrapsPlayer player : createOnePlayer()) {
            moMoney = player.getCrapPlayerBet() * 2;
        }

        return moMoney;
    }

    public void loseBet() {
        for (CrapsPlayer player : createOnePlayer()) { //for every player in ouyr craps player arraylist... do stuff
            player.setCrapPlayerBet(0.00);
        }
    }

    public void setDiceRollTotal(){
        diceRollTotal = Dice.rollDice(2);
    }


    public static String gameMessage = " ";
    public static int gameStatus = 0;




    public String firstRoll(CrapsPlayer player) {

        switch (diceRollTotal) {
            case 7:
            case 11:
                gameMessage = "You rolled a: " + diceRollTotal + "! You win!";
                gameStatus = 1;
                addWinnings();
                break;
            case 2:
            case 3:
            case 12:
                gameMessage = "You rolled a: " + diceRollTotal + "! You lose!";
                gameStatus =2;

                loseBet();
                break;
            default:
                player.setPlayerPoint(diceRollTotal);
                gameMessage = "Your point has be set to: " + diceRollTotal + ". Please roll again.";
                gameStatus =3;
                break;
        }
        return gameMessage;

    }

    public String nextRoll(CrapsPlayer player) {

        if (diceRollTotal == player.getPlayerPoint()) {
            gameMessage = "You win!";
            addWinnings();

        } else {
            switch (diceRollTotal) {
                case 7:
                case 11:
                    gameMessage = "You lose!";
                    loseBet();
                    gameStatus =2;
                    break;
                case 2:
                    gameMessage = "You win!";
                    addWinnings();
                    gameStatus =1;
                    break;
                default:
                    gameMessage = "You rolled a: " + diceRollTotal + " you need to roll a " + player.getPlayerPoint() + " Please roll again.";
                    nextRoll(player);
                    gameStatus =3;
                    break;
            }


        }
        return gameMessage;


    }}