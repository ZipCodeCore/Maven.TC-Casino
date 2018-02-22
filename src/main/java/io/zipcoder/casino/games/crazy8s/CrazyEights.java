package io.zipcoder.casino;

public class CrazyEights {
    static int[] deck, player, computer; //card arrays
    static int discardPile;
    static int suit;
    static boolean deckEmpty;
    static String answer;
    static String result;
    static int answerInt;


    public static void main(String[] args) {
        intro();
    }

    public static void intro() {
        String intro = "Welcome to Crazy Eights!\n" +
                "Press ANY KEY to start the game.\n";
        answer = IOHandler.promptForStringWithMessage(intro);
        if(!answer.equalsIgnoreCase( null)) {
            beginGame();
        }
    }

    public static int[] makeHand()  //deals top 8 cards of deck to hand
    {
        int[] hand = new int[52];
        for (int i = 0; i < 8; i++) {
            hand[i] = getCard();
        }
        return hand;
    }

    public static int getCard()  //retrieves top card from deck
    {
        int i = 0, value = 0;
        while (i < deck.length && deck[i] == 0)
            i++;
        if (deck.length > i) {
            value = deck[i];
            deck[i] = 0;
        }
        return value;
    }

    public static void beginGame() {
        new Deck(); //get new deck to play with
        player = makeH and();   //deal player
        computer = makeHand(); //and computer's hand
        discardPile = getCard(); //add one card to discard pile
        while (!emptyHand(1) && !emptyHand(2) && !deckEmpty)
        //while the player and computers hands aren't empty and the deck is not empty
        {
            playerPlays();
            computerPlays();
        }
        result();
    }

    public static void result(){
        if (emptyHand (1))
        { //player won
            result = "Congratulations! You are the winner!" +
                    "\n Play again? [y/n]";
            answer = IOHandler.promptForStringWithMessage(result);
        }
        else if (emptyHand (2))
        { //computer won
            result = "Sorry! You lose!" +
                    "\n Play again? [y/n]";
            answer = IOHandler.promptForStringWithMessage(result);
        }
        else
        {
            result = "Its a TIE!!!" +
                    "\n Play again? [y/n]";
            answer = IOHandler.promptForStringWithMessage(result);
        }
    }

    public static boolean emptyHand (int whichHand)  //check if any hand is empty (1 = player, 2 = computer)
    {
        int[] hand;
        if (whichHand == 1)
            hand = player;
        else
            hand = computer;
        for (int x = 0 ; x < hand.length ; x++)
        {
            if (hand [x] > 0)
                return false;
        }
        return true;
    }

    public static void playerPlays ()
    {
        //check hand for legal cards, label them
        int x = 1, y = 0;
        int[] cards = new int [52];
        for (int i = 0 ; i < player.length ; i++)
        {
            if (player [i] > 0)
            {
                if (cardLegal (player [i]))
                {
                    cards [x] = i;
                    x++;
                }
                y++;
            }
        }
        if (x > 1)
        { //has legal cards

            int playCard = IOHandler.promptForIntWithMessage("Enter a card number to play: ");
            while (playCard < 1 || playCard + 1 > x)
            {
                answerInt = IOHandler.promptForIntWithMessage("Invalid number. Enter a card number to play: ");
            }
            discardPile = player [cards [playCard]];
            player [cards [playCard]] = 0;
            if ((discardPile) % 13 == 8)
            { //card is eight, change suit
                String newSuit=
                        IOHandler.promptForStringWithMessage("Enter the 1st letter of the suit you want to change to: ");

                if (newSuit.equalsIgnoreCase ("S"))
                {
                    discardPile = 8;
                }
                else if (newSuit.equalsIgnoreCase ("H"))
                {
                    discardPile = 21;
                }
                else if (newSuit.equalsIgnoreCase ("D"))
                {
                    discardPile = 34;
                }
                else if (newSuit.equalsIgnoreCase ("C"))
                {
                    discardPile = 47;
                }
            }
        }
        else
        { //no legal cards
            answerInt = IOHandler.promptForIntWithMessage("You can't play any of your cards. Press 0 to draw a card.");

            boolean filled = false;
            int i = 0;
            drawCard(filled, i, player);
        }
        render ();
    }

