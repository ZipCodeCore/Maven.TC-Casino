package io.zipcoder.casino;

enum CardValue {

    Ace(11), Two(2), Three(3), Four(4), Five(4), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);

    private int CardsValue;

    CardValue(int cardNumber) {
        this.CardsValue = cardNumber;
    }


    int getValue() {
        return CardsValue;
    }

    //I had to remove some stuff from this class and put it elsewhere for proper implementation and proper Blackjack
    //behavior

