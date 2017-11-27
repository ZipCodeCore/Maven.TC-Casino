package io.zipcoder.casino;

import java.util.Scanner;

public class InPutConsole {

    static Scanner scanner = new Scanner(System.in);

    private InPutConsole() {
    }

    public static String getInput(){

        return scanner.nextLine();
    }

//    public static String getCardInput() {
//        String input = "";
//        GoFishGame goFishGame = new GoFishGame();
//        input =  scanner.nextLine().toUpperCase();
//        Boolean checkResult = false;
//        while (checkResult == false) {
//            if (goFishGame.checkPlayersCardRequestForGameRule(input)==true) {
//                checkResult = true;
//                break;
//            } else {
//                System.out.println("You cannot request for card not in hand. Insert the card you want ");
//                input = scanner.nextLine().toUpperCase();
//                checkResult = false;
//            }
//
//        }
//        return input;
//    }
}

