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
                "              --MENU--\n" +
                        "================================\n" +
                        "- DIALOGUETREE\n" +
                        "- ATTRIBUTEMATRIX\n" +
                        "- SCANPROTOCOL\n" +
                        "- LOCATE\n" +
                        "- TROUBLESHOOT\n" +
                        "- MARKFORRECALL\n"
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
                System.out.println("OPENING: ATTR MATRIX INTERFACE");
                attributeMatrix();
                break;
            case "scanprotocol":
                System.out.println("no");
                break;
            case "locate":
                System.out.println("ERROR - UNABLE TO LOCATE UNIT");
                break;
            case "troubleshoot":
                System.out.println("ERROR - UNAVAILABLE WHILE UNIT OFF CAMPUS");
                break;

                default:
                    System.out.println("INVALID COMMAND");
        }
    }

    public void attributeMatrix(){
        System.out.println(
                "ATTRIBUTE MATRIX:\n" +
                        "humor = 8\n" +
                        "coordination = 10\n" +
                        "aggression = 5\n" +
                        "tenacity = 13\n" +
                        "bulkApperception = <ERROR>\n" +
                        "patience = 5\n" +
                        "charm = <ERROR>"
        );
        System.out.println("=============================\nEnter Command\n");
        InputOutput scan = new InputOutput();
        String command = scan.scanForString();
        attributeTamper(command);
    }

    public void attributeTamper(String command){
        switch (command.toLowerCase()){
            case "bulkapperception":
                System.out.println("OVERRIDE ATTRIBUTE - BULK APPERCEPTION - 20\nTHE MAZE IS OPEN");
                currentPlayer.bulkApperception = true;
                break;
            case "charm":
                System.out.println("OVERRIDE ATTRIBUTE - CHARM - 20\nSMALLTALK SUBROUTINE ACCESS GRANTED");
                currentPlayer.charm = true;
                break;
        }
    }
}
