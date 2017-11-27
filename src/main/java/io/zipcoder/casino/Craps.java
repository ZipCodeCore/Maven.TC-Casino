package io.zipcoder.casino;

public class Craps extends DicePlayer implements Gamble, Game {

    private int point;
    private Double pot = 0.0;
    DicePlayer crapsPlayer = new Craps();

    public Craps() { 
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

    public int placeBet(Double moneyToBet) {
        if (hasMoneyToMakeBet(moneyToBet)) {

            setPot(moneyToBet);
            Double tempMoney = crapsPlayer.getMoney();
            crapsPlayer.setMoney(tempMoney - moneyToBet);
            return 0;
        } else {
            System.out.println("You do not have enough money to make a bet! Your current balance is " + crapsPlayer.getMoney());
            return 1;
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

    private int firstRoll() {
        die.rollDice();
        if (die.diceTotal() == 7 || die.diceTotal() == 11) {
            cashInWinnings();
            System.out.println("You win! " + die.diceTotal());
            return 0;

        } else if (die.diceTotal() == 2 || die.diceTotal() == 3 || die.diceTotal() == 12) {
            setPot(0.0);
            System.out.println("You lose! " + die.diceTotal());
            return 0;

        } else {
            point = die.diceTotal();
            System.out.println("New target roll " + die.diceTotal());
            return 1;
        }
    }

    private void secondRoll() {
        do {
            die.rollDice();
            if (die.diceTotal() == getPoint()) {
                cashInWinnings();
                System.out.println("You win! " + die.diceTotal());
                break;
            } else if (die.diceTotal() == 7 || die.diceTotal() == 11) {
                setPot(0.0);
                System.out.println("You lose! " + die.diceTotal());
                break;
            } else {
                System.out.println("Rolling again " + die.diceTotal());
            }
        } while (die.diceTotal() != getPoint());
    }

//    public void continuePlaying() {
//        System.out.println("Would you like to play a new game of Craps?");
//        //if input is equalled to Yes.toLowerCase, play another game, crabs.play()
//        //if input is no.toLowerCase, exit game
//    }

    public void play() {
        String playAgain;
        Double bet;

        do {

            System.out.println("================================================================\n" +
                    "Greetings player! Welcome to Basic AF Casino's version of Craps!\n " +
                    "\t\t\tLets get started!\n" +
                    "================================================================");

            do {
                    bet = ConsoleInput.getDoubleInput("How much would you like to bet?");

                } while (placeBet(bet) == 1);

            System.out.println("Your current bet is " + bet);
            System.out.println("Let's get the dice rolling!");

            if (firstRoll() == 1) {
                secondRoll();
            }
            if (crapsPlayer.getMoney() == 0.0){
                System.out.println("You're out of money buddy, get lost");
                System.exit(0);
            }
            playAgain = ConsoleInput.getStringInput("Would you like to play again? Yes or No");
        } while (!playAgain.equals("no"));
    }
}
