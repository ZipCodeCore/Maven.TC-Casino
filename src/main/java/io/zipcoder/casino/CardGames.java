package io.zipcoder.casino;

public class CardGames extends Game {

    private int userInputInt;
    private String userInputString;

    public void chooseGameType() {
        do {

            System.out.println("                                                                                                                                                          \n" +
                    "  ,--.         ,------.          ,--.  ,--.       ,-----.                  ,--.     ,----.                                  ,---.                         \n" +
                    " /    \\        |  .---',--.  ,--.`--',-'  '-.    '  .--./ ,--,--.,--.--. ,-|  |    '  .-./    ,--,--.,--,--,--. ,---.      /  O  \\ ,--.--. ,---.  ,--,--. \n" +
                    "|  ()  |       |  `--,  \\  `'  / ,--.'-.  .-'    |  |    ' ,-.  ||  .--'' .-. |    |  | .---.' ,-.  ||        || .-. :    |  .-.  ||  .--'| .-. :' ,-.  | \n" +
                    " \\    /.--.    |  `---. /  /.  \\ |  |  |  |      '  '--'\\\\ '-'  ||  |   \\ `-' |    '  '--'  |\\ '-'  ||  |  |  |\\   --.    |  | |  ||  |   \\   --.\\ '-'  | \n" +
                    "  `--' '--'    `------''--'  '--'`--'  `--'       `-----' `--`--'`--'    `---'      `------'  `--`--'`--`--`--' `----'    `--' `--'`--'    `----' `--`--' \n" +
                    " ,--.         ,----.              ,------.,--.       ,--.                                                                                                 \n" +
                    "/   |        '  .-./    ,---.     |  .---'`--' ,---. |  ,---.                                                                                             \n" +
                    "`|  |        |  | .---.| .-. |    |  `--, ,--.(  .-' |  .-.  |                                                                                            \n" +
                    " |  |.--.    '  '--'  |' '-' '    |  |`   |  |.-'  `)|  | |  |                                                                                            \n" +
                    " `--''--'     `------'  `---'     `--'    `--'`----' `--' `--'                                                                                            \n" +
                    " ,---.         ,-----.  ,--.              ,--.        ,--.              ,--.                                                                              \n" +
                    "'.-.  \\        |  |) /_ |  | ,--,--. ,---.|  |,-.     |  | ,--,--. ,---.|  |,-.                                                                           \n" +
                    " .-' .'        |  .-.  \\|  |' ,-.  || .--'|     /,--. |  |' ,-.  || .--'|     /                                                                           \n" +
                    "/   '-..--.    |  '--' /|  |\\ '-'  |\\ `--.|  \\  \\|  '-'  /\\ '-'  |\\ `--.|  \\  \\                                                                           \n" +
                    "'-----''--'    `------' `--' `--`--' `---'`--'`--'`-----'  `--`--' `---'`--'`--'                                                                          \n" +
                    "                                                                                                                                                          ");

            System.out.println("Thank you for choosing to play a card game.");
            userInputInt = Console.getUserInputInteger("What type of card game would you like to play?" +
                    "\nPlease enter 1 for go fish and 2 for black jack.");

            switch (userInputInt) {
                case 0:
                    break;
                case 1:
                    GameInterface.playGoFish();
                    break;
                case 2:
                    GameInterface.playBlackjack();
                    break;
                default:
                    System.out.println("You entered an invalid response :-(\n");
            }

            userInputString = Console.getUserInputString("Would you like to leave the the card game area?" +
                    "\nPlease enter yes or no.");
        } while (userInputString.equalsIgnoreCase("no"));

        Game game = new Game();
        game.chooseGameType();
    }

}

