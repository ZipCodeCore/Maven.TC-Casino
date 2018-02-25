
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


