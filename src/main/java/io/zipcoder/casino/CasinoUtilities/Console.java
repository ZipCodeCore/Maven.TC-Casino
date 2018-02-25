package io.zipcoder.casino.CasinoUtilities;

import io.zipcoder.casino.Player;

import java.util.Scanner;

public class Console {

    private static Scanner casinoScanner = new Scanner(System.in);
    public static Player currentPlayer;

    public static String getString() {
        return casinoScanner.nextLine();
    }

    public static Double getDouble() {
        Double input;
        try {
            input = Double.valueOf(casinoScanner.nextLine());
            return input;
        }
        catch(NumberFormatException e){
            Console.print("Invalid input: please enter a numerical value");
            return -0.001;
        }

    }

    public static int getInt() {

        return getDouble().intValue();
    }

    //TODO: implement later once rules are operational
    /*public static void readFile() {

    }*/


    public static void print(String output) {
        /*System.out.println("============================================");
        System.out.println("Current Player: " + currentPlayer.getProfile().getName());
        System.out.println("Current Balance: " + currentPlayer.getProfile().getAccountBalance());
        System.out.println("============================================");*/

        System.out.println(output);
    }


}
