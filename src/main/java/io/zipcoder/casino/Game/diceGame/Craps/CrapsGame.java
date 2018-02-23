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



    public CrapsGame(Player player) {
        this.currentPlayer = new CrapsPlayer(player.getProfile());
        this.addPlayer(player);
        Console.currentPlayer = player;
    }

    public static void main(String[] args) {
        Profile stinkyProfile = new Profile("Stinky Pete", 1000, 11);
        Player stinkyPete = new Player(stinkyProfile);
        CrapsGame testGame = new CrapsGame(stinkyPete);
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
            Console.print("Would you like to [roll] or [bet]?");
            rollOrBet = Console.getString();
            if (rollOrBet.equalsIgnoreCase("roll")) {
                int roll = this.getRollValue();
            } else if (rollOrBet.equalsIgnoreCase("bet")) {
                this.selectBet();
            }
            else{
                Console.print(invalidInput);
            }
        }
        while(!rollOrBet.equalsIgnoreCase("roll"));
    }

    public void selectBet(){
        TypeOfBet betType;
        Console.print(bettingMenu);
        boolean keepRunning = true;
        do {
            Console.print("What type of bet would you like to place?");
            Console.print("Enter [stop] to finish betting");
            String textBet = Console.getString();
            textBet = textBet.toLowerCase();
            switch (textBet) {
                case "stop":
                    keepRunning = false;
                    break;

                case "pass line":
                    betType = CrapsBet.PASS_LINE;
                    break;

                case "do not pass":
                    betType = CrapsBet.DO_NOT_PASS;
                    break;

                default:
                    Console.print(invalidInput);


            }
        }
        while(keepRunning == true);

    }

    public void placeBet(TypeOfBet betType){
        Console.print("Your current balance is: $" + currentPlayer.getProfile().getAccountBalance());
        Console.print("How much would you like to bet?");
        Double betAmount = Console.getDouble();
        currentPlayer.bet(betType, betAmount);

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

    private String bettingMenu = "Here are the types of bets you can make: \n" +
            "[Pass Line] \n" +
            "[Do Not Pass]\n";

    private String invalidInput = "Invalid input: please enter your choice again";

}
