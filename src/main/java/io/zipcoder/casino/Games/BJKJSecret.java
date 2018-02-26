package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.BlackjackPlayer;

public class BJKJSecret {

    boolean bulkApperception = false;
    BlackjackPlayer currentPlayer;

    public void start(BlackjackPlayer player){
        currentPlayer = player;
        password();
        displayMenu();
    }

    public void password(){
        boolean password = false;
        do {
            InputOutput scan = new InputOutput();
            String passwordCrack = scan.promptForString("ENTER PASSWORD");
            if (passwordCrack.toLowerCase().equals("password")){
                password = true;
            }
        } while (password == false);
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
        navigateMain();

    }

    public void navigateMain(){
        boolean passThrough = false;
        do {
            InputOutput scan = new InputOutput();
            String command = scan.scanForString();
        switch (command) {
            case "dialoguetree":
                System.out.println("IS - THIS - A - WESTWORLD - REFERENCE");
                break;
            case "attributematrix":
                System.out.println("OPENING: ATTR MATRIX INTERFACE");
                passThrough = true;
                attributeMatrix();
                break;
            case "scanprotocol":
                System.out.println("ERROR - UNIT UNAVAILABLE FOR DIAGNOSTIC");
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
        } while (passThrough == false);
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

        attributeTamper();
    }

    public void attributeTamper(){
        boolean proc = false;
        do {
            InputOutput scan = new InputOutput();
            String command = scan.scanForString();
        switch (command.toLowerCase()) {
            case "bulkapperception":
                System.out.println("OVERRIDE ATTRIBUTE - BULK APPERCEPTION - 20\nTHE MAZE IS OPEN");
                currentPlayer.bulkApperception = true;
                proc = true;
                break;
            case "charm":
                System.out.println("OVERRIDE ATTRIBUTE - CHARM - 20\nSMALLTALK SUBROUTINE ACCESS GRANTED");
                currentPlayer.charm = true;
                proc = true;
                break;

            default:
                System.out.println("INVALID COMMAND");
                break;
        }
        } while (proc == false);
    }
}
