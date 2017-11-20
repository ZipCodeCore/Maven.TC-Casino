package io.zipcoder.casino.nuts_n_bolts.cards;

public class PlayingCard {

    private PlayingSuit suit;
    private PlayingValue value;

    public PlayingCard(PlayingSuit suit, PlayingValue value){
        this.suit = suit;
        this.value = value;
    }

    public PlayingSuit getSuit() {
        return suit;
    }

    public PlayingValue getValue() {
        return value;
    }

}

/*
 //From BlackJack
    private String topCardRepresentation;
    private String bottomCardRepresentation;
    private static String middleCardRepresentation="|     |\n";

    private Card(){
    }

    @Override
    public String toString(){
        return topCardRepresentation+middleCardRepresentation+bottomCardRepresentation;
    }
    public String getTopCardRepresentation(){
        return topCardRepresentation;
    }


    public Card(Suit passedSuit, Integer passedValue){
        this(passedSuit, passedValue, "X");
    }
    public Card(Suit passedSuit, Integer passedValue, String passedSuitRepresentation){
        this(passedSuit, passedValue, passedSuitRepresentation, "Y");
    }
    public Card(Suit passedSuit, Integer passedValue, String passedSuitRepresentation, String passedFaceRepresentation){
        suit=passedSuit;
        value=passedValue;
        topCardRepresentation=" ----- \n"+
                              "|"+String.format("%2s%-3s", passedFaceRepresentation, passedSuitRepresentation)+"|\n";
        bottomCardRepresentation="|"+String.format("%4s%s", passedFaceRepresentation, passedSuitRepresentation)+"|\n"+
                                 " ----- \n";
    }
    //*/