    public static void computerPlays ()
    {
        if (!emptyHand (1))
        {
            String computerTurn = "Press ANY KEY to let the computer play.\n";
            answer = IOHandler.promptForStringWithMessage(computerTurn);

            answer.charAt(0);
            int eight = -1;
            boolean played = false;
            for (int i = 0 ; i < computer.length && !played ; i++)
            {
                if (computer [i] > 0)
                {
                    if (cardLegal (computer [i]))
                    {
                        if ((computer [i]) % 13 == 8)
                        { //card is eight, save it
                            eight = i;
                        }
                        else
                        { //play card
                            discardPile = computer [i];
                            computer [i] = 0;
                            played = true;
                        }
                    }
                }
            }
            if (!played)
            {
                if (eight != -1)
                { //play the eight
                    discardPile = computer [eight];
                    computer [eight] = 0;
                    //change suit to dominant hand suit

                    int spades = 0;
                    int hearts = 0;
                    int diamonds = 0;
                    int clubs = 0;

                    for (int i = 0 ; i < computer.length ; i++)
                    {
                        if (computer [i] > 0)
                        {
                            int suitType = (computer [i]) / 13;
                            if (suitType == 0) // spades
                                spades++;
                            else if (suitType == 1) // hearts
                                hearts++;
                            else if (suitType == 2) // diamonds
                                diamonds++;
                            else if (suitType == 3) // clubs
                                clubs++;
                        }
                    }
                    if (spades * 3 > hearts + diamonds + clubs)
                        discardPile = 8;
                    else if (hearts * 3 > spades + diamonds + clubs)
                        discardPile = 21;
                    else if (diamonds * 3 > spades + hearts + clubs)
                        discardPile = 34;
                    else if (clubs * 3 > spades + hearts + diamonds)
                        discardPile = 47;
                }
                else
                { //draw card
                    boolean filled = false;
                    int i = 0;
                    drawCard(filled, i, computer);
                }
            }
        }
        render ();
    }

    private static void drawCard(boolean filled, int i, int[] computer) {
        while (!filled && i < computer.length)
        {
            if (computer[i] == 0)
            {
                computer[i] = getCard ();
                if (computer[i] == 0)
                {
                    deckEmpty = true;
                }
                filled = true;
            }
            i++;
        }
    }


    public static boolean cardLegal (int card)  //check whether card matches suit, rank of pile or is eight
    {
        if ((card) % 13 == 8)
        { //card is 8
            return true;
        }
        else if ((card) / 13 == (discardPile) / 13)
        { //card matches suit
            return true;
        }
        else if ((card) % 13 == (discardPile) % 13)
        { //card matches rank
            return true;
        }
        return false;
    }

    public static String shownValue (int card)  // convert card rank to shown rank
    {
        int val = card % 13;
        if (val == 0)
            return "A";
        else if (val <= 9)
            return "" + val;
        else if (val == 10)
            return "J";
        else if (val == 11)
            return "Q";
        else if (val == 12)
            return "K";
        return "X";
    }

    public static String shownSuit (int card)  // convert suit 1-4 to SHDC
    {
        int suitnum = card / 13;
        if (suitnum == 0) // spades
            return "\u2660";
        else if (suitnum == 1) // hearts
            return "\u2665";
        else if (suitnum == 2) // diamonds
            return "\u2666";
        else if (suitnum == 3) // clubsm
            return "\u2663";
        return "X";
    }

    public static void drawCard (int value, int x, int y, boolean hidden)
    {
        String rank = shownValue (value);
        String suit = shownSuit (value);
    }




    public static void render ()
    {
        int x = 0;
        for (int i = 0 ; i < computer.length ; i++)
        { //computer's hand
            if (computer [i] != 0)
            {
                drawCard (computer [i], 670 - x * 40, 30, true);
                x++;
            }
        }
        x = 0;
        for (int i = 0 ; i < player.length ; i++)
        { //player's hand
            if (player [i] != 0)
            {
                drawCard (player [i], 30 + x * 40, 400, false);
                x++;
            }
        }
        //discard pile
        drawCard (discardPile, 350, 215, false);

    }
}

