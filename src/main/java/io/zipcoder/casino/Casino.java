package io.zipcoder.casino;


public class Casino {

    public static void main(String[] args) {
        System.out.println("                                                                                                    \n" +
                ",-------.,--.            ,-----.          ,--.            ,-----.               ,--.                \n" +
                "`--.   / `--' ,---.     '  .--./ ,---.  ,-|  | ,---.     '  .--./ ,--,--. ,---. `--',--,--,  ,---.  \n" +
                "  /   /  ,--.| .-. |    |  |    | .-. |' .-. || .-. :    |  |    ' ,-.  |(  .-' ,--.|      \\| .-. | \n" +
                " /   `--.|  || '-' '    '  '--'\\' '-' '\\ `-' |\\   --.    '  '--'\\\\ '-'  |.-'  `)|  ||  ||  |' '-' ' \n" +
                "`-------'`--'|  |-'      `-----' `---'  `---'  `----'     `-----' `--`--'`----' `--'`--''--' `---'  \n" +
                "             `--'                                                                                   ");

        String userYesOrNo;

        do{
            System.out.println("Welcome to Zip Code Casino." +
                    "\nYou are going to have lots of fun while you are here.");
            userYesOrNo = Console.getUserInputString("Would you like to play a casino game?" +
                    "\nPlease enter yes or no");

            if(userYesOrNo.equalsIgnoreCase("yes")){
                Game game = new Game();
                game.chooseGameType();
            }else if(userYesOrNo.equalsIgnoreCase("no")){
                System.out.println("We currently only have games inside Zip Code Casino." +
                        "\nI'm sorry if there is nothing else to do.");
            }

            userYesOrNo = Console.getUserInputString("Would you like to leave Zip Code Casino?");
        } while(!(userYesOrNo.equalsIgnoreCase("yes")));

        System.out.println("                                                                                                             \n" +
                "                ,--------.,--.                     ,--.        ,--.   ,--.                                   \n" +
                "                '--.  .--'|  ,---.  ,--,--.,--,--, |  |,-.      \\  `.'  /,---. ,--.,--.                      \n" +
                "                   |  |   |  .-.  |' ,-.  ||      \\|     /       '.    /| .-. ||  ||  |                      \n" +
                "                   |  |   |  | |  |\\ '-'  ||  ||  ||  \\  \\         |  | ' '-' ''  ''  '                      \n" +
                "                   `--'   `--' `--' `--`--'`--''--'`--'`--'        `--'  `---'  `----'                       \n" +
                ",--.  ,--.                                        ,--.  ,--.,--.                 ,------.                    \n" +
                "|  '--'  | ,--,--.,--.  ,--.,---.      ,--,--.    |  ,'.|  |`--' ,---. ,---.     |  .-.  \\  ,--,--.,--. ,--. \n" +
                "|  .--.  |' ,-.  | \\  `'  /| .-. :    ' ,-.  |    |  |' '  |,--.| .--'| .-. :    |  |  \\  :' ,-.  | \\  '  /  \n" +
                "|  |  |  |\\ '-'  |  \\    / \\   --.    \\ '-'  |    |  | `   ||  |\\ `--.\\   --.    |  '--'  /\\ '-'  |  \\   '   \n" +
                "`--'  `--' `--`--'   `--'   `----'     `--`--'    `--'  `--'`--' `---' `----'    `-------'  `--`--'.-'  /    \n" +
                "                                                                                                   `---'     ");
    }
}

