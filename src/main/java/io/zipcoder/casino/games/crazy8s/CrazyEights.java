//package io.zipcoder.casino.games.crazy8s;
//
//import io.zipcoder.casino.core.Player;
//import io.zipcoder.casino.games.Card;
//import io.zipcoder.casino.games.Deck;
//import io.zipcoder.casino.interfaces.Game;
//import io.zipcoder.casino.utils.IOHandler;
//
//public class CrazyEights implements Game {
//    static Card[] playersHand;
//    static Card[] computer; //card arrays
//    static Card[] matchThisCard;
//    static String answer;
//    static String result;
//    private static int answerInt;
//    boolean isLegal;
//
//
//    public CrazyEights() {
//    }
//
//    @Override
//    public void play(Player player) {
//        runWelcome();
//    }
//
//    @Override
//    public void runWelcome() {
//        do {
//            String intro =
//                    "****** WELCOME TO CRAZY EIGHTS! ******\n" +
//                            "*                                    *\n" +
//                            "*                                    *\n" +
//                            "* This is a non-gambling game so,    *\n" +
//                            "*       Hold on to your chips!!      *\n" +
//                            "*                                    *\n" +
//                            "*                                    *\n" +
//                            "**************************************\n" +
//                            "*                                    *\n" +
//                            "*        Press 'Y' to PLAY           *\n" +
//                            "*        Press 'Q' to QUIT           *\n" +
//                            "*        Press 'R' for RULES         *\n" +
//                            "*                                    *\n" +
//                            "**************************************\n";
//            answer = IOHandler.promptForStringWithMessage(intro);
//            if (answer.equalsIgnoreCase("q")) {
//                continue;
//            } else if (answer.equalsIgnoreCase("r")) {
//                IOHandler.printMessage(IOHandler.getMessageFromFile("Crazy8Rules.txt"));
//            } else
//                beginGame();
//        }
//        while (!answer.equalsIgnoreCase("q"));
//    }
//
//    public void choseStep() {
//
//    }
//
//    public void beginGame() {
//        Deck deck = new Deck(); //get new deck to play with
//        int handSize = 8;
//
//        playersHand = deck.pull(handSize);   //deal playersHand
//        computer = deck.pull(handSize); //and computer's hand
//        matchThisCard = deck.pull(1); //show one card from face down Deck
//
//        while (!emptyHand(1) && !emptyHand(2))
//        //while the playersHand and computers hands aren't empty
//        {
//            displayState();
//            playerPlays();
//
//            displayCardToMatch();
//            computerPlays();
//        }
//        result();
//        runWelcome();
//    }
//
//    public static boolean emptyHand(int whichHand)  //check if any hand is empty (1 = playersHand, 2 = computer)
//    {
//        Card[] hand;
//        if (whichHand == 1)
//            hand = playersHand;
//        else
//            hand = computer;
//        if (hand.length > 0) {
//            return false;
//        }
//        return true;
//    }
//
//    public static String displayPlayerHand() {
//
//        StringBuilder sb = new StringBuilder();
//        for (int i=0;i<playersHand.length;i++) {
//            sb.append(String.format("%2d: ", i));
//            sb.append(playersHand[i].toString());
//            }
//        return sb.toString();
//    }
//
//    public static String displayCardToMatch() {
//
//        StringBuilder sb = new StringBuilder();
//        for (int i=0;i<matchThisCard .length;i++) {
//            sb.append(matchThisCard[i].toString());
//        }
//        return sb.toString();
//    }
//
//    public void displayState() {
//
//        displayPlayerHand();
//        displayCardToMatch();
//
//    }
//
//    public boolean legalCard(Card card) {
//        if ((matchThisCard == card.getSuit()) ||
//                (matchThisCard == card.getRank()) ||
//                (card.getIntValue() == 8)) {
//            isLegal = true;
//        }
//        return false;
//    }
//
//    public static void result() {
//        if (emptyHand(1)) { //playersHand won
//            result = "Congratulations! You are the winner!" +
//                    "\n Play again? [y/n]";
//            answer = IOHandler.promptForStringWithMessage(result);
//        } else if (emptyHand(2)) { //computer won
//            result = "Sorry! You lose!" +
//                    "\n Play again? [y/n]";
//            answer = IOHandler.promptForStringWithMessage(result);
//        } else {
//            result = "Its a TIE!!!" +
//                    "\n Play again? [y/n]";
//            answer = IOHandler.promptForStringWithMessage(result);
//        }
//
//    }
//
//
//    public static void playerPlays() {
//        if (!emptyHand(2)) {
//            //check if there are legal cards to play
//            //if there are:
//            String pickCard = "Pick a card to play: \n";
//            answerInt = IOHandler.promptForIntWithMessage(pickCard);
//            while (playCard < 1 || playCard + 1 > x) {
//                answerInt = IOHandler.promptForIntWithMessage("Invalid number. Enter a card number to play: ");
//            }
//            matchThisCard = playersHand[cards[playCard]];
//            playersHand[cards[playCard]] = 0;
//            if (matchThisCard == 8) { //card is eight, change suit
//                String newSuit =
//                        IOHandler.promptForStringWithMessage("Enter the 1st letter of the suit you want to change to: ");
//
//                if (newSuit.equalsIgnoreCase("S")) {
//                    matchThisCard = "Spades";
//                } else if (newSuit.equalsIgnoreCase("H")) {
//                    matchThisCard = "Hearts";
//                } else if (newSuit.equalsIgnoreCase("D")) {
//                    matchThisCard = "Diamonds";
//                } else if (newSuit.equalsIgnoreCase("C")) {
//                    matchThisCard = "Clubs";
//                }
//            }
//        } else { //no legal cards
//            answerInt = IOHandler.promptForIntWithMessage("You can't play any of your cards. Press 0 to draw a card.");
//            deck.pull();
//            }
//        }
//    }
//
//    public static void computerPlays() {
//        if (!emptyHand(1)) {
//            String computerTurn = "Press ANY KEY to let the computer play.\n";
//            answer = IOHandler.promptForStringWithMessage(computerTurn);
//        }

//            answer.charAt(0);
//            int eight = -1;
//            boolean played = false;
//            for (int i = 0; i < computer.length && !played; i++) {
//                if (computer[i] > 0) {
//                    if (cardLegal(computer[i])) {
//                        if ((computer[i]) % 13 == 8) { //card is eight, save it
//                            eight = i;
//                        } else { //play card
//                            matchThisCard = computer[i];
//                            computer[i] = 0;
//                            played = true;
//                        }
//                    }
//                }
//            }
//            if (!played) {
//                if (eight != -1) { //play the eight
//                    matchThisCard = computer[eight];
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
//                        matchThisCard = 8;
//                    else if (hearts * 3 > spades + diamonds + clubs)
//                        matchThisCard = 21;
//                    else if (diamonds * 3 > spades + hearts + clubs)
//                        matchThisCard = 34;
//                    else if (clubs * 3 > spades + hearts + diamonds)
//                        matchThisCard = 47;
//                } else { //draw card
//                    boolean filled = false;
//                    int i = 0;
//                    drawCard(filled, i, computer);
//                }
//            }
//        }
//        render();
//    }
//
//
//    @Override
//    public void quitGame() {
//    }
//
//    @Override
//    public String getRules() {
//        return null;
//    }
//}


