package io.zipcoder.casino.games.craps;

import io.zipcoder.casino.games.Gamble;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.nuts_n_bolts.Dice;
import io.zipcoder.casino.nuts_n_bolts.MoneyContainer;
import io.zipcoder.casino.nuts_n_bolts.User;

import java.util.ArrayList;

public class Craps implements Game, Gamble {

    //2 players
    //roll to decide first, highest wins
    //both make a bet -> pot
    //decide if bet is pass or don't pass
    //player throwing dice = shooter
    //roll 2 dice 7/11 on first roll -> win
    // 2/3/12 on first roll -> lose
    //come/don't come bets

    private Dice<Integer> dice;
    private CrapPointPair pair;
    private boolean isPointSet = false;
    private boolean playerWonBet = false;
    private boolean sidePairRolled = false;
    private boolean playerWonSide = false;
    private boolean isPlayerTurn = false;
    private int point=0;
    private MoneyContainer mainPot;

    public Craps(){
        ArrayList<Integer> twoToTwelve = new ArrayList<>();
        for (int i=2; i<13; i++)
        {
            twoToTwelve.add(i);
        }
        dice=new Dice<>(twoToTwelve);
    }

    public boolean play(String userInput) {
        return ("Y".equalsIgnoreCase(userInput));
    }

/*
        roll to determine who goes first (high/low)
            Player makes a pass or dontPass bet into the mainPot
            initialThrow (comeOutRoll) to win or point.
                resolve if pass, dontPass, or point (7,11 is pass) (2,3,12 is dontPass).
                    //Player wins/loses their opponent's stake in the pot
                    //Opponent needs to bet again before next roll
                    //Same, inverse
            if point, can make side bets on the point (6/8, 5/9, 10/4)
                If roller gets his point, he wins mainPot and sidePot.
                If roller rolls side number, he only wins sidePot.
                    Another sideBet can be made after the first sideBet is won

                If roller craps (7) out, nonRoller wins mainPot and sidePot
            Next player gets the dice

 */

    public String initialRoll(double mainStake){
        String returnMe="";
        int rollResult = dice.rollDie();

        if (isPlayerTurn) {
            returnMe += "You rolled a " + rollResult;
        }
        else{
            returnMe += "Your opponent rolled a "+rollResult;
        }

        if (rollResult==7 || rollResult==11){
            if (isPlayerTurn) {
                returnMe+=" and you won "+mainStake;
                playerWonBet=true;
            }
            else {
                returnMe+=" and you lost "+mainStake;
                playerWonBet=false;
            }
        }
        else if (rollResult==2 || rollResult==3 || rollResult==12){
            if (isPlayerTurn) {
                returnMe+=" and you lost "+mainStake;
                playerWonBet=false;
            }
            else {
                returnMe+=" and you won "+mainStake;
                playerWonBet=true;
            }
        }
        else{
            point=rollResult;
            assignPair();
            isPointSet=true;
            returnMe+=" which makes "+point+" the new point.";
        }
        returnMe+="  There is "+mainPot.getMoney()+" in the pot.";
        return returnMe;
    }

    public String subsequentRolls(double sideStake){
        String returnMe="";
        int rollResult = dice.rollDie();

        if ((rollResult == point) && (isPlayerTurn)){
            returnMe+="You rolled "+rollResult+" and got the point! You won everything!";
            playerWonBet=true;
            playerWonSide=true;
            sidePairRolled=true;
        } else
            if ((rollResult == point) && (!isPlayerTurn)){
                returnMe+="Opponent rolled "+rollResult+" and got the point. You lost everything!";
                playerWonBet=false;
                playerWonSide=false;
                sidePairRolled=true;
            } else
                if ((rollResult==7) && (isPlayerTurn)){
                    returnMe+="You crapped out. You lost everything!";
                    playerWonBet=false;
                    playerWonSide=false;
                    sidePairRolled=true;
                } else
                    if ((rollResult==7) && (!isPlayerTurn)){
                        returnMe+="Your opponent crapped out! You won everything!";
                        playerWonBet=true;
                        playerWonSide=true;
                        sidePairRolled=true;
                    } else{
                        if (pair.isInPair(rollResult)){
                            sidePairRolled=true;
                            if (isPlayerTurn){
                                returnMe+="You rolled "+rollResult+" and won the side bet of "+sideStake+". ";
                                playerWonSide=true;
                            }
                            else {
                                returnMe+="Your opponent rolled "+rollResult+" and won the side bet of "+sideStake+". ";
                                playerWonSide=false;
                            }
                        } else{
                            returnMe+=""+rollResult+" was rolled. Rolling again. ";
                        }
                    }
        return returnMe;
    }

    public String pairText(){
        return(pair.text);
    }

    private CrapPointPair assignPair() {

        for(CrapPointPair p : CrapPointPair.values()) {
            if (p.a==point || p.b==point) {
                return p;
            }
        }
        return null;
    }

    public void rollHighLow(){
        int playerRoll;
        int botRoll;

        do {
            playerRoll = dice.rollDie();
            botRoll = dice.rollDie();
        }while (playerRoll==botRoll);

        isPlayerTurn=(playerRoll>botRoll);

    }

    public int getPoint(){
        return point;
    }

    public boolean getIsPlayerTurn(){
        return isPlayerTurn;
    }

    public boolean getIsPointSet(){
        return isPointSet;
    }

    public boolean getPlayerWonSide() {
        return playerWonSide;
    }

    public boolean getSidePairRolled() {
        return sidePairRolled;
    }

    public void takeBet(Double bet) {
        mainPot.addMoney(bet);
    }

    public boolean getPlayerWonBet(){
        return playerWonBet;
    }

    public Double settleBet() {
        return mainPot.takeOutMoney(mainPot.getMoney()/2);
    }

    public Double cashOutPot(){
        return mainPot.takeAllMoney();
    }

    private enum CrapPointPair {
        sixEight(6, 8, "6-8"),
        fiveNine(5, 9, "5-9"),
        tenFour(10, 4, "10-4");

        int a;
        int b;
        String text;

        CrapPointPair(int a, int b, String text) {
            this.a = a;
            this.b = b;
            this.text=text;
        }

        boolean isInPair(int a) {
            return (this.a==a || this.b==a);
        }

    }

}
