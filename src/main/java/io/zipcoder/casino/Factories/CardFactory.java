package io.zipcoder.casino.Factories;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;

public class CardFactory {

    public static Card createCard(Rank rank, Suit suit) {
        return new Card(rank, suit);
    }

}
