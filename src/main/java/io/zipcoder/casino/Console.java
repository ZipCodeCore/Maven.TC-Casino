package io.zipcoder.casino;

import java.util.Scanner;

public class Console {

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        String userStringInput;
        Double doubleInput;
        do {
            userStringInput = getStringInput(prompt);
            try {
                doubleInput = Double.parseDouble(userStringInput);
                return doubleInput;
            } catch (IllegalArgumentException e) {
                Console.print("Please make sure you have entered a number.");
                continue;
            }
        } while (true);
    }

    public static Integer getIntegerInput(String prompt) {
        Double userDoubleInput = getDoubleInput(prompt);
        Integer output = userDoubleInput.intValue();
        return output;
    }

    public static void print(int input) {
        System.out.println(input);
    }

    public static void print(String input) {
        System.out.println(input);
    }

    public static void displayPlayerHandAndScore(Player userPlayer) {
        Card card;
        for (int i=0; i< userPlayer.getHand().size(); i++)
        {
            card = userPlayer.getHand().get(i);
            if (i!=userPlayer.getHand().size()-1)
                System.out.print(card.getTopCardRepresentation());
            else
                System.out.println(card.toString());
        }
    }

}