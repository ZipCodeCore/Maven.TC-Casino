package io.zipcoder.casino;

public class Display {

    public static String welcomeGoFish(Player player){
        System.out.println("Welcome To Go Fish, " + player.getName());
        String answer = Console.getStringInput("Would you like to play?");
        return answer;
    }

}
