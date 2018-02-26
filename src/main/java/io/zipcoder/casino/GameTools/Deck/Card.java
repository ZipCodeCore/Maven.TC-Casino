package io.zipcoder.casino.GameTools.Deck;

public class Card {
    private Suit suitEnum;
    private Rank rankEnum;
    private Rank asciiEnum;

    public Card(Rank rankEnum, Suit suitEnum) {
        this.rankEnum = rankEnum;
        this.suitEnum = suitEnum;
    }

    public Card(){
        this.rankEnum = null;
        this.suitEnum = null;
    }

    public Suit getSuitEnum() {
        return suitEnum;
    }

    public void setSuitEnum(Suit suitEnum) {
        this.suitEnum = suitEnum;
    }

    public Rank getRankEnum() {
        return rankEnum;
    }

    public void setRankEnum(Rank rankEnum) {
        this.rankEnum = rankEnum;
    }

    public void setAsciiEnum(Rank asciiEnum) {
        this.asciiEnum = asciiEnum;
    }

    public Rank getAsciiEnum() {
        return asciiEnum;
    }

    public String toCardArt() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rankEnum.getAsciiValue());
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder card = new StringBuilder();
        card.append(this.getRankEnum() + " of " + this.getSuitEnum());

        return card.toString();
    }
}
