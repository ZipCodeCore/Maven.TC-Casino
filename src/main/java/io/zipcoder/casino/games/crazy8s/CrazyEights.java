package io.zipcoder.casino.games.crazy8s;
import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

public class CrazyEights implements Game {
    static Card[] player;
    static Card[] computer; //card arrays
    static Card[] facedownDeck;
    static String answer;
    static String result;
    private static int answerInt;
    boolean isLegal;


    public CrazyEights() {
    }

    @Override
    public void play(Player player) {
        runWelcome();
    }

    @Override
    public void runWelcome() {
        do {
            String intro =
                    "****** WELCOME TO CRAZY EIGHTS! ******\n" +
                            "*                                    *\n" +
                            "*                                    *\n" +
                            "* This is a non-gambling game so,    *\n" +
                            "*       Hold on to your chips!!      *\n" +
                            "*                                    *\n" +
                            "*                                    *\n" +
                            "**************************************\n" +
                            "*                                    *\n" +
                            "*        Press 'Y' to PLAY           *\n" +
                            "*        Press 'Q' to QUIT           *\n" +
                            "*        Press 'R' for RULES         *\n" +
                            "*                                    *\n" +
                            "**************************************\n";
            answer = IOHandler.promptForStringWithMessage(intro);
            if (answer.equalsIgnoreCase("q")) {
                continue;
            }else if (answer.equalsIgnoreCase("r")) {
                IOHandler.printMessage(IOHandler.getMessageFromFile("CrazyEights.txt"));
            }else
                beginGame();
        }
        while (!answer.equalsIgnoreCase("q"));
    }

    public void beginGame() {
        Deck deck = new Deck(); //get new deck to play with
        int handSize = 8;

        player = deck.pull(handSize);   //deal player
        computer = deck.pull(handSize); //and computer's hand
        facedownDeck = deck.pull(1); //show one card from face down Deck

        while (!emptyHand(1) && !emptyHand(2))
        //while the player and computers hands aren't empty
        {
            displayState();
            playerPlays();

            displayCard();
            computerPlays();
        }
        result();
        runWelcome();
    }

    public static boolean emptyHand(int whichHand)  //check if any hand is empty (1 = player, 2 = computer)
    {
        Card[] hand;
        if (whichHand == 1)
            hand = player;
        else
            hand = computer;
        if(hand.length > 0) {
            return false;
        }
        return true;
    }

    public String displayPlayerHand() {
    String playerHandDisplay = "";
        for (Card card : player) {
        playerHandDisplay += card.toString() + " ";
    }
        return playerHandDisplay;
}

    public String displayCard() {
        String displayCard = "";
        for (Card card : facedownDeck) {
            displayCard += card.toString() + " ";
        }
        return displayCard;
    }
    public void displayState() {
        displayPlayerHand();
        displayCard();
    }
    public boolean legalCard(Card card) {
        if ((card.getSuit() == card.getSuit(facedownDeck)) ||
                (card.getRank() == card.getRank(facedownDeck)) ||
                (card.getIntValue() == 8)) {
            isLegal = true;
        }
        return false;
    }

    public static void result() {
        if (emptyHand(1)) { //player won
            result = "Congratulations! You are the winner!" +
                    "\n Play again? [y/n]";
            answer = IOHandler.promptForStringWithMessage(result);
        } else if (emptyHand(2)) { //computer won
            result = "Sorry! You lose!" +
                    "\n Play again? [y/n]";
            answer = IOHandler.promptForStringWithMessage(result);
        } else {
            result = "Its a TIE!!!" +
                    "\n Play again? [y/n]";
            answer = IOHandler.promptForStringWithMessage(result);
        }

    }


    public static void playerPlays() {
        if (!emptyHand(2)) {
            //check if there are legal cards to play
            //if there are:
            String pickCard = "Pick a card to play: \n";
            answerInt = IOHandler.promptForIntWithMessage(pickCard);
//            while (playCard < 1 || playCard + 1 > x) {
//                answerInt = IOHandler.promptForIntWithMessage("Invalid number. Enter a card number to play: ");
//            }
//            facedownDeck = player[cards[playCard]];
//            player[cards[playCard]] = 0;
//            if (facedownDeck == 8) { //card is eight, change suit
//                String newSuit =
//                        IOHandler.promptForStringWithMessage("Enter the 1st letter of the suit you want to change to: ");
//
//                if (newSuit.equalsIgnoreCase("S")) {
//                    facedownDeck = "Spades";
//                } else if (newSuit.equalsIgnoreCase("H")) {
//                    facedownDeck = "Hearts";
//                } else if (newSuit.equalsIgnoreCase("D")) {
//                    facedownDeck = "Diamonds";
//                } else if (newSuit.equalsIgnoreCase("C")) {
//                    facedownDeck = "Clubs";
//                }
//            }
//        } else { //no legal cards
//            answerInt = IOHandler.promptForIntWithMessage("You can't play any of your cards. Press 0 to draw a card.");
//            deck.pull();
//            }
        }
    }

    public static void computerPlays() {
        if (!emptyHand(1)) {
            String computerTurn = "Press ANY KEY to let the computer play.\n";
            answer = IOHandler.promptForStringWithMessage(computerTurn);
        }

//            answer.charAt(0);
//            int eight = -1;
//            boolean played = false;
//            for (int i = 0; i < computer.length && !played; i++) {
//                if (computer[i] > 0) {
//                    if (cardLegal(computer[i])) {
//                        if ((computer[i]) % 13 == 8) { //card is eight, save it
//                            eight = i;
//                        } else { //play card
//                            facedownDeck = computer[i];
//                            computer[i] = 0;
//                            played = true;
//                        }
//                    }
//                }
//            }
//            if (!played) {
//                if (eight != -1) { //play the eight
//                    facedownDeck = computer[eight];
//                    computer[eight] = 0;
//                    //change suit to dominant hand suit
//
//                    int spades = 0;
//                    int hearts = 0;
//                    int diamonds = 0;
//                    int clubs = 0;
//
//                    for (int i = 0; i < computer.length; i++) {
//                        if (computer[i] > 0) {
//                            int suitType = (computer[i]) / 13;
//                            if (suitType == 0) // spades
//                                spades++;
//                            else if (suitType == 1) // hearts
//                                hearts++;
//                            else if (suitType == 2) // diamonds
//                                diamonds++;
//                            else if (suitType == 3) // clubs
//                                clubs++;
//                        }
//                    }
//                    if (spades * 3 > hearts + diamonds + clubs)
//                        facedownDeck = 8;
//                    else if (hearts * 3 > spades + diamonds + clubs)
//                        facedownDeck = 21;
//                    else if (diamonds * 3 > spades + hearts + clubs)
//                        facedownDeck = 34;
//                    else if (clubs * 3 > spades + hearts + diamonds)
//                        facedownDeck = 47;
//                } else { //draw card
//                    boolean filled = false;
//                    int i = 0;
//                    drawCard(filled, i, computer);
//                }
//            }
//        }
//        render();
        }


    @Override
    public void quitGame() {
    }

    @Override
    public String getRules() {
        return null;
    }
}


