package io.zipcoder.casino;

public class Display {

    public static void welcomeGoFish(Player player){
        System.out.println("Welcome To Go Fish, " + player.getName());
//        String answer = Console.getStringInput("Would you like to play?");
//        return answer;
    }

    public static int howManyComputers() {
        int numberOfComputers = Console.getIntegerInput("How many computer players would you like to play against? (1-3)");
        return numberOfComputers;
    }

}
