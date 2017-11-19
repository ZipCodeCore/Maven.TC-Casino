package io.zipcoder.casino;

public class Craps extends Game implements PlayForMoney {
    private Bank house;
    private BetType betType;
    private double betAmount;
    private boolean isComeOut;
    private Integer point;
    private Integer comePoint;

    public void startRound(double betAmount){
        isComeOut = true;


    }

    public boolean passBetWins(int roll) {
        if (isComeOut && (roll == 7 || roll == 11)) {return true;}
            else if (!isComeOut && (roll == point)) {return true;}
        return false;
    }

    public boolean passBetLoses(int roll){
        if (isComeOut && (roll == 2 || roll == 3 || roll == 12)) {return true;}
        else if (!isComeOut && (roll == 7)) {return true;}
        return false;
    }


    public boolean dontPassWins(int roll){
        if (isComeOut && (roll == 2 || roll == 3)) {return true;}
        else if (!isComeOut && (roll == 7)) {return true;}
        return false;
        //refactor to add push condition for 12
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public void placeBet(double betAmount) {
        this.betAmount = betAmount;
    }

    public void rollAgain(){

    }

    public void resolveBets() {

    }

    public void setComeOut(boolean comeOut) {
        isComeOut = comeOut;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
