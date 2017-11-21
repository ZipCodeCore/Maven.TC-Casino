package io.zipcoder.casino;

import java.util.Scanner;

public class Console {
    public static String getStringInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner= new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        String userInputString = getStringInput(prompt);
        double userInputDouble = Double.parseDouble(userInputString);
        return userInputDouble;
    }
    public static Integer getIntegerInput(String prompt) {
        String userInputString = getStringInput(prompt);
        double userInputInteger = Integer.parseInt(userInputString);
        return (int)userInputInteger;
    }
}
