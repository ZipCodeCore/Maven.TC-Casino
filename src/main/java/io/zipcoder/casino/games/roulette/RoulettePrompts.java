package io.zipcoder.casino.games.roulette;

import io.zipcoder.casino.IOHandler;


public class RoulettePrompts {

    RouletteBoardAndWheel rouletteBoardAndWheel = new RouletteBoardAndWheel();

    public String welcomeMessage() {
        String welcomePrompt = "*** WELCOME TO THE ROULETTE TABLE  ***\n" +
                "* This is the table for high roller  *\n" +
                "* Indulgence here at our casino.     *\n" +
                "* Roulette is a casino game named    *\n" +
                "* after the French word meaning      *\n" +
                "* little wheel. In the game, players *\n" +
                "* may choose to place bets on either *\n" +
                "* a single number, various groupings *\n" +
                "* of numbers, the colors red or      *\n" +
                "* black, whether the number is odd   *\n" +
                "* or even, or if the numbers are     *\n" +
                "* high (19–36) or low (1–18).        *\n" +
                "**************************************\n\n" +
                "*         Press 'y' to play          *\n" +
                "*         Press 'q' to quit          *\n" +
                "*        Press 'r' for rules         *\n" +
                "*     Press 'b' for betting info     *\n\n" +
                "**************************************\n";

        return IOHandler.promptForStringWithMessage(welcomePrompt);
    }

    public void rules() {
        System.out.println("************************RULES**********************\n" +
                "\n" +
                "Roulette is a game played with a large wheel that \n" +
                "contains 38 pockets. These stops are numbered \n" +
                "from 0 to 36, while the American roulette wheel also \n" +
                "contains a 00 pocket. All the pockets are all \n" +
                "colored; the zeroes are green, while the other spots \n" +
                "are evenly divided between 18 red and 18 black \n" +
                "pockets.\n" +
                "\n" +
                "The croupier (or dealer) spins a ball on the outer \n" +
                "rim of the wheel, after which it will eventually \n" +
                "fall into one of the numbered spaces. The object for \n" +
                "the player is to guess what number the ball will \n" +
                "land in.\n" +
                "\n" +
                "Before each spin, players have the opportunity to \n" +
                "place bets around the roulette table. Players can \n" +
                "bet on individual numbers or virtually any \n" +
                "combination of numbers – most of the available bets \n" +
                "are outlined below.\n" +
                "\n" +
                "In a live casino each player will have to exchange \n" +
                "cash or casino chips for special roulette chips, \n" +
                "with each player being given a unique color that can \n" +
                "be used to distinguish who made each bet. Of course, \n" +
                "in computer casino (this one), this isn’t necessary.\n" +
                "\n" +
                "Once the ball falls into a pocket and rests there, \n" +
                "the croupier will call out the winning number as \n" +
                "well as the color of the pocket it landed in. \n" +
                "Markers are typically used to protect winning bets, \n" +
                "after which all losing bets are swept off the table. \n" +
                "Then the croupier will pay all winning bets and, \n" +
                "once all of the payouts are completed, players may \n" +
                "place bets for the next spin.");
    }

    public int firstSetOfOptionsPrompt(int n) {
        String options = "****************** BET #" + n + " ******************\n" +
                "*         Please choose an option          *\n" +
                "*         Each bet is 1 chip ($5)          *\n" +
                "*                                          *\n" +
                "* Betting:                                 *\n" +
                "* 1. Single number                         *\n" +
                "* 2. On the line (2 numbers)               *\n" +
                "* 4. Corner (4 numbers of a corner)        *\n" +
                "* 5. Stright (one row)                     *\n" +
                "* 6. Basket (0, 00, 2)                     *\n" +
                "* 7. 5 number bet (0, 00, 1, 2, 3)         *\n" +
                "* 8. line (6 numbers in 2 rows adjacent)   *\n" +
                "* 9. Column                                *\n" +
                "* 10. 12 number sections (1st, 2nd, 3rd)   *\n" +
                "* 11. Numbers 1-18                         *\n" +
                "* 12. Numbers 19-36                        *\n" +
                "* 13. Even numbers                         *\n" +
                "* 14. Odd numbers                          *\n" +
                "* 15. Black Numbers                        *\n" +
                "* 16. Red Numbers                          *\n" +
                "*                                          *\n" +
                "* Other options:                           *\n" +
                "* 17. Betting info                         *\n" +
                "* 18. FINISH BETTING                       *\n" +
                "********************************************\n";
        return IOHandler.promptForIntWithMessage(options);
    }

