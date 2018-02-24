package io.zipcoder.casino.Game.diceGame.Craps;


import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.CrapsBet;
import io.zipcoder.casino.Game.diceGame.DiceGame;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import io.zipcoder.casino.TypeOfBet;

import java.util.Arrays;

public class CrapsGame extends DiceGame {
    private int point;
    boolean isComeOutPhase = true;
    private CrapsPlayer currentPlayer;
    private boolean newRound = true;



    public CrapsGame(Profile profile) {
        this.currentPlayer = new CrapsPlayer(profile);
    }

    public static void main(String[] args) {
        Profile stinkyProfile = new Profile("Stinky Pete", 1000, 11);
        CrapsGame testGame = new CrapsGame(stinkyProfile);
        testGame.startGame();
        testGame.turn();
    }

    public void comeOutPhase(){




    }
    public void pointPhase(){

    }
    public void turn(){

        String rollOrBet;
        do {
            Console.print(bar);
            Console.print("Would you like to [roll] or [bet]?");
            rollOrBet = Console.getString();
            if (rollOrBet.equalsIgnoreCase("roll")) {
                Console.print(bar);
                int roll = this.getRollValue();
            } else if (rollOrBet.equalsIgnoreCase("bet")) {
                Console.print(bar);
                this.selectBet();
            }
            else{
                Console.print(invalidInput);
            }
        }
        while(!rollOrBet.equalsIgnoreCase("roll"));
    }

    public void selectBet(){
        boolean keepRunning = true;
        do {
            Console.print(this.printBettingMenu());
            Console.print("What type of bet would you like to place?");
            Console.print("Enter [stop] to finish betting");
            String textBet = Console.getString();
            keepRunning = this.chooseBet(textBet);

        }
        while(keepRunning == true);

    }

    public boolean chooseBet (String textBet){
        double playerBalance = currentPlayer.getProfile().getAccountBalance();
        TypeOfBet betType;
        textBet = textBet.toLowerCase();
        switch (textBet) {

            case "stop":
                return false;

            case "pass line":
                if(!newRound && isInvalidBet(!currentPlayer.isPassLine())){
                    break;
                }
                betType = CrapsBet.PASS_LINE;
                currentPlayer.setPassLine(true);
                this.placeBet(betType);
                if(currentPlayer.getProfile().getAccountBalance() != playerBalance) {
                    newRound = false;
                }
                break;

            case "do not pass":
                if(!newRound && isInvalidBet(currentPlayer.isPassLine())){
                    break;
                }
                betType = CrapsBet.DO_NOT_PASS;
                currentPlayer.setPassLine(false);
                this.placeBet(betType);
                if(currentPlayer.getProfile().getAccountBalance() != playerBalance) {
                    newRound = false;
                }
                break;

            default:
                Console.print(invalidInput);
                Console.print(bar);
        }
        return true;
    }

    public boolean isInvalidBet(boolean betCondition){
        if(betCondition){
            Console.print("You cannot place that type of bet at this time");
            Console.print(bar);
            return true;
        }
        return false;
    }


    public String printBettingMenu(){
        StringBuilder bettingMenu = new StringBuilder("Here are the types of bets you can make: \n");
            if(newRound || currentPlayer.isPassLine()){
                bettingMenu.append("[Pass Line] \n");
            }
            if(newRound || !currentPlayer.isPassLine()){
                bettingMenu.append("[Do Not Pass]\n");
            }
        return bettingMenu.toString();
    }

    public void placeBet(TypeOfBet betType){
        Console.print(bar);
        Console.print("Your current balance is: $" + currentPlayer.getProfile().getAccountBalance());
        Console.print("How much would you like to bet?");
        Double betAmount = Console.getDouble();
        currentPlayer.bet(betType, betAmount);
        Console.print(bar);
        Console.print("Your bet has been placed.  Your current balance is now: $" + currentPlayer.getProfile().getAccountBalance());

    }


    public int getRollValue(){
        int [] rawRoll = this.rollDice();

        int sum = 0;
        for(int i : rawRoll){
            sum += i;
        }
        Console.print(Arrays.toString(rawRoll) +"\nYou rolled a " + sum);
        return sum;
    }

    public static boolean isCraps(int rollValue){
       if(rollValue == 2 || rollValue == 3 || rollValue == 12){
           return true;
       }
       else{
           return false;
       }
    }

    public static boolean isNatural(int rollValue){
        if(rollValue == 7 || rollValue == 11){
            return true;
        }
        else{
            return false;
        }

    }

    public int getPoint(){
        return this.point;
    }

    @Override
    public void startGame(){
        this.createDie(6,2);
        this.point = 0;
    }


    private String invalidInput = "Invalid input: please enter your choice again";
    private String bar = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";

}
