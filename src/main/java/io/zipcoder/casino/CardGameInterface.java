package io.zipcoder.casino;

import java.util.ArrayList;

public interface CardGameInterface {
    ArrayList<Card> deck;

    int checkNumberOfCards();
    void dealCards();
}
