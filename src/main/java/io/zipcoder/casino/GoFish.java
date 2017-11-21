package io.zipcoder.casino;

import java.util.*;
import java.util.stream.Collectors;

public class GoFish extends CardGames {

    private Player currentPlayer = PlayerWarehouse.getCurrentPlayer();
    private Player playerPicked;
    private Card cardAskedFor;
    private int numOfCompletedSuits = 0;
    //private Map<String, Integer> myMap = new HashMap<>();

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private ArrayList<Player> playersList = new ArrayList<>();
    //private Deck deck = new Deck();

    public GoFish() {
        super();
    }

    private void numOfOpponents() {
        Integer numOfOpponents = Console.getIntegerInput("How many opponents would you like to play against? (1-3)");

        if (numOfOpponents.equals(1)) {
            playersList.add(currentPlayer);
            playersList.add(new Player("Leon", 100.0));
        }
        else if (numOfOpponents.equals(2)) {
            playersList.add(currentPlayer);
            playersList.add(new Player("Leon", 100.0));
            playersList.add(new Player("Pavel", 100.0));
        }
        else {
            playersList.add(currentPlayer);
            playersList.add(new Player("Leon", 100.0));
            playersList.add(new Player("Pavel", 100.0));
            playersList.add(new Player("Tim", 100.0));
        }
    }

    public void decideOrderOfPlayers() {
        Collections.shuffle(playersList);
        Console.print("Order Of Players Turns: \n");
        playersList.forEach(n -> System.out.println(n.getName()));
        Console.print("");
    }

    public void dealARound() {
        for (Player aPlayer : playersList) {
            aPlayer.addToHand(deck.getCard());
        }
    }

    public void dealFirstRound() {
        dealARound();
        dealARound();
        dealARound();
        dealARound();
        dealARound();
    }

    public void sortPlayerHand(Player aPlayer) {
        aPlayer.getHand().sort(Comparator.comparing(Card::toString));
    }

    public void displayHand(Player aPlayer) {
        Console.print("This is "+aPlayer.getName()+"'s hand: ");
        sortPlayerHand(aPlayer);

        for (int x = 0; x < aPlayer.getHand().size(); x++) {
            Console.print(x+") "+aPlayer.getHand().get(x));
        }
        Console.print("");
    }

    public Card pickCardToAskFor(Player aPlayer) {
        int cardIndex = Console.getIntegerInput("Please pick a card you'd like to ask for.");
        Card aCard = null;
        try {
            aCard = aPlayer.getHand().get(cardIndex);
            System.out.println(aPlayer.getName()+" picked: " + aCard.toString());
            return aCard;
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            aCard = pickCardToAskFor(aPlayer);
            //e.printStackTrace();
        }
        return aCard;
    }

    public void displayOpponentsNames() {
        Console.print("Please pick a person you'd like to ask for cards.");
        Console.print("");
        for (int x = 0; x < playersList.size(); x++) {
            String playersName = playersList.get(x).getName();
            if (!currentPlayer.getName().equalsIgnoreCase(playersName)) {
                Console.print(x+") "+playersName+", has "+playersList.get(x).getHand().size()+" cards in his hand.");
            }
        }
    }

    public boolean checkForCardInHand() {
        //Card cardPicked = pickCardToAskFor(currentPlayer); need to use when done debugging
        ArrayList<Card> playerPickedHand = playerPicked.getHand();
        boolean isCardFound = isCardFound(playerPickedHand);
        return isCardFound;
    }

    private Card defineAskedForCard() {
        displayOpponentsNames();
        playerPicked();
        displayHand(playerPicked);
        return pickCardToAskFor(currentPlayer);
    }

    private boolean isCardFound(ArrayList<Card> playerPickedHand) {
        boolean cardFound = false;
        for (int x = 0; x < playerPickedHand.size(); x++) {
            if (playerPicked.getHand().get(x).equals(this.cardAskedFor)) {
                Card theCardFound = playerPicked.getHand().get(x);
                currentPlayer.addToHand(theCardFound);
                playerPickedHand.remove(theCardFound);
                Console.print("\nYay! " + playerPicked.getName() + " had a " + theCardFound.toString() + "!\n");
                x--;
                cardFound = true;
            }
        }
        return cardFound;
    }

    public void cardFoundInHand(boolean isCardInHand) {
        if (isCardInHand) {
            displayHand(currentPlayer);
            checkForPairOf4(currentPlayer);
            checkForCardInHand();
        }
    }

    public void cardNotFoundInHand(boolean isCardInHand) {
        if (isCardInHand) {
            if (deck.getAllCards().size() > 0) {
                Console.print("\nGo Fish, you got it wrong hahahaha\n");
                Card cardDrawnFromDeck = deck.getCard();
                Console.print("You just drew a " + cardDrawnFromDeck+"\n");
                Console.print("There are "+deck.getAllCards().size() + " cards left in the deck.");
                currentPlayer.addToHand(cardDrawnFromDeck);
                drewCardAskedFor(cardDrawnFromDeck, this.cardAskedFor);
            }
        }
    }