    public void bettingInfo() {
        System.out.println("***************** BETTING INFO *********************\n" +
                "- Black, Red, 1-8, 19-36, Odd, and Even spaces payout evenly (1 to 1)\n" +
                "- 1st 12, 2nd 12, and 3rd 12 payout 2 to 1\n" +
                "- column wins pay 2 to 1 as well\n" +
                "- Inside part of board:\n" +
                "\t- single number win pays out 35 to 1\n" +
                "\t- on the line (the two numbers on both sides of the line) wins 17 to 1 \n" +
                "\t- Straight (the whole row of three numbers) wins 11 to 1\n" +
                "\t- Basket (0, 00, and 2) wins 11 to 1\n" +
                "\t- Corner (4 numbers) wins 8 to 1\n" +
                "\t- 5 number bet ( 0, 00, 1, 2, 3) wins 6 to 1\n" +
                "\t- line bet (6 numbers/2 rows) wins 5 to 1\n");
    }

    public int singleNumberPrompt() {
        String prompt = "***************** Single Number ********************\n" +
                "You selected to bet 1 chip on a single number space. \n" +
                "The payout for this bet is 35 to 1 if your \n" +
                "selection is the winning number. \n" +
                "\n" +
                "Please choose a number between 1-36:";
        int numberChoice = IOHandler.promptForIntWithMessage(prompt);
        return numberChoice;
    }

    public Integer[] onTheLine() {
        System.out.println("************* On The Line (2 numbers) **************\n" +
                "You selected to bet 1 chip on two number spaces. \n" +
                "The payout for this bet is 17 to 1 if your \n" +
                "selection is the winning number.\n\n");
        Integer[] result = new Integer[2];
        for (int i = 0; i < result.length; i++) {
            result[i] = IOHandler.promptForIntWithMessage("Please choose a number between 1-36: ");
        }

        return result;
    }

    public Integer[] corner() {
        String prompt = "********************* Corner **********************\n" +
                "You selected to bet 1 chip on four number spaces.\n" +
                "These 4 spaces are numbers at every side of the \n" +
                "corner you want to select. You will enter the 1st\n" +
                "corner number to enter your decision. For example, \n" +
                "if I wanted to choose the corner that intersects \n" +
                "17, 18, 20, and 21, I would enter the number 17.\n" +
                "The payout for this bet is 8 to 1 if your \n" +
                "selection is the winning number.\n\n";
        Integer[] result = new Integer[4];
        int counterForArray = 0;
        int startingNumber = IOHandler.promptForIntWithMessage(prompt);
        for (int i = startingNumber; i <= startingNumber + 5; i++) {
            if (i != startingNumber + 3) {
                result[counterForArray] = i;
                counterForArray++;
            }
        }
        return result;
    }

    public Integer[] straight() {
        String prompt = "********************* Straight *********************\n" +
                "You selected to bet 1 chip on three number spaces.\n" +
                "These 3 spaces are numbers that lie in the same row. You will enter the 1st number in the row to make\n" +
                "your decision For example, if I wanted to choose \n" +
                "the row that contains 4, 5, and 6, I would enter the number 4. If any of those numbers win, the bet is\n" +
                "won. The payout for this bet is 11 to 1 if your \n" +
                "selection is the winning number.\n\n";
        Integer[] result = new Integer[3];
        int startingNumber = IOHandler.promptForIntWithMessage(prompt);
        for (int i = 0; i <= result.length; i++) {
            result[i] = startingNumber + i;
        }
        return result;
    }

