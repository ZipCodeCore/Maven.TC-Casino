
package io.zipcoder.casino;

import static io.zipcoder.casino.CrapsConsole.getBooleanInput;

public class Craps extends Game implements PlayForMoney {
    private Bank house;

    private CrapsBetType betType;
    private Double playerBet;
    private Integer point = 0;

    public void startPlayerTurn() {
    }

    public void takeBet(Double betAmount) {
        this.playerBet = betAmount;
    }
    

    public Double getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(Double playerBet) {
        this.playerBet = playerBet;
    }

    public void setBetType(CrapsBetType betType) {
        this.betType = betType;
    }
    

    public double resolveBet(CrapsPlayer crapsPlayer, boolean isWin) {
        Double newWalletTotal;
       if(isWin){
            Double walletAmount = crapsPlayer.getWallet();
            newWalletTotal = walletAmount + this.getPlayerBet();
            crapsPlayer.setWallet(newWalletTotal);
            return newWalletTotal;
        }else{
           Double walletAmount = crapsPlayer.getWallet();
           newWalletTotal = walletAmount - this.getPlayerBet();
           crapsPlayer.setWallet(newWalletTotal);
           return newWalletTotal;
       }
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
        if(betType == CrapsBetType.PASSLINE)
            return(roll==7);
        if(betType == CrapsBetType.DONTPASS)
            return(roll == this.point);
        return (false);
    }

    public double makeBet(Double amount) {
        return 0;
    }

    public double collectWinnings(boolean isWin) {
        return 0;
    }

    public void playerWins(CrapsPlayer crapsPlayer) {
        System.out.println("You win!");
        Double newBalance = resolveBet(crapsPlayer, true);
        System.out.println("Your new balance is " + newBalance + "!");
    }

    public void playerLoses(CrapsPlayer crapsPlayer) {
        System.out.println("You lose:(");
        Double newBalance = resolveBet(crapsPlayer, false);
        System.out.println("Your new balance is " + newBalance + ".");
    }
}

