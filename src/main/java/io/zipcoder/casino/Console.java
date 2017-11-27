package io.zipcoder.casino;

import java.util.Scanner;

public class Console {

    public static String getStringInput(String prompt) {
        Scanner in = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = in.nextLine();
        return userInput.toUpperCase();
    }


    public static Integer getIntegerInput(String prompt) {
        do {
            try {
                String userInput = getStringInput(prompt);
                Integer intUserInput = Integer.parseInt(userInput);
                return intUserInput;
            } catch (IllegalArgumentException iae) {
                continue;
            }
        } while (true);
    }

    public static Card.Rank getRankInput(String prompt) {
        do {
            try {
                String userInput = getStringInput(prompt);
                Card.Rank rank = Card.Rank.valueOf(userInput);
                return rank;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Card Choice");
            }
        } while (true);
    }
}
