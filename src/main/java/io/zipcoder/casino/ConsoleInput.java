package io.zipcoder.casino;

import java.util.Scanner;

public class ConsoleInput {

    public static String getStringInput(String prompt) {
        do {
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            try {
                if (userInput.isEmpty())
                    throw new IllegalArgumentException();
                    return userInput;
            } catch (IllegalArgumentException iae) {
                System.out.println("Invalid input, please enter a valid response.");
            }

        } while (true);
    }

    public static Double getDoubleInput(String prompt){
        String userInput;

        do{
            userInput = getStringInput(prompt);
            try{
                return Double.parseDouble(userInput);
            }catch (IllegalArgumentException iae){
                System.out.println("Invalid input, please enter a valid response.");
            }
        }while (true);
    }

    public static Integer getIntegerInput(String prompt){
        return getDoubleInput(prompt).intValue();
    }
}
