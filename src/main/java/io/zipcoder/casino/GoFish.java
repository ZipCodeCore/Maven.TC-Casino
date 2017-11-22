package io.zipcoder.casino;

import java.util.*;
import java.util.stream.Collectors;

public class GoFish extends CardGames {

    private Player currentPlayer = PlayerWarehouse.getCurrentPlayer();
    private Player playerPicked;
    private Card cardAskedFor;
    private int numOfCompletedSuits = 0;
    //private Map<String, Integer> myMap = new HashMap<>();

    public void setPlayersList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private ArrayList<Player> playersList = new ArrayList<>();
    //private Deck deck = new Deck();

    public GoFish() {
        super();
    }

    private void numOfOpponents() {
        Integer numOfOpponents = Console.getIntegerInput("\nHow many opponents would you like to play against? (1-3)");

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
        Console.print("\nOrder Of Players Turns: \n");
        playersList.forEach(n -> System.out.println(n.getName()));
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
        Console.print("\nThis is "+aPlayer.getName()+"'s hand: ");
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
        Console.print("Please pick a person you'd like to ask for cards.\n");
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

    private Card getPlayerToAskAndPickCardToAskFor() {
        displayOpponentsNames();
        playerPicked();
        //displayHand(playerPicked);   //UNCOMMENT OUT THIS WHEN YOU DON'T WANT NOT SHOW OPPONENTS HAND
        return pickCardToAskFor(currentPlayer);
    }

    private boolean isCardFound(ArrayList<Card> playerPickedHand) {
        boolean cardFound = false;
        for (int x = 0; x < playerPickedHand.size(); x++) {
            if (playerPicked.getHand().get(x).equals(this.cardAskedFor)) {
                Card theCardFound = playerPicked.getHand().get(x);
                currentPlayer.addToHand(theCardFound);
                playerPickedHand.remove(theCardFound);
                Console.print("\nYay! " + playerPicked.getName() + " had a " + theCardFound.toString() + "!");
                Console.print("You get to go again!");
                drawWhenHandEmpty(playerPicked);
                x--;
                cardFound = true;
            }
        }
        return cardFound;
    }

    private void drawWhenHandEmpty(Player aPlayer) {
        if (aPlayer.getHand().size() == 0) {
            Console.print(aPlayer.getName() + "'s hand is empty. Draw 5 cards or the rest of the cards left in the draw pile.\n");
            Card aCard;
            for (int x = 0; x <= 5; x++) {
                if (deck.getAllCards().size() > 0) {
                    aCard = deck.getCard();
                    aPlayer.addToHand(aCard);
                }
            }
            printSizeOfDrawPile();
        }
    }

    public void cardFoundInHand(boolean isCardInHand) {
        if (isCardInHand) {
            checkForPairOf4(currentPlayer);
            aRound();
        }
    }

    public void cardNotFoundInHand(boolean isCardInHand) {
        if (!isCardInHand) {
            if (deck.getAllCards().size() > 0) {
                Console.print("\nGo Fish, you got it wrong.\n");
                Card cardDrawnFromDeck = deck.getCard();
                Console.print("You just drew a " + cardDrawnFromDeck+"\n");
                printSizeOfDrawPile();
                currentPlayer.addToHand(cardDrawnFromDeck);
                drewCardAskedFor(cardDrawnFromDeck, this.cardAskedFor);
            }
        }
    }

    private void printSizeOfDrawPile() {
        Console.print("There are "+deck.getAllCards().size() + " cards left in the draw pile.");
    }

    private void drewCardAskedFor(Card cardDrawnFromDeck, Card cardPicked) {
        if (cardPicked.equals(cardDrawnFromDeck)) {
            //displayHand(currentPlayer);
            Console.print("Yay! You drew the card you asked for, go again.");
            checkForPairOf4(currentPlayer);
            aRound();
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

            Player tempPlayer = playersList.get(indexOfPlayerPicked);

            if (doesPlayerHaveCardsInHand(tempPlayer)) {
                playerPicked = tempPlayer;
            }
            else {
                Console.print("Can not pick "+playerPicked.getName()+", he has no cards left in his hand.");
                throw new IndexOutOfBoundsException();
            }

        } catch (IndexOutOfBoundsException e) {
            Console.print("Please pick a valid player.");
            playerPicked();
            //e.printStackTrace();
        }
    }

    public boolean doesPlayerHaveCardsInHand(Player aPlayer) {
        if (aPlayer.getHand().size()==0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void play() {
        numOfOpponents();
        decideOrderOfPlayers();
        dealFirstRound();

        while (numOfCompletedSuits<13) {
            for (int x = 0; x < playersList.size(); x++) {
                if (x == playersList.size()-1) {
                    x = 0;
                }

                Player tempCurrentPlayer = playersList.get(x);

                x = verifyPlayerAboutToGoHasCardsInHand(x, tempCurrentPlayer);

                aRound();
            }
        }

        String goFishWinner = goFishWinner();
        Console.print(goFishWinner);
        play();
    }

    private int verifyPlayerAboutToGoHasCardsInHand(int x, Player tempCurrentPlayer) {
        if (doesPlayerHaveCardsInHand(tempCurrentPlayer)) {
            currentPlayer = playersList.get(x);
            Console.print("\n=============================================\n");
            Console.print("It is now " + currentPlayer.getName() + "'s turn!");
        }
        else {
            Console.print(tempCurrentPlayer + " has no cards in their hand. On to the next person.");
            x++;
            currentPlayer = playersList.get(x);
            Console.print("\n=============================================\n");
            Console.print("It is now " + currentPlayer.getName() + "'s turn!");
        }
        return x;
    }

    public String goFishWinner() {
        playersList.sort(Comparator.comparing(Player::getScore).reversed());
        return playersList.get(0).getName();
    }

    private void aRound() {
        displayHand(currentPlayer);
        this.cardAskedFor = getPlayerToAskAndPickCardToAskFor();
        boolean isCardInHand = checkForCardInHand();
        cardFoundInHand(isCardInHand);
        cardNotFoundInHand(isCardInHand);
        checkForPairOf4(currentPlayer);
        //displayHand(currentPlayer);
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

        myMap.forEach((faceValue,cardCount) -> {
            if (cardCount.equals(4)) {
                aPlayer.setHand(aPlayer.getHand().stream().filter(card -> !card.toString().substring(0,2)
                        .equals(faceValue)).collect(Collectors.toCollection(ArrayList::new)));

                numOfCompletedSuits++;
                currentPlayer.addPointToScore();
                Console.print("\nYay! You just got a completed set of four " + faceValue + "'s. " +
                        currentPlayer.getName() + "'s current score is " + currentPlayer.getScore()+".");
                drawWhenHandEmpty(playerPicked);
            }
        });
    }
}
