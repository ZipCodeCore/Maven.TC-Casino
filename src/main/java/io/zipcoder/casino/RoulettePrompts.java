package io.zipcoder.casino;

public class RoulettePrompts {

    public String welcomeMessage(){
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

    public void rules(){
        String rulesPrompt = "************************RULES**********************\n" +
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
                "place bets for the next spin.";
    }

    public int firstSetOfOptionsPrompt(int n){
        String options = "****************** BET #" + n + " ******************\n" +
                "*         Please choose an option          *\n" +
                "*         Each bet is 1 chip ($5)          *\n" +
                "*                                          *\n" +
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
                "********************************************\n";
        return IOHandler.promptForIntWithMessage(options);
    }

    public void bettingInfo(){
        String prompt = "***************** BETTING INFO *********************\n" +
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
                "\t- line bet (6 numbers/2 rows) wins 5 to 1\n";
    }

    public int singleNumberPrompt(){
        String prompt = "***************** SINGLE NUMBER ********************\n" +
                "You selected to bet 1 chip on a single number space. \n" +
                "The payout for this space is 35 to 1 if your \n" +
                "selection is the winning number. \n" +
                "\n" +
                "Please choose a number between 1-36:";
        int numberChoice = IOHandler.promptForIntWithMessage(prompt);
        return numberChoice;
    }

    public Integer[] onTheLine(){
        String prompt = "************* On the line (2 numbers) **************\n" +
                "You selected to bet 1 chip on a two number spaces. \n" +
                "The payout for this space is 17 to 1 if your \n" +
                "selection is the winning number.\n\n" ;
        Integer[] result = new Integer[2];
        for(int i = 0; i < result.length; i++){
            result[i] = IOHandler.promptForIntWithMessage("Please choose a number between 1-36: ");
        }

        return result;
    }

    public Integer[] corner(){
        String prompt = "********************* Corner **********************\n" +
                "You selected to bet 1 chip on a four number spaces.\n" +
                "These 4 spaces are numbers at every side of the \n" +
                "corner you want to select. You will enter the 1st\n" +
                "corner number to enter your decision. For example, \n" +
                "if I wanted to choose the corner that intersects \n" +
                "17, 18, 20, and 21, I would enter the number 17.\n" +
                "The payout for this space is 8 to 1 if your \n" +
                "selection is the winning number.\n\n";
        Integer[] result = new Integer[4];
        int counterForArray = 0;
        int startingNumber = IOHandler.promptForIntWithMessage(prompt);
        for(int i = startingNumber; i <= startingNumber+5; i++){
            if(i != startingNumber+3){
                result[counterForArray] = i;
                counterForArray++;
            }
        }
        return result;
    }

    public Integer[] straight(){
        String prompt = "";
        Integer[] result = {0, 0, 0, 0};
        return result;
    }

    public Integer[] basket(){
        String prompt = "";
        Integer[] result = {0, 00, 2};
        return result;
    }

    public Integer[] fiveNumberBet(){
        String prompt = "";
        Integer[] result = {0, 00, 1, 2, 3};
        return result;
    }

    public Integer[] lineBet(){
        String prompt = "";
        Integer[] result = {0, 0, 0, 0, 0, 0};
        return  result;
    }

    public Integer[] columnBet(){
        String prompt = "";
        Integer[] result = {0,0};
        return result;
    }

    public Integer[] twelveNumberBet(){
        String prompt = "";
        Integer[] result = {0, 0};
        return result;
    }

    public Integer[] numbers1Thru18(){
        String prompt = "";
        Integer[] result = {0, 0};
        return result;
    }

    public Integer[] numbers19thru36(){
        String prompt = "";
        Integer[] result = {0, 0};
        return result;
    }

    public Integer[] evenNumbers(){
        String prompt = "";
        Integer[] result = {0, 0};
        return result;
    }

    public Integer[] oddNumbers(){
        String prompt = "";
        Integer[] result = {0, 0};
        return result;
    }

    public Integer[] blackNumbers(){
        String prompt = "";
        Integer[] result = {0, 0};
        return result;
    }

    public Integer[] redNumbers(){
        String prompt = "";
        Integer[] result = {0, 0};
        return result;
    }
}
