package io.zipcoder.casino.CasinoUtilities;

import java.util.Scanner;

public class Console {

    private static Scanner casinoScanner = new Scanner(System.in);

    public static String getString(String userInput) {
        return casinoScanner.nextLine();
    }

    public static Double getDouble(String userInput) {

        return Double.valueOf(casinoScanner.nextLine());
    }

    public static int getInt(String userInput) {

        return getDouble(userInput).intValue();
    }

    //TODO: implement later once rules are operational
    /*public static void readFile() {

    }*/

    public static void print(String output) {
        System.out.println(output);
    }


}
