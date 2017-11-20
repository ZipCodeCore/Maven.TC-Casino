package io.zipcoder.casino.nuts_n_bolts;

import java.util.Scanner;

public class Input {

    public static String getStringInput(String prompt){
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Double getDoubleInput(String prompt){
        String stringInput = "";
        Double doubleInput = null;
        do {
            stringInput = getStringInput(prompt);
            try {
                doubleInput = Double.parseDouble(stringInput);
                return doubleInput;
            } catch (IllegalArgumentException iae) {
                System.out.println("Not a valid amount.");
                continue;
            }
        } while (true);
    }

    public static Double getPositiveDoubleInput(String prompt){
        Double doubleInput = null;
        do {
            doubleInput = getDoubleInput(prompt);
            if (doubleInput >= 0){
                return doubleInput;
            } else {
                System.out.println("Please input a positive amount.");
                continue;
            }
        } while (true);
    }

}