    public Integer[] basket() {
        String prompt = "********************* Basket *********************\n" +
                "You selected to bet 1 chip on three number spaces.\n" +
                "These 3 spaces are numbers 0, 00, and 2. The payout \n" +
                "for this bet is 11 to 1 if your selection is the \n" +
                "winning number. Press 'c' to continue and place bet.";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = {0, 00, 2};
            return result;
        }
        return null;
    }

    public Integer[] fiveNumberBet() {
        String prompt = "***************** Five Number Bet *****************\n" +
                "You selected to bet 1 chip on the top five number \n" +
                "spaces.These 3 spaces are numbers 0, 00, 1, 2, and \n" +
                "3. The payout for this bet is 6 to 1 if your \n" +
                "selection is the winning number. Press 'c' to \n" +
                "continue and place bet.";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = {0, 00, 1, 2, 3};
            return result;
        }
        return null;
    }

    public Integer[] lineBet() {
        String prompt = "********************* Line Bet *********************\n" +
                "You selected to bet 1 chip on 6 number spaces. This \n" +
                "selection includes 6 numbers in a 2 row format.\n" +
                "\n" +
                "Visual example:\n" +
                "\t              -   -   -\n" +
                "\t            | 4 | 5 | 6 |\n" +
                "\t              -   -   - \n" +
                "\t            | 7 | 8 | 9 |\n" +
                "\t              -   -   -\n" +
                "\n" +
                "Above is a visual example of your line bet. If you \n" +
                "enter the first number in the line bet (top left \n" +
                "corner, number being 4 in the example), your bet \n" +
                "will include the other 5 numbers. The payout for \n" +
                "this bet is 5 to 1.\n\n";
        Integer[] result = new Integer[6];
        int startingNumber = IOHandler.promptForIntWithMessage(prompt);
        for (int i = 0; i < result.length; i++) {
            result[i] = startingNumber + i;
        }
        return result;
    }

    public Integer[] columnBet() {
        String prompt = "******************** Column Bet ********************\n" +
                "You selected to bet 1 chip on one column of the \n" +
                "board. There are three column on our Roulette board. \n" +
                "When betting on one column, you are betting on every \n" +
                "number in that column. The payout for this bet is 2 \n" +
                "to 1.\n" +
                "\n" +
                "Please enter 1, 2, or 3 for the first column, second \n" +
                "column, or third column respectively:";
        Integer[] result = rouletteBoardAndWheel.columnBetSelection(IOHandler.promptForIntWithMessage(prompt));
        return result;
    }

    public Integer[] twelveNumberBet() {
        String prompt = "******************** Column Bet ********************\n" +
                "You selected to bet 1 chip on twelve number spaces.  \n" +
                "You are able to bet on bulk options that include the \n" +
                "first twelve numbers on the board, second twelve, or \n" +
                "third twelve. The payout for this bet is 2 to 1.\n" +
                "\n" +
                "Please enter 1, 2, or 3 for the first 12, second \n" +
                "12, or third 12 respectivly:";
        Integer[] result = rouletteBoardAndWheel.twelveNumberBet(IOHandler.promptForIntWithMessage(prompt));
        return result;
    }

    public Integer[] numbers1Thru18() {
        String prompt = "********************* 1-18 Bet *********************\n" +
                "You selected to bet 1 chip on numbers 1-18. The \n" +
                "payout for this bet is 1 to 1. Please press 'c' to \n" +
                "continue./n";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = new Integer[18];
            for (int i = 1; i <= result.length; i++) {
                result[i - 1] = i;
            }
            return result;
        }
        return null;
    }

    public Integer[] numbers19thru36() {
        String prompt = "******************** 19-36 Bet *********************\n" +
                "You selected to bet 1 chip on numbers 19-36. The \n" +
                "payout for this bet is 1 to 1. Please press 'c' to \n" +
                "continue.\n";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = new Integer[18];
            int startingNumber = 19;
            for (int i = 0; i < result.length; i++) {
                result[i] = startingNumber + i;
            }
            return result;
        }
        return null;
    }

    public Integer[] evenNumbers() {
        String prompt = "******************* Even Numbers *******************\n" +
                "You selected to bet 1 chip on numbers all even \n" +
                "numbers on the board. The payout for this bet is 1 \n" +
                "to 1. Please press 'c' to continue.\n";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = rouletteBoardAndWheel.evenNumberSet();
            return result;
        }
        return null;
    }

    public Integer[] oddNumbers() {
        String prompt = "******************** Odd Numbers *******************\n" +
                "You selected to bet 1 chip on numbers all odd \n" +
                "numbers on the board. The payout for this bet is 1 \n" +
                "to 1. Please press 'c' to continue.\n";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = rouletteBoardAndWheel.oddNumberSet();
            return result;
        }
        return null;
    }

    public Integer[] blackNumbers() {
        String prompt = "******************* Black Numbers ******************\n" +
                "You selected to bet 1 chip on numbers all black colored \nnumbers on the board. " +
                "The payout for this bet is 1 to 1. \n" +
                "\n" +
                "Black numbers: \n" +
                "{2, 4, 6, 8, 10, 11,\n" +
                "13, 15, 17, 20, 22, 24,\n" +
                "26, 28, 29, 31, 33, 35}\n" +
                "\n" +
                "Please press 'c' to continue.\n";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = rouletteBoardAndWheel.blackNumberSet();
            return result;
        }
        return null;
    }

    public Integer[] redNumbers() {
        String prompt = "******************** Red Numbers *******************\n" +
                "You selected to bet 1 chip on numbers all red colored \nnumbers on the board. " +
                "The payout for this bet is 1 to 1. \n" +
                "\n" +
                "Red numbers: \n" +
                "{1, 3, 5, 7, 9, 12,\n" +
                "14, 16, 18, 19, 21, 23,\n" +
                "25, 27, 30, 32, 34, 36}\n" +
                "\n" +
                "Please press 'c' to continue.\n";
        String goOnAhead = IOHandler.promptForStringWithMessage(prompt);
        if (goOnAhead.equals("c")) {
            Integer[] result = rouletteBoardAndWheel.redNumberSet();
            return result;
        }
        return null;
    }
}
