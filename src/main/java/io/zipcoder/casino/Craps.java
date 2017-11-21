package io.zipcoder.casino;

public class Craps extends Game implements PlayForMoney {
    private Bank house;

    private CrapsBetType betType;
    private Double playerBet;
    private boolean isComeOut;
    private Integer point = 0;
    private Integer comePoint;

    public void getDiceRoll(CrapsPlayer player) {
        player.roll2Dice();
    }

    public void startPlayerTurn() {


    }

    public void takeBet(Double betAmount) {
        this.playerBet = betAmount;
    }

    public double betReceiveFromPlayers() {
        return 0;
    }


    public Double getPlayerBet() {
        return playerBet;
    }

    /*
    if (play.equals("y")){
            Integer roll = shooter.roll2Dice();
            shooter.printRoll();
            gameOn.setComeOut(true);
            if(!gameOn.passBetWinsComeOut(roll) && !gameOn.passBetLosesComeOut(roll)){
                do{
                    System.out.println("Roll again!");
                    if(gameOn.getIsComeOut()){
                        gameOn.setPoint(roll);
                    }
                    roll = shooter.roll2Dice();
                    shooter.printRoll();
                    gameOn.setComeOut(false);
                }while(roll != 7 && roll !=gameOn.getPoint());
            }
            else if(gameOn.passBetWinsComeOut(roll)){
                System.out.println("You win! Added " + passLineBet + " to your bank.");

            }else if(gameOn.passBetLosesComeOut(roll)) {
                System.out.println("You lose.");
            }

            if(gameOn.passBetWins(roll)){
                System.out.println("You win! Added " + passLineBet + " to your bank.");
            }else if(gameOn.passBetLoses(roll)){
                System.out.println("You lose.");
            }*/


    public void isWinner() {

    }

    public void crapsRound() {
        //take bets

        //roll dice

        //determine winner loop if none.

    }



 /*

    public boolean passBetLosesComeOut(int roll){
        return (roll == 2 || roll == 3 || roll == 12);

    }

    public boolean passBetWins(int roll) {
        return(roll == this.point);
    }

    public boolean passBetLoses(int roll){
        return (roll == 7);
    }*/


    public boolean dontPassWins(int roll) {
        if (isComeOut && (roll == 2 || roll == 3)) {
            return true;
        } else if (!isComeOut && (roll == 7)) {
            return true;
        }
        return false;
        //refactor to add push condition for 12
    }


    public void setBetType(CrapsBetType betType) {
        this.betType = betType;
    }

    public void placeBet(double betAmount) {
        this.playerBet = betAmount;
    }

    public void rollAgain() {

    }


    public void takeBet(double betAmount) {

    }

    public void resolveBets() {

    }

    public void setComeOut(boolean comeOut) {
        isComeOut = comeOut;
    }

    public boolean getIsComeOut() {
        return isComeOut;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public boolean isBetWinComeOut(int roll, CrapsBetType betType) {
        if (betType == CrapsBetType.PASSLINE)
            return (roll == 7 || roll == 11);
        if (betType == CrapsBetType.DONTPASS)
            return (roll == 2 || roll == 3);
        return false;

    }

    public boolean isBetLossComeOut(int roll, CrapsBetType betType) {
        if (betType == CrapsBetType.PASSLINE)
            return (roll == 2 || roll == 3 || roll == 12);
        if (betType == CrapsBetType.DONTPASS)
            return (roll == 7 || roll == 11);
        return false;

    }


    public CrapsBetType getBetType() {
        return betType;
    }

    public boolean isNoResultRoll(int roll, CrapsBetType betType) {
        setPoint(roll);
        return !isBetWinComeOut(roll, betType) && !isBetLossComeOut(roll, betType);

    }

    public boolean isBetWin(int roll, CrapsBetType betType) {
        if (betType == CrapsBetType.PASSLINE)
            return (roll == this.point);
        if (betType == CrapsBetType.DONTPASS)
            return (roll == 7);
        return false;
    }

    public boolean isBetLoss(int roll, CrapsBetType betType) {
        return (!isBetWin(roll, betType));
    }
}

