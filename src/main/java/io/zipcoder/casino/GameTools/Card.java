package io.zipcoder.casino.GameTools;

public class Card {
    private Suit suitEnum;
    private Rank rankEnum;

    public Card(Rank rankEnum, Suit suitEnum) {
        this.rankEnum = rankEnum;
        this.suitEnum = suitEnum;
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
}
