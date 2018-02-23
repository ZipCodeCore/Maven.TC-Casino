package io.zipcoder.casino.InputOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {
    Scanner input = new Scanner(System.in);
    public ArrayList<String> under21Games = new ArrayList<String>();

    //MUST INSTANTIATE IN CASINO

    public String scanForString() {
        String stringReturn = input.nextLine();

        return stringReturn;
    }

    public Integer scanForInt(){
        return Integer.parseInt(scanForString());
    }

    public Integer displayOver21Menu(){
        InputOutput inputOutput = new InputOutput();
        ArrayList<String> over21Games = new ArrayList<String>();
        over21Games.add("War");
        over21Games.add("Go Fish");
        over21Games.add("BlackJack");
        over21Games.add("Craps");

        StringBuilder displayOver21Games = new StringBuilder();
        Integer number = inputOutput.promptForInt("Please enter in a number between 1-4 to select a game");

        return number;
    }
    public String displayUnder21Menu(){
        //ArrayList<String> under21Games = new ArrayList<String>();
        under21Games.add("War");
        under21Games.add("Go Fish");
        return  null;
    }


    /*public String promptForString(String message) {
        System.out.println(message);
        return scanForString();
    }
*/
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
