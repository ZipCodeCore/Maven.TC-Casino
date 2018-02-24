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
        Console.print(bar);
        Console.print("The game is in the Come Out phase");
        int roll = this.getRollValue();
        if(isNatural(roll)){
            Console.print("You rolled a Natural");
            this.rollIsNaturalPayout();
            this.newRound = true;
            this.turn();
        }
        else if(isCraps(roll)){
            Console.print("You rolled Craps");
            this.rollIsCrapsPayout(roll);
            this.newRound= true;
            this.turn();
        }
        else{
            this.point = roll;
            Console.print("The game is entering the Point phase");
            Console.print("The point is set to: " + this.point);
            this.isComeOutPhase=false;
            this.turn();
        }
    }

    public void pointPhase(){
        Console.print(bar);
        Console.print("The game is in the Point phase");
        Console.print("The Point is set to: " + this.point);
        int roll = this.getRollValue();
        if(roll == this.point){
            this.passLinePayout();
            this.newRound = true;
            Console.print("The game is entering the Come Out Phase");
            this.isComeOutPhase= true;
            this.turn();
        }
        else if(roll == 7){
            this.doNotPassPayout();
            this.newRound = true;
            Console.print("The game is entering the Come Out Phase");
            this.isComeOutPhase = true;
            this.turn();
        }
        else{
            this.turn();
        }
    }

    public void turn(){

        String rollOrBet;
        do {
            Console.print(bar);
            Console.print("Would you like to [roll] or [bet]?");
            rollOrBet = Console.getString();
            if (rollOrBet.equalsIgnoreCase("roll")) {
                if(isComeOutPhase){
                    this.comeOutPhase();
                }
                else{
                    this.pointPhase();
                }
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
        boolean validBet;
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
                validBet =this.placeBet(betType);
                if(validBet) {
                    newRound = false;
                }
                break;

            case "do not pass":
                if(!newRound && isInvalidBet(currentPlayer.isPassLine())){
                    break;
                }
                betType = CrapsBet.DO_NOT_PASS;
                currentPlayer.setPassLine(false);
                validBet = this.placeBet(betType);
                if(validBet) {
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

    public boolean placeBet(TypeOfBet betType){
        Console.print(bar);
        Console.print("Your current balance is: $" + currentPlayer.getProfile().getAccountBalance());
        Console.print("How much would you like to bet?");
        Double betAmount = Console.getDouble();
        boolean wasBetPlaced = currentPlayer.bet(betType, betAmount);
        Console.print(bar);
        Console.print("Your bet has been placed.  Your current balance is now: $" + currentPlayer.getProfile().getAccountBalance());
        return wasBetPlaced;
    }

    public void rollIsNaturalPayout(){
        if(currentPlayer.isPassLine()){
            Console.print("Your Pass Line bet pays even money!");
            currentPlayer.win(CrapsBet.PASS_LINE, 1);
            Console.print(newBalance());
        }
        else if(!currentPlayer.isPassLine()){
            Console.print("Your Do Not Pass bet loses");
            currentPlayer.lose(CrapsBet.DO_NOT_PASS);
            Console.print(newBalance());
        }
    }

    public void rollIsCrapsPayout(int roll){
        if(currentPlayer.isPassLine()){
            Console.print("You Crapped Out");
            Console.print("Your Pass Line bet loses");
            currentPlayer.lose(CrapsBet.PASS_LINE);
            Console.print(newBalance());
        }
        else if(!currentPlayer.isPassLine() && roll == 12){
            Console.print("Your Do Not Pass bet breaks even");
            currentPlayer.win(CrapsBet.DO_NOT_PASS, 0);
            Console.print(newBalance());
        }
        else if(!currentPlayer.isPassLine()){
            Console.print("Your Do Not Pass bet pays even money!");
            currentPlayer.win(CrapsBet.DO_NOT_PASS, 1);
            Console.print(newBalance());
        }
    }

    public void passLinePayout(){
        if(currentPlayer.isPassLine()){
            Console.print("Your made your Point!");
            Console.print("Your Pass Line bet pays even money!");
            currentPlayer.win(CrapsBet.PASS_LINE, 1);
            Console.print(newBalance());
        }
        else if(!currentPlayer.isPassLine()){
            Console.print("The Point came before a 7");
            Console.print("Your Do Not Pass bet loses");
            currentPlayer.lose(CrapsBet.DO_NOT_PASS);
            Console.print(newBalance());
        }
    }

    public void doNotPassPayout(){
        if(currentPlayer.isPassLine()){
            Console.print("A 7 came before the Point");
            Console.print("You Sevened Out");
            Console.print("Your Pass Line bet loses");
            currentPlayer.lose(CrapsBet.PASS_LINE);
            Console.print(newBalance());
        }
        else if(!currentPlayer.isPassLine()){
            Console.print("A 7 came before the Point!");
            Console.print("Your Do Not Pass bet pays even money!");
            currentPlayer.win(CrapsBet.DO_NOT_PASS,1);
            Console.print(newBalance());
        }

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

    public CrapsPlayer getCurrentPlayer(){
        return this.currentPlayer;
    }


    private String invalidInput = "Invalid input: please enter your choice again";
    private String bar = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";
    public String newBalance(){
        return "Your new balance is: $" + currentPlayer.getProfile().getAccountBalance();
    }
}
