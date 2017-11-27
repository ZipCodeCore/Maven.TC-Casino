package io.zipcoder.casino;


public class Game {

    private int userInputInt;
    private String userInputString;

    public void chooseGameType() {
        do {

            System.out.println("\n\nThank you for choosing to play a game here at Zip Code Casino." +
                    "\nWe take pride in knowing that our games are everything that you are looking for.\n\n" +
                    "                                                                                                                        \n" +
                    "  ,--.         ,------.          ,--.  ,--.       ,----.                                  ,---.                         \n" +
                    " /    \\        |  .---',--.  ,--.`--',-'  '-.    '  .-./    ,--,--.,--,--,--. ,---.      /  O  \\ ,--.--. ,---.  ,--,--. \n" +
                    "|  ()  |       |  `--,  \\  `'  / ,--.'-.  .-'    |  | .---.' ,-.  ||        || .-. :    |  .-.  ||  .--'| .-. :' ,-.  | \n" +
                    " \\    /.--.    |  `---. /  /.  \\ |  |  |  |      '  '--'  |\\ '-'  ||  |  |  |\\   --.    |  | |  ||  |   \\   --.\\ '-'  | \n" +
                    "  `--' '--'    `------''--'  '--'`--'  `--'       `------'  `--`--'`--`--`--' `----'    `--' `--'`--'    `----' `--`--' \n" +
                    " ,--.         ,-----.                  ,--.     ,----.                                                                  \n" +
                    "/   |        '  .--./ ,--,--.,--.--. ,-|  |    '  .-./    ,--,--.,--,--,--. ,---.                                       \n" +
                    "`|  |        |  |    ' ,-.  ||  .--'' .-. |    |  | .---.' ,-.  ||        || .-. :                                      \n" +
                    " |  |.--.    '  '--'\\\\ '-'  ||  |   \\ `-' |    '  '--'  |\\ '-'  ||  |  |  |\\   --.                                      \n" +
                    " `--''--'     `-----' `--`--'`--'    `---'      `------'  `--`--'`--`--`--' `----'                                      \n" +
                    " ,---.         ,------.  ,--.                  ,----.                                                                   \n" +
                    "'.-.  \\        |  .-.  \\ `--' ,---. ,---.     '  .-./    ,--,--.,--,--,--. ,---.                                        \n" +
                    " .-' .'        |  |  \\  :,--.| .--'| .-. :    |  | .---.' ,-.  ||        || .-. :                                       \n" +
                    "/   '-..--.    |  '--'  /|  |\\ `--.\\   --.    '  '--'  |\\ '-'  ||  |  |  |\\   --.                                       \n" +
                    "'-----''--'    `-------' `--' `---' `----'     `------'  `--`--'`--`--`--' `----'                                       \n" +
                    "                                                                                                                        ");

            userInputInt = Console.getUserInputInteger("\nWhat type of game would you like to play?" +
                    "\nPlease enter 1 for card game or 2 for dice game");

            switch (userInputInt) {
                case 0:
                    break;
                case 1:
                    CardGames cardGames = new CardGames();
                    cardGames.chooseGameType();
                    break;
                case 2:
                    GameInterface gameInterface = new GameInterface();
                 gameInterface.playCraps();
                    break;
                default:
                    System.out.println("You entered an invalid choose :-(\n");
            }

            userInputString = Console.getUserInputString("Would you like to leave the game area?\n" +
                    "Please enter yes or no.");

        } while (userInputString.equalsIgnoreCase("no"));
    }
}
