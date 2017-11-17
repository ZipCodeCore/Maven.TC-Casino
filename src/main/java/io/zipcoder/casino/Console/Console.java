package io.zipcoder.casino.Console;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static String getString(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        String userinput = input.nextLine();
        return userinput;
    }

    public static double getDouble(String prompt) {

        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println(prompt);
                double userinput = input.nextDouble();
                return userinput;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("INVALID AMOUNT\n");
                continue;
            }
        } while (true);
    }
}
//    public static Currency getEnum(String prompt) {
//
//        do {
//            try {
//                String userinput = getString(prompt).toUpperCase();
//                Currency enuminput = Currency.valueOf(userinput);
//                return enuminput;
//            } catch (IllegalArgumentException e) {
//                System.out.println("INVALID CURRENCY\n");
//                continue;
//            }
//        } while (true);
//    }
//}
