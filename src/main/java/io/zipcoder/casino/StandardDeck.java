package io.zipcoder.casino;

import java.util.ArrayList;

import static io.zipcoder.casino.Card.Suit.*;
import static io.zipcoder.casino.Card.FaceValue.*;

public class StandardDeck extends CardPile {

    public StandardDeck() {
        super();
        populateStandardDeck();
    }

    public void populateStandardDeck() {
        for(Card.FaceValue faceValue : Card.FaceValue.values()) {
            for(Card.Suit suit : Card.Suit.values()) {
                this.addCardToPile(new Card(faceValue, suit));
            }
        }
        shuffle();
    }
}
