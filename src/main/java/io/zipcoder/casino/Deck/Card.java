package io.zipcoder.casino.Deck;


public class Card
{
    private Suit suit;
    public static String[] suitSymbols = {"♡", "♢", "♧", "♤"};
    public static String[] faceSymbols = {"A", "J", "Q", "K"};
    private Integer value;
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

    public Integer getValue(){
        return value;
    }

    public Suit getSuit(){
        return suit;
    }

}
