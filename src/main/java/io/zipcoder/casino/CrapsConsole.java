package io.zipcoder.casino;

import java.util.Scanner;

import static io.zipcoder.casino.Console.casinoHome;

public class CrapsConsole {


    public static void playCraps(){
        Craps craps = new Craps();
        CrapsPlayer crapsPlayer = new CrapsPlayer();

        askIfPlayerWantsToPlay();
        boolean playGame = getBooleanInput();

        while(playGame){

            promptPlayerForBetType();
            craps.setBetType(getBetTypeInput());

            promptPlayerForBet();
            craps.setPlayerBet(getEnforcedPositiveDoubleInput());

            promptPlayerForRoll();
            Integer roll = crapsPlayer.roll2Dice();
            crapsPlayer.printRoll();

            rollComeout(craps, crapsPlayer, roll);

            playGame = askPlayAgain();
            }
        casinoHome();
        }


    private static void rollPointRound(Craps craps, CrapsPlayer crapsPlayer, Integer roll) {

        craps.setPoint(roll);
        System.out.println("Point is set at " + roll);

        while(true){
            promptPlayerForRoll();
            roll = crapsPlayer.roll2Dice();

            crapsPlayer.printRoll();
            if(craps.isBetWin(roll, craps.getBetType())){
                craps.playerWins(crapsPlayer);
                return;
            }else if(craps.isBetLoss(roll, craps.getBetType())){
                craps.playerLoses(crapsPlayer);
                return;
            }
        }
    }

    private static void rollComeout(Craps craps, CrapsPlayer crapsPlayer, Integer roll) {
            if(craps.isBetWinComeOut(roll, craps.getBetType())){
                craps.playerWins(crapsPlayer);
            }else if (craps.isBetLossComeOut(roll, craps.getBetType())){
                craps.playerLoses(crapsPlayer);
            }else {
                rollPointRound(craps, crapsPlayer,roll);
            }
    }


    private static void promptPlayerForRoll() {
        System.out.println("Ready? Enter to roll");
        getUserInput();
    }

    private static void promptPlayerForBet() {
        System.out.println("How much do you want to bet?");

    }

    private static CrapsBetType getBetTypeInput() {
        Scanner scan = new Scanner(System.in);
        String input;
        do{
            input = scan.next();
            if(!input.equalsIgnoreCase("pass")&&!input.equalsIgnoreCase("dont")){
                System.out.println("Please enter 'pass' or 'dont.'");
            }
        }while(!input.equalsIgnoreCase("pass")&&!input.equalsIgnoreCase("dont"));

        if(input.equalsIgnoreCase("pass")){
            return CrapsBetType.PASSLINE;
        }else if(input.equalsIgnoreCase("dont")){
            return CrapsBetType.DONTPASS;
        }


        return null;
    }

    private static void promptPlayerForBetType() {
        System.out.println("Enter 'pass' to bet the passline\nEnter 'dont'" +
                " to bet against the passline.");
    }

    private static void askIfPlayerWantsToPlay() {
        System.out.println("Ready to play some craps? Win big with small dice!\n" +
                            "Feeling lucky...? 'y' or 'n'" );

    }

    public static boolean getBooleanInput() {
        Scanner scan = new Scanner(System.in);
        String input;
        do{
            input = scan.next();
            if(!input.equalsIgnoreCase("y")&&!input.equalsIgnoreCase("n")){
                System.out.println("Please enter 'y' or 'n.'");
            }
        }while(!input.equalsIgnoreCase("y")&&!input.equalsIgnoreCase("n"));
        return input.equalsIgnoreCase("y");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static double getEnforcedPositiveDoubleInput(){
        Scanner in = new Scanner(System.in);
        double dInput;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputDouble(sInput)||(Double.valueOf(sInput)<0)) {
                System.out.println("Please enter a decimal number greater than 0.");
            }
        }while (!isInputDouble(sInput)||(Double.valueOf(sInput)<0));
        dInput=Double.valueOf(sInput);
        return dInput;
    }

    private static boolean isInputDouble(String passedString)
    {
        try {
            Double output = Double.valueOf(passedString);
        } catch (NumberFormatException e) {
            return false;
        }
        return (true);
    }

    private static boolean askPlayAgain() {
        System.out.println("Play again?");
        return getBooleanInput();
    }


}
