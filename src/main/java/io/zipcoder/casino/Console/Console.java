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
    public static void print(String prompt){
        System.out.println(prompt);
    }


}
