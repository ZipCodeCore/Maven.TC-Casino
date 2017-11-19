package io.zipcoder.casino;

import java.util.Scanner;
import java.util.WeakHashMap;

public class Console {

    public void casinoMenu() {

    }

    public void playCraps() {

        Craps gameOn = new Craps();

        System.out.println("New shooter.");
        CrapsPlayer shooter = new CrapsPlayer();
        gameOn.addPlayer(shooter);

        System.out.println("Place your bets. pass line only for the moment");
        System.out.println("How much?");

        double passLineBet = getDoubleInput();

        System.out.println("Ok betting $" + passLineBet + "." );
        System.out.println("S to shoot");
        String play = getAnyKey();

        if (play.equals("y")){
            Integer roll = shooter.roll2Dice();
            shooter.printRoll();
            gameOn.setComeOut(true);
            if((!(gameOn.passBetWins(roll)) && !(gameOn.passBetLoses(roll)))){
                do{
                    System.out.println("Roll again!");
                  //  gameOn.setComeOut(false);
                    roll = shooter.roll2Dice();
                    shooter.printRoll();
                }while(!(gameOn.passBetWins(roll)) && !(gameOn.passBetLoses(roll)));
            }
            if(gameOn.passBetWins(roll)){
                System.out.println("You win! Added " + passLineBet + " to your bank.");

            }else if(gameOn.passBetLoses(roll)) {
                System.out.println("You you lose.");
            }





            }


  //      boolean won = isWinner(bet, roll):
   //     boolean rollAgain = isEndRound();

    }

    private boolean isWinner() {
        return true;
    }

    private BetType getBet() {
        return null;
    }

    public void playBlackJack() {
    }

    public void playGoFish() {
    }

    public String getInput(){
        Scanner scan = new Scanner(System.in);
        return "y";
    }

    public String getAnyKey(){
        Scanner scan = new Scanner(System.in);
        scan.hasNext();
        return "y";
    }

    public double getDoubleInput() {
        Scanner scan = new Scanner(System.in);
        double dblInput;
        String stringInput = scan.nextLine();

        dblInput = Double.valueOf(stringInput);

        return dblInput;
    }
}


