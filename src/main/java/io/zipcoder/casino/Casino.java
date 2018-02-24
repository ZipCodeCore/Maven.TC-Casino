package io.zipcoder.casino;

enum BlackJackChoices {
    BET,
    HIT,
    STAND,
    SPILT;


    public String toString() {
        return name().replaceAll("_", " ");
    }
}