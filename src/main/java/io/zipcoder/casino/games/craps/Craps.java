package io.zipcoder.casino.games.craps;

import io.zipcoder.casino.games.Gamble;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.nuts_n_bolts.Dice;
import io.zipcoder.casino.nuts_n_bolts.MoneyContainer;

import java.util.ArrayList;

public class Craps implements Gamble, Game {

    private CrapPointPair pair;
    private Dice<Integer> dice;
    private MoneyContainer mainPot;
    private MoneyContainer sidePot;
    private boolean isPlayerTurn;
    private int point;

    public Craps(){
        ArrayList<Integer> twoToTwelve = new ArrayList<>();
        for (int i=2; i<13; i++){
            twoToTwelve.add(i);
        }
        dice = new Dice(twoToTwelve);
        mainPot=new MoneyContainer();
        sidePot=new MoneyContainer();
        determineFirstRoller();
    }

//Add to pot
    @Override
    public void takeBet(Double bet) {
        takeBet(bet, mainPot);
    }
    private void takeBet(Double bet, MoneyContainer moneyContainer) {
        moneyContainer.addMoney(bet);
    }
    public void takeSideBet(Double bet){
        takeBet(bet, sidePot);
    }

//remove some from pot
    @Override
    public Double settleBet(Double winnings) {
        return (settleBet(winnings, mainPot));
    }
    private Double settleBet(Double winnings, MoneyContainer moneyContainer){
        return (moneyContainer.takeOutMoney(winnings));
    }
    public Double settleSideBet(Double winnings){
        return (settleBet(winnings, sidePot));
    }

//Take all from pot
    public Double emptyPot(){
        return emptyPot(mainPot);
    }
    private Double emptyPot(MoneyContainer moneyContainer){
        return moneyContainer.takeAllMoney();
    }
    public Double emptySidePot(){
        return emptyPot(sidePot);
    }


    public void determineFirstRoller(){
        isPlayerTurn=(dice.rollDie()-dice.rollDie()>0);//Player vs House, highest goes first, house wins tie
    }
    public void changePlayerTurn(){
        isPlayerTurn=!isPlayerTurn;
    }
    public boolean getPlayerTurn(){return isPlayerTurn;}

    public int getPoint(){return point;}
    public String getPair(){
        return(pair.text);
    }

    public Integer initialThrow(){ //returns -1 if 2/3/12
                                    // 1 if 7/11,
                                    // 0 if point set
        int numberRolled = dice.rollDie();

        switch (numberRolled){
            case  2:
            case  3:
            case 12:{
                        return -1;
                    }
            case  7:
            case 11:{
                        return 1;
                    }
            default:{
                        point=numberRolled;
                        for (CrapPointPair p : CrapPointPair.values()){
                            if (p.isInPair(point)){
                                pair=p;
                            }
                        }
                        return 0;
                    }
        }

    }
    public Integer secondaryThrow(){//returns -1 if crapped out,
                                    //returns 1 if point met
                                    //returns 0 if nothing met
                                    //returns any other number if pair met
        int numberRolled=dice.rollDie();

        if (numberRolled==point){//Won round
            return 1;
        } else if (numberRolled==7)//Lost round
            {
                return -1;
            } else if (pair.isInPair(numberRolled)){//Won sideBet
                    return numberRolled;
                } else{
                        return 0;//Neutral.
                      }
    }

    @Override
    public boolean play(String userInput) {
        return ("Y".equalsIgnoreCase(userInput));
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

        boolean isInPair(int passed) {
            return (this.a==passed || this.b==passed);
        }

    }



}
