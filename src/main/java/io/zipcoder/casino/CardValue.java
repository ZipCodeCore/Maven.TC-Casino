package io.zipcoder.casino;

enum CardValue {
    Ace(11), Two(2), Three(3), Four(4), Five(4), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);

    private final int CardsValue;

    CardValue(int cardNumber){
        this.CardsValue = cardNumber;
    }

    public int getCardsValue(){
        return this.CardsValue;
    }
}
