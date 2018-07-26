package io.zipcoder.casino;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public static String getUserInputString(String promptUser) {
        do {

            try {
                System.out.println(promptUser);
                String userInput = new Scanner(System.in).nextLine();
                return userInput;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input, please try again.");
                continue;
            }
        }
        while (true);
    }

    public static Double getUserInputDouble(String promptUser) {
        do {
            try {
                return Double.parseDouble(getUserInputString(promptUser));
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid response please try again.");
                continue;
            }
        } while (true);

    }

    public static Integer getUserInputInteger(String promptUser) {
        do {
            try {
                return Integer.parseInt(getUserInputString(promptUser));
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid response please try again.");
                continue;
            }
        } while (true);


    }

//    public static double checkForNullPointer(Double toBeChecked){
//        do {
//            try {
//                return toBeChecked;
//            } catch (NullPointerException npe){
//                toBeChecked = CurrencyConverter.getCurrencyRates(getUserInputInteger("Invalid response. Please try again."));
//                continue;
//            }
//        }
//        while (true);
//    }
}
