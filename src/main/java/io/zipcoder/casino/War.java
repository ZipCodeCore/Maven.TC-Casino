package io.zipcoder.casino;

public class War {

    Deck originalGameDeck = new Deck();
    originalGameDeck.shuffleDeck();
    Deck playerOnePlayedCard = new Deck(); // For the card(s) that get played by player one
    Deck playerTwoPlayedCard = new Deck(); // For the card(s) that get played by player two
    // Deck gets 52 cards, gets shuffled, and is split into both player decks

    // In final version of casino, this psvm will be removed because the game will run from the main app
    // Logic here:
    public static void main(String[] args) {

    }

    // Will need for loop to iterate through both playedCard ArrayLists to return cards to winningPLayerDeck.add(i)

}
