package io.zipcoder.casino;

import io.zipcoder.casino.casino.Casino;
import io.zipcoder.casino.casino.CasinoMenu;

public class Main {

    public static void main(String[] args) {

        Casino casino = Casino.getInstance();

        while (true) {
            casino.startCasino();
        }
    }

}