    private void drewCardAskedFor(Card cardDrawnFromDeck, Card cardPicked) {
        if (cardPicked.equals(cardDrawnFromDeck)) {
            displayHand(currentPlayer);
            checkForPairOf4(currentPlayer);
            checkForCardInHand();
        }
    }

    private void playerPicked() {
        int indexOfPlayerPicked;
        try {
            indexOfPlayerPicked = Console.getIntegerInput("");
            if ((indexOfPlayerPicked == playersList.indexOf(currentPlayer))) {
                Console.print("Can not pick yourself.");
                throw new IndexOutOfBoundsException();
            }
            playerPicked = playersList.get(indexOfPlayerPicked);
        } catch (IndexOutOfBoundsException e) {
            Console.print("Please pick a valid player.");
            playerPicked();
            //e.printStackTrace();
        }
    }

    public void checkForPairOf4(Player aPlayer) {
        Map<String, Integer> myMap = new HashMap<>();


        for (Card aCard : aPlayer.getHand()) {
            if (myMap.containsKey(aCard.toString().substring(0, 2))) {
                Integer count = myMap.get(aCard.toString().substring(0,2));
                count++;
                myMap.put(aCard.toString().substring(0,2), count);
            }
            else {
                myMap.put(aCard.toString().substring(0, 2), 1);
            }
        }

//        ArrayList<Card> cardlist = aPlayer.getHand();
//        for (int i = 0; i< cardlist.size(); i++) {
//            Card card = cardlist.get(i);
//            System.out.println(returnFaceValue(myMap) + " " + card.toString().substring(0, 2));
//            System.out.println(returnFaceValue(myMap).equals(card.toString().substring(0, 2)));
//        }

//        ArrayList<Card> newHand = aPlayer.getHand().stream()
//                .filter(card -> !returnFaceValue(myMap)
//                        .equals(card.toString().substring(0, 2)))
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        System.out.println(Arrays.toString(newHand.toArray()));
//
//        aPlayer.setHand(newHand);

        aPlayer.setHand(aPlayer.getHand().stream()
                .filter(a -> returnFaceValue(myMap)).collect(Collectors.toCollection(ArrayList::new)));


                //.filter()
                //.equals(card.toString().substring(0, 2)))
                //

        //myMap = aPlayer.getHand();

        displayHand(aPlayer);

    }


    private boolean returnFaceValue(Map<String, Integer> myMap) {
        if (myMap.get(" A") == 4) {
            return true;
        }
        else {
            return false;
        }

    }
     


//    private String returnFaceValue(Map<String, Integer> myMap) {
//        String faceValue = "";
//        Integer countNumber = 0;
//        for (Map.Entry<String, Integer> pair : myMap.entrySet()) {
//            countNumber = pair.getValue();
//            faceValue = pair.getKey();
//            if (countNumber.equals(4)) {
//                numOfCompletedSuits++;
//                currentPlayer.addPointToScore();
//                Console.print("Yay! You just got a completed set of four " + faceValue + ". " +
//                        "Your current score " + currentPlayer.getName() + ", is " + currentPlayer.getScore());
//                Console.print("The size of the hashmap is: " + myMap.size());
//                //myMap.remove(faceValue);
//                //IF YOU DON'T REMOVE FROM MAP IT GIVES YOU THE RIGHT AMOUNT OF CARDS IN THE END.
//                break;
//
//            }
//        }
//        return faceValue;
//    }

//    numOfOpponents(); only run once
//    decideOrderOfPlayers(); only run once
//    dealFirstRound(); only run once
//    displayHand(currentPlayer); run multiple times
//    checkForCardInHand(); run multiple times

    @Override
    public void play() {
        numOfOpponents();
        decideOrderOfPlayers();
        dealFirstRound();


        int trueValueOfLoop = 0;

        while (numOfCompletedSuits<13) {

            if (trueValueOfLoop == playersList.size()) {
                trueValueOfLoop = 0;
            }
            for (int x = trueValueOfLoop; x < playersList.size(); x++) {
                currentPlayer = playersList.get(x);
                Console.print("TESTING THIS SHIT OUTTTTTTTTTT.");
                Console.print("It is now " + currentPlayer.getName() + "'s turn!");
                displayHand(currentPlayer);
                this.cardAskedFor = defineAskedForCard();
                boolean isCardInHand = checkForCardInHand();
                cardFoundInHand(isCardInHand);
                cardNotFoundInHand(isCardInHand);

                displayHand(currentPlayer);

                break;
            }
        }

        // method to check and see who has the highest score or tie

    }
}
