package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.BlackjackPlayer;

public class BJKJSecret {

    boolean bulkApperception = false;
    BlackjackPlayer currentPlayer;

    public void start(BlackjackPlayer player){
        currentPlayer = player;
        displayMenu();

    }

    public void displayMenu(){
        System.out.println(
                "MENU\n" +
                        "DIALOGUETREE" +
                        "ATTRIBUTEMATRIX" +
                        "SCANPROTOCOL" +
                        "LOCATE" +
                        "TROUBLESHOOT" +
                        "MARKFORRECALL"
        );
        InputOutput scan = new InputOutput();
        String command = scan.scanForString();
        navigateMain(command.toLowerCase());

    }

    public void navigateMain(String command){
        switch (command){
            case "dialoguetree":
                System.out.println("IS - THIS - A - WESTWORLD - REFERENCE");
                break;
            case "attributematrix":
                attributeMatrix();
                break;
            case "scanprotocol":
                break;
            case "locate":
                System.out.println("ERROR - UNABLE TO LOCATE UNIT");
            case "troubleshoot":
                System.out.println("");
        }
    }

    public void attributeMatrix(){
        System.out.println(
                "ATTRIBUTE MATRIX:\n" +
                        "Humor = 8\n" +
                        "Coordination = 10\n" +
                        "Aggression = 5\n" +
                        "Tenacity = 13\n" +
                        "Bulk Apperception = 14" +
                        "Patience = 5\n" +
                        "Charm = 12"
        );
        System.out.println("Enter Command\n");
        InputOutput scan = new InputOutput();
        String command = scan.scanForString();
    }
}
