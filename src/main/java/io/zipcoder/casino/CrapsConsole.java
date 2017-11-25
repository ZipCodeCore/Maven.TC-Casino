package io.zipcoder.casino;

import java.util.Scanner;

public class CrapsConsole {


    public void playCraps(){
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
            Integer roll = getRoll(crapsPlayer);
            crapsPlayer.printRoll();

            rollComeout(craps, crapsPlayer, roll);

            playGame = askPlayAgain();
            }

        }


    private void rollPointRound(Craps craps, CrapsPlayer crapsPlayer, Integer roll) {

        craps.setPoint(roll);
        System.out.println("Point is set at " + roll);

        while(true){
            promptPlayerForRoll();
            roll = getRoll(crapsPlayer);
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

    private void rollComeout(Craps craps, CrapsPlayer crapsPlayer, Integer roll) {
            if(craps.isBetWinComeOut(roll, craps.getBetType())){
                craps.playerWins(crapsPlayer);
            }else if (craps.isBetLossComeOut(roll, craps.getBetType())){
                craps.playerLoses(crapsPlayer);
            }else {
                rollPointRound(craps, crapsPlayer,roll);
            }
    }


    private Integer getRoll(CrapsPlayer crapsPlayer) {
        getUserInput();
        return crapsPlayer.roll2Dice();
    }

    private void promptPlayerForRoll() {
        System.out.println("Ready? Enter to roll");
    }

    private void promptPlayerForBet() {
        System.out.println("How much do you want to bet?");

    }

    private static CrapsBetType getBetTypeInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        while(true){

        if(input.equalsIgnoreCase("pass")){
            return CrapsBetType.PASSLINE;
        }else if(input.equalsIgnoreCase("dont")){
            return CrapsBetType.DONTPASS;
            }
        }
    }

    private static void promptPlayerForBetType() {
        System.out.println("Enter 'pass' to bet the passline\nEnter 'dont'" +
                " to bet against the passline.");
    }

    private static void askIfPlayerWantsToPlay() {
        System.out.println("Ready to play some craps? Win big and make a bunch of friends along the way!\n" +
                            "Feeling lucky...? 'y' or 'n'" );

    }

    public static boolean getBooleanInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        if(input.equalsIgnoreCase("y")){
            return true;
        }else{
            return false;
        }
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

    private boolean askPlayAgain() {
        System.out.println("Play again?");
        return getBooleanInput();
    }


}
