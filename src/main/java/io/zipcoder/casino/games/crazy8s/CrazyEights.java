
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
