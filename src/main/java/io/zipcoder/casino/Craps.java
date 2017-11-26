package io.zipcoder.casino;

public class Craps extends DicePlayer implements Gamble {

    private int point;
    private Double pot = 0.0;
    DicePlayer crapsPlayer = new Craps();

    public Craps() {
        this.point = 0;
        die.rollDice();
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
        if (hasMoneyToMakeBet(moneyToBet)) {
            setPot(moneyToBet);
            Double tempMoney = crapsPlayer.getMoney();
            crapsPlayer.setMoney(tempMoney - moneyToBet);
        } else { //would we want to throw an exception here instead...
            System.out.println("You do not have enough money to make a bet! Your current balance is " + crapsPlayer.getMoney());
        }
    }


    public boolean hasMoneyToMakeBet(Double moneyToBet) {
        if (crapsPlayer.getMoney() < moneyToBet) {
            return false;
        }
        return true;
    }

    public void cashInWinnings() {
        crapsPlayer.setMoney(crapsPlayer.getMoney() + getPot() * 2);
    }

    public String firstRoll() {
        if (die.diceTotal() == 7 || die.diceTotal() == 11) {
            cashInWinnings();//cashInWinnings  //what if they already have money? add to the money they already have
            return "You win!" + die.diceTotal();
        } else if (die.diceTotal() == 2 || die.diceTotal() == 3 || die.diceTotal() == 12) {
            setPot(0.0);
            return "You lose!" + die.diceTotal();

        } else {
            point = die.diceTotal();
            return "New target roll" + die.diceTotal();
        }
    }

    public String secondRoll() {
        String result;
        do {
            die.rollDice();
            if (die.diceTotal() == getPoint()) {
                cashInWinnings();
                result = "You win!" + die.diceTotal();
                break;
            } else if (die.diceTotal() == 7 || die.diceTotal() == 11) {
                setPot(0.0);
                result = "You lose!" + die.diceTotal();
                break;
            } else {
                result =  "Rolling again" + die.diceTotal(); //suspicious....
            }
        } while (die.diceTotal() != getPoint());

        return result;
    }
}


if (crapsGame.firstRoll == )

//logic:
//make a bet
//first roll: 7 or 11 = win or 2, 3, 12 = lose, any other role becomes there point and it is returned to them
// second roll (if rolled a point): roll the point value = win; role a 7 = lose (needs to keep going until we roll the point value;

