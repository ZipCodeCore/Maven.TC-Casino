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
                "*        Press 'r' for rules         *\n\n" +
                "* Press 'y' to play/Press 'q' to quit*\n";
        return IOHandler.promptForStringWithMessage(welcomePrompt);
    }

    public void rules(){
        String rulesPrompt = "************************RULES**********************\n" +
                "\n" +
                "Roulette is a game played with a large wheel that \n" +
                "contains either 37 (in European roulette) or 38 (for \n" +
                "American roulette) pockets. These stops are numbered \n" +
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
                "in online casinos, this isn’t necessary.\n" +
                "\n" +
                "Players may continue to place bets until the \n" +
                "croupier puts the ball into the roulette wheel. Even \n" +
                "after the ball is in play, players generally have \n" +
                "the ability to place wagers for a few more seconds \n" +
                "until the croupier calls off all bets.\n" +
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
}
