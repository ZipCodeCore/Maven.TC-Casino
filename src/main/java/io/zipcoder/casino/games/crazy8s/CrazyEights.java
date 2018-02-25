////package io.zipcoder.casino.games.crazy8s;
////
////import io.zipcoder.casino.core.Player;
////import io.zipcoder.casino.games.Card;
////import io.zipcoder.casino.games.Deck;
////import io.zipcoder.casino.interfaces.Game;
////import io.zipcoder.casino.utils.IOHandler;
////
////public class CrazyEights implements Game {
////    static Card[] playersHand;
////    static Card[] computer; //card arrays
////    static Card[] matchThisCard;
////    static String answer;
////    static String result;
////    private static int answerInt;
////    boolean isLegal;
////
////
////    public CrazyEights() {
////    }
////
////    @Override
////    public void play(Player player) {
////        runWelcome();
////    }
////
////    @Override
////    public void runWelcome() {
////        do {
////            String intro =
////                    "****** WELCOME TO CRAZY EIGHTS! ******\n" +
////                            "*                                    *\n" +
////                            "*                                    *\n" +
////                            "* This is a non-gambling game so,    *\n" +
////                            "*       Hold on to your chips!!      *\n" +
////                            "*                                    *\n" +
////                            "*                                    *\n" +
////                            "**************************************\n" +
////                            "*                                    *\n" +
////                            "*        Press 'Y' to PLAY           *\n" +
////                            "*        Press 'Q' to QUIT           *\n" +
////                            "*        Press 'R' for RULES         *\n" +
////                            "*                                    *\n" +
////                            "**************************************\n";
////            answer = IOHandler.promptForStringWithMessage(intro);
////            if (answer.equalsIgnoreCase("q")) {
////                continue;
////            } else if (answer.equalsIgnoreCase("r")) {
////                IOHandler.printMessage(IOHandler.getMessageFromFile("Crazy8Rules.txt"));
////            } else
////                beginGame();
////        }
////        while (!answer.equalsIgnoreCase("q"));
////    }
////
////    public void choseStep() {
////
////    }
////
////    public void beginGame() {
////        Deck deck = new Deck(); //get new deck to play with
////        int handSize = 8;
////
////        playersHand = deck.pull(handSize);   //deal playersHand
////        computer = deck.pull(handSize); //and computer's hand
////        matchThisCard = deck.pull(1); //show one card from face down Deck
////
////        while (!emptyHand(1) && !emptyHand(2))
////        //while the playersHand and computers hands aren't empty
////        {
////            displayState();
////            playerPlays();
////
////            displayCardToMatch();
////            computerPlays();
////        }
////        result();
////        runWelcome();
////    }
////
////    public static boolean emptyHand(int whichHand)  //check if any hand is empty (1 = playersHand, 2 = computer)
////    {
////        Card[] hand;
////        if (whichHand == 1)
////            hand = playersHand;
////        else
////            hand = computer;
////        if (hand.length > 0) {
////            return false;
////        }
////        return true;
////    }
////
////    public static String displayPlayerHand() {
////
////        StringBuilder sb = new StringBuilder();
////        for (int i=0;i<playersHand.length;i++) {
////            sb.append(String.format("%2d: ", i));
////            sb.append(playersHand[i].toString());
//package io.zipcoder.casino.games.crazy8s;
//
//import io.zipcoder.casino.core.Player;
//import io.zipcoder.casino.games.Card;
//import io.zipcoder.casino.games.Deck;
//import io.zipcoder.casino.interfaces.Game;
//import io.zipcoder.casino.utils.IOHandler;
//
//public class CrazyEights implements Game {
//    static int[] deck;
//    static Card[] player;
//    static Card[] computer; //card arrays
//    static int facedownDeck;
//    static int suit;
//    static boolean deckEmpty;
//    static String answer;
//    static String result;
//    static int answerInt;
//    private static boolean isPlaying;
//
//
//    public CrazyEights() {
//
//    }
//
//    public static int getCard()  //retrieves top card from deck
//    {
////        int i = 0, value = 0;
////        while (i < deck.length && deck[i] == 0)
////            i++;
////        if (deck.length > i) {
////            value = deck[i];
////            deck[i] = 0;
////        }
////        return value;
//        return 0;
//    }
//
//    public static void result() {
//        if (emptyHand(1)) { //player won
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
//    }
//
//    public static boolean emptyHand(int whichHand)  //check if any hand is empty (1 = player, 2 = computer)
//    {
//        Card[] hand;
//        if (whichHand == 1) {
//            hand = player;
//
//        } else
//            hand = computer;
//
//        if (hand.length > 0)
//            return false;
//        else
//            return true;
//    }
//
//    public static void playerPlays() {
//        //check hand for legal cards, label them
////        int x = 1, y = 0;
////        int[] cards = new int[52];
////        for (int i = 0; i < player.length; i++) {
////            if (player[i] > 0) {
////                if (cardLegal(player[i])) {
////                    cards[x] = i;
////                    x++;
////                }
////                y++;
////            }
////        return sb.toString();
////    }
////
////    public static String displayCardToMatch() {
////
////        StringBuilder sb = new StringBuilder();
////        for (int i=0;i<matchThisCard .length;i++) {
////            sb.append(matchThisCard[i].toString());
////        }
////        return sb.toString();
////    }
////
////    public void displayState() {
////
////        displayPlayerHand();
////        displayCardToMatch();
////
////    }
////
////    public boolean legalCard(Card card) {
////        if ((matchThisCard == card.getSuit()) ||
////                (matchThisCard == card.getRank()) ||
////                (card.getIntValue() == 8)) {
////            isLegal = true;
////        }
////        return false;
////    }
////
////    public static void result() {
////        if (emptyHand(1)) { //playersHand won
////            result = "Congratulations! You are the winner!" +
////                    "\n Play again? [y/n]";
////            answer = IOHandler.promptForStringWithMessage(result);
////        } else if (emptyHand(2)) { //computer won
////            result = "Sorry! You lose!" +
////                    "\n Play again? [y/n]";
////            answer = IOHandler.promptForStringWithMessage(result);
////        } else {
////            result = "Its a TIE!!!" +
////                    "\n Play again? [y/n]";
////            answer = IOHandler.promptForStringWithMessage(result);
////        }
////
////    }
////
////
////    public static void playerPlays() {
////        if (!emptyHand(2)) {
////            //check if there are legal cards to play
////            //if there are:
////            String pickCard = "Pick a card to play: \n";
////            answerInt = IOHandler.promptForIntWithMessage(pickCard);
////            while (playCard < 1 || playCard + 1 > x) {
////                answerInt = IOHandler.promptForIntWithMessage("Invalid number. Enter a card number to play: ");
////            }
////            matchThisCard = playersHand[cards[playCard]];
////            playersHand[cards[playCard]] = 0;
////            if (matchThisCard == 8) { //card is eight, change suit
////                String newSuit =
////                        IOHandler.promptForStringWithMessage("Enter the 1st letter of the suit you want to change to: ");
////
////                if (newSuit.equalsIgnoreCase("S")) {
////                    matchThisCard = "Spades";
////                } else if (newSuit.equalsIgnoreCase("H")) {
////                    matchThisCard = "Hearts";
////                } else if (newSuit.equalsIgnoreCase("D")) {
////                    matchThisCard = "Diamonds";
////                } else if (newSuit.equalsIgnoreCase("C")) {
////                    matchThisCard = "Clubs";
////                }
////            }
////        } else { //no legal cards
////            answerInt = IOHandler.promptForIntWithMessage("You can't play any of your cards. Press 0 to draw a card.");
////            deck.pull();
////            }
////        }
////    }
////
////    public static void computerPlays() {
////        if (!emptyHand(1)) {
////            String computerTurn = "Press ANY KEY to let the computer play.\n";
////            answer = IOHandler.promptForStringWithMessage(computerTurn);
////        }
//
////            answer.charAt(0);
////            int eight = -1;
////            boolean played = false;
////            for (int i = 0; i < computer.length && !played; i++) {
////                if (computer[i] > 0) {
////                    if (cardLegal(computer[i])) {
////                        if ((computer[i]) % 13 == 8) { //card is eight, save it
////                            eight = i;
////                        } else { //play card
////                            matchThisCard = computer[i];
////                            computer[i] = 0;
////                            played = true;
////                        }
////                    }
////                }
////            }
////            if (!played) {
////                if (eight != -1) { //play the eight
////                    matchThisCard = computer[eight];
////                    computer[eight] = 0;
////                    //change suit to dominant hand suit
////
////                    int spades = 0;
////                    int hearts = 0;
////                    int diamonds = 0;
////                    int clubs = 0;
////
////                    for (int i = 0; i < computer.length; i++) {
////                        if (computer[i] > 0) {
////                            int suitType = (computer[i]) / 13;
////                            if (suitType == 0) // spades
////                                spades++;
////                            else if (suitType == 1) // hearts
////                                hearts++;
////                            else if (suitType == 2) // diamonds
////                                diamonds++;
////                            else if (suitType == 3) // clubs
////                                clubs++;
////                        }
////                    }
////                    if (spades * 3 > hearts + diamonds + clubs)
////                        matchThisCard = 8;
////                    else if (hearts * 3 > spades + diamonds + clubs)
////                        matchThisCard = 21;
////                    else if (diamonds * 3 > spades + hearts + clubs)
////                        matchThisCard = 34;
////                    else if (clubs * 3 > spades + hearts + diamonds)
////                        matchThisCard = 47;
////                } else { //draw card
////                    boolean filled = false;
////                    int i = 0;
////                    drawCard(filled, i, computer);
////                }
////            }
////        }
////        render();
////    }
////
////
////    @Override
////    public void quitGame() {
////    }
////
////    @Override
////    public String getRules() {
////        return null;
////    }
////}
//    }
//
//    private static void drawCard(boolean filled, int i, int[] computer) {
//        while (!filled && i < computer.length) {
//            if (computer[i] == 0) {
//                computer[i] = getCard();
//                if (computer[i] == 0) {
//                    deckEmpty = true;
//                }
//                filled = true;
//            }
//            i++;
//        }
//    }
//
//    public static boolean cardLegal(int card)  //check whether card matches suit, rank of pile or is eight
//    {
//        if ((card) % 13 == 8) { //card is 8
//            return true;
//        } else if ((card) / 13 == (facedownDeck) / 13) { //card matches suit
//            return true;
//        } else if ((card) % 13 == (facedownDeck) % 13) { //card matches rank
//            return true;
//        }
//        return false;
//    }
//
//    public static String shownValue(int card)  // convert card rank to shown rank
//    {
//        int val = card % 13;
//        if (val == 0)
//            return "A";
//        else if (val <= 9)
//            return "" + val;
//        else if (val == 10)
//            return "J";
//        else if (val == 11)
//            return "Q";
//        else if (val == 12)
//            return "K";
//        return "X";
//    }
//
//    public static String shownSuit(int card)  // convert suit 1-4 to SHDC
//    {
//        int suitnum = card / 13;
//        if (suitnum == 0) // spades
//            return "\u2660";
//        else if (suitnum == 1) // hearts
//            return "\u2665";
//        else if (suitnum == 2) // diamonds
//            return "\u2666";
//        else if (suitnum == 3) // clubsm
//            return "\u2663";
//        return "X";
//    }
//
//    public static void drawCard(int value, int x, int y, boolean hidden) {
//        String rank = shownValue(value);
//        String suit = shownSuit(value);
//    }
//
//    public static void render() {
////        int x = 0;
////        for (int i = 0; i < computer.length; i++) { //computer's hand
////            if (computer[i] != 0) {
////                drawCard(computer[i], 670 - x * 40, 30, true);
////                x++;
////            }
////        }
////        x = 0;
////        for (int i = 0; i < player.length; i++) { //player's hand
////            if (player[i] != 0) {
////                drawCard(player[i], 30 + x * 40, 400, false);
////                x++;
////            }
////        }
////        //discard pile
////        drawCard(facedownDeck, 350, 215, false);
//
//    }
//
//    public void intro() {
//
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
//                IOHandler.printMessage(IOHandler.getMessageFromFile("CrazyEights.txt"));
//            } else
//                beginGame();
//        }
//        while (!answer.equalsIgnoreCase("q"));
//    }
//
//    public void beginGame() {
//        Deck deck = new Deck(); //get new deck to play with
//        player = deck.pull(8);   //deal player
//        computer = deck.pull(8); //and computer's hand
//        facedownDeck = getCard(); //show one card from face down Deck
//        while (!emptyHand(1) && !emptyHand(2) && !deckEmpty)
//        //while the player and computers hands aren't empty and the deck is not empty
//        {
//            playerPlays();
//            computerPlays();
//        }
//        result();
//        intro();
//    }
//
//    @Override
//    public void play(Player player) {
//        intro();
//
//    }
//
//    @Override
//    public void quitGame() {
//
//    }
//
//    @Override
//    public void runWelcome() {
//
//    }
//}

