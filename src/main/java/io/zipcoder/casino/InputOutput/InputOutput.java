package io.zipcoder.casino.InputOutput;

import io.zipcoder.casino.Players.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class InputOutput {
    Scanner input = new Scanner(System.in);
    public ArrayList<String> under21Games = new ArrayList<String>();

    //MUST INSTANTIATE IN CASINO

    public String scanForString() {
        String stringReturn = input.nextLine();

        return stringReturn;
    }


    public Integer scanForInt() {
        return Integer.parseInt(scanForString());
    }


    public String availableGames(Player player){
        InputOutput inputOutput = new InputOutput();
        TreeMap<Integer, String> games = new TreeMap<Integer, String>();
        Integer number;
        if(player.getAge() > 20) {
            games.put(1, "War");
            games.put(2, "Go Fish");
            games.put(3, "BlackJack");
            games.put(4, "Craps");
            games.put(5, "Exit");
            number = inputOutput.promptForInt("Please select a game\n1.War\n2.Go Fish\n3.BlackJack\n4.Craps");
        } else {
            games.put(1, "War");
            games.put(2,"Go Fish");
            games.put(3, "Exit");
            number = inputOutput.promptForInt("Please enter in a number between 1 - 2 to select a game");

        }
        StringBuilder displayGames = new StringBuilder();

        return games.get(number);
    }

    public String promptForString(String message) {
        System.out.println(message);
        String s = scanForString();
        return s;
    }

    public int promptForInt(String message) {
        System.out.println(message);
        return scanForInt();
    }



    //generic methods
    //method for menus
    //create line breaks
    //validate user input


//    public static void main(String[] args) {
//        InputOutput io = new InputOutput();
//        System.out.println("Enter your name");
//        String name = io.scanForString();
//        System.out.println(name);
//    }
}
