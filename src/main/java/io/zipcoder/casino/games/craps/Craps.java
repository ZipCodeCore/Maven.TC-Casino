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

    private User player;
    private Dice<Integer> dice;
    private boolean isPointSet = false;
    private boolean isPlayerTurn = false;
    private int point=0;
    private MoneyContainer mainPot;

    public Craps(User user){
        ArrayList<Integer> twoToTwelve = new ArrayList<>();
        for (int i=2; i<13; i++)
        {
            twoToTwelve.add(i);
        }
        dice=new Dice<>(twoToTwelve);
        player = user;
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
    public String initialRoll(){
        String returnMe="";
        int rollResult = dice.rollDie();
        double initialStake=mainPot.getMoney() / 2.0;

        if (isPlayerTurn) {
            returnMe += "You rolled a " + rollResult;
        }
        else{
            returnMe += "Your opponent rolled a "+rollResult;
        }

        if (rollResult==7 || rollResult==11){
            if (isPlayerTurn) {
                returnMe+=" and won "+initialStake;
                player.getWallet().addMoney(mainPot.takeOutMoney(initialStake));
            }
            else {
                returnMe+=" and lost "+initialStake;
                mainPot.takeOutMoney(initialStake);
            }
        }
        else if (rollResult==2 || rollResult==3 || rollResult==12){
            if (isPlayerTurn) {
                returnMe+=" and lost "+initialStake;
                mainPot.takeOutMoney(initialStake);
            }
            else {
                returnMe+=" and won "+initialStake;
                player.getWallet().addMoney(mainPot.takeOutMoney(initialStake));
            }
        }
        else{
            point=rollResult;
            isPointSet=true;
            returnMe+=" which makes "+point+" the new point.";
        }
        returnMe+="  There is "+mainPot.getMoney()+" in the pot.";
        return returnMe;
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

    public void takeBet(Double bet) {
        mainPot.addMoney(bet*2);
    }

    public Double settleBet() {
        return mainPot.takeAllMoney();
    }

}
