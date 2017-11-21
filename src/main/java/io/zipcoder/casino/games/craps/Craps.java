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

    private ArrayList<CrapsPlayer> players;
    private Dice<Integer> dice;
    private boolean isPointSet = false;
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


    private void rollHighLow(){
        int playerRoll;
        int botRoll;

        do {
            playerRoll = dice.rollDie();
            botRoll = dice.rollDie();
        }while (playerRoll==botRoll);

        isPlayerTurn=(playerRoll>botRoll);

    }

    private void crapsBetting(){
        if (!isPointSet){
            //do pass don'tPass betting to main pot

        }
        else
        {
            //offer sideBet chance
        }
    }



    @Override
    public void takeBet(Double bet) {
        mainPot.addMoney(bet*2);
    }

    @Override
    public Double settleBet() {
        return null;
    }

    private class CrapsPlayer {

        private User user;



        public CrapsPlayer(User user) {
            this.user = user;
        }

        public void makeABet(Double money) {
        }

        public void winABet(Double money) {
        }
    }
}
