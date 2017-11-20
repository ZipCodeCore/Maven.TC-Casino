package io.zipcoder.casino;

public class Card {

    private FaceValue faceValue;
    private Suit suit;

    public Card(FaceValue faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public boolean matches(Card card) {
        return faceValue.equals(card.getFaceValue()) && suit.equals(card.getSuit());
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public enum FaceValue {
        ACE ("A"),
        TWO ("2"),
        THREE ("3"),
        FOUR ("4"),
        FIVE ("5"),
        SIX ("6"),
        SEVEN ("7"),
        EIGHT ("8"),
        NINE ("9"),
        TEN ("10"),
        JACK ("J"),
        QUEEN ("Q"),
        KING ("K");

        private String icon;

        FaceValue(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }

    public enum Suit {
        SPADES ("\u2660"),
        HEARTS ("\u2665"),
        DIAMONDS ("\u2666"),
        CLUBS ("\u2663");

        private String icon;

        Suit(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }
}
