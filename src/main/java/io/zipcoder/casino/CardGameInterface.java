package io.zipcoder.casino;

import java.util.ArrayList;

public interface CardGameInterface {

    ArrayList<Card> deck = new ArrayList<Card>();

    int checkNumberOfCards();
    void dealCards();
}
