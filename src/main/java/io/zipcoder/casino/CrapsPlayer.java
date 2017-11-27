package io.zipcoder.casino;

public class CrapsPlayer extends Player {

    private Player player;
    private Integer chipCount = 0;

    public CrapsPlayer(Player player, Integer chipCount) {
        super(player.getName(), player.getCash(), player.isPerson());
        this.player = player;
        this.chipCount = chipCount;
    }

    public Integer getChipCount() {
        return chipCount;
    }

    public Integer tradeInChips() {
        Integer chips = chipCount;
        chipCount = 0;
        return chips;
    }

    public void addChips(Integer amount) {
        chipCount += amount;
    }

    public Integer placeBet(Integer amount) {
        if (wagerAvailable(amount))
            chipCount -= amount;
        else amount = 0;

        return amount;
    }

    private boolean wagerAvailable(Integer bet) {
        if (bet > chipCount)
            return false;
        else return true;
    }

}
