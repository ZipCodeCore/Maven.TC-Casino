package io.zipcoder.casino;

public class Craps extends Die implements Gamble {

    private int point;
    private Double pot = 0.0;
    Player crapsPlayer = new Player();

    public Craps() {
        this.point = 0;
        rollDice();
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setPot(Double moneyToBet) {
        this.pot = moneyToBet;
    }

    public Double getPot() {
        return pot;
    }

    public void placeBet(Double moneyToBet) {
        if (hasMoneyToMakeBet(crapsPlayer.getMoney())) {
            setPot(moneyToBet);
            //subtract their bet for their money
            crapsPlayer.setMoney(crapsPlayer.getMoney() - moneyToBet);
        } else { //would we want to throw an exception here instead...
            System.out.println("You do not have enough money to make a bet! Your current balance is " + crapsPlayer.getMoney());
        }
    }


    public boolean hasMoneyToMakeBet(Double amount) {
        if (crapsPlayer.getMoney() == 0.0) {
            return false;
        }
        return true;
    }

    public void cashInWinnings() {  //how do we determine that the player wins or losses?
        crapsPlayer.setMoney(crapsPlayer.getMoney() + getPot()*2);
    }

    //have a while loop in the CrapsConsole
    public int firstRoll() {
        if (diceTotal() == 7 || diceTotal() ==  11) {
            cashInWinnings(); //cashInWinnings  //what if they already have money? add to the money they already have
            return diceTotal(); 
        }
        else if (diceTotal() == 2 || diceTotal() == 3 || diceTotal() ==12 ) {
            setPot(0.0);
            return diceTotal();
        }
        else {
            point = diceTotal();
            return diceTotal();
        }
    }

//    public int secondRoll() {
//
//    }
}

//logic:
//make a bet
//first roll: 7 or 11 = win or 2, 3, 12 = lose, any other role becomes there point and it is returned to them
// second roll (if rolled a point): roll the point value = win; role a 7 = lose (needs to keep going until we roll the point value;

