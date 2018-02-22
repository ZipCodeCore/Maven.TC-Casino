package io.zipcoder.casino.InputOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {
    Scanner input = new Scanner(System.in);

    //MUST INSTANTIATE IN CASINO

    public String scanForString() {
        String stringReturn = new String();
        if (input.hasNext()) {
            stringReturn = input.nextLine();
        }
        return stringReturn;
    }

    public Integer scanForInt(){
        Integer integerReturn = input.nextInt();
        return integerReturn;
    }

    public Double scanForDouble(){
        Double doubleReturn = input.nextDouble();
        return doubleReturn;
    }

    public ArrayList displayOver21Menu(){
        return  null;
    }
    public ArrayList displayUnder21Menu(){
        return  null;
    }


    public String promptForString(String message) {
        System.out.println(message);
        return scanForString();
    }

    public int promptInt(String message) {
        System.out.println(message);
        return scanForInt();
    }

    public Double promptDouble(String message) {
        System.out.println(message);
        return scanForDouble();
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
