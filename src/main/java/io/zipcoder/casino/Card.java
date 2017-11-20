package io.zipcoder.casino;

public class Card implements Comparable{
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
        return topCardRepresentation;
    }

//    @Override
//    public String toString(){
//        int cardPositionForRecreation = this.suit.ordinal();
//        return value + suitSymbols[cardPositionForRecreation];
//    }


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
        topCardRepresentation = String.format("%2s%-3s", passedFaceRepresentation, passedSuitRepresentation);
        bottomCardRepresentation="|"+String.format("%4s%s", passedFaceRepresentation, passedSuitRepresentation)+"|\n"+
                " ----- \n";
    }

    public Integer getValue(){
        return value;
    }

    public Suit getSuit(){
        return suit;
    }

    @Override
    public int compareTo(Object o) {
        return this.compareTo(o);
    }
}