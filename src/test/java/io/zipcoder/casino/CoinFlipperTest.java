package io.zipcoder.casino;

import org.junit.Test;

public class CoinFlipperTest {

    private static Person player = new Person("Joe");
    private static CoinFlipper coinFlipper = new CoinFlipper(player);

    public static void main(String[] args) {
        player.getWallet().addChipsToAmount(1000);
        coinFlipper.start();
    }

    @Test
    public void coinFlipper() {
        // What to test what to test
    }

}
