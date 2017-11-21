package io.zipcoder.casino;

public class Main {
    public static void main(String[] args) {
//        new Casino().startCasino();
        Player player = new Player("Graham", 3000, 5);
        GoFish test = new GoFish(player);
        test.goFishStart();
    }
}
