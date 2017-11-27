package io.zipcoder.casino.ConcreteMenus;

import io.zipcoder.casino.Console;
import io.zipcoder.casino.Craps;
import io.zipcoder.casino.GoFishGame.GoFish;
import io.zipcoder.casino.PlayerWarehouse;

public class CasinoMenu extends Menu {
    public static final CasinoMenu INSTANCE = new CasinoMenu();

    public enum gamesEnums {BLACKJACK, CRAPS, GOFISH, LEAVE}

    public CasinoMenu() {
        super(gamesEnums.values());
    }

    @Override
    public void userMenuSelection(String input) {
        switch (gamesEnums.valueOf(input)){
            case BLACKJACK:
                BlackJackMenu.run();
                break;
            case CRAPS:
                craps();
                break;
            case GOFISH:
                goFish();
                break;
            case LEAVE:
                break;
        }
    }

    @Override
    public void menuTitle() {
        Console.print("Welcome to the Casino!");
        Console.print("Game Menu");
        Console.print("==============================================");
    }

    @Override
    public String toString() {
        String output =
            "1) Black Jack\n" +
            "2) Craps\n" +
            "3) Go Fish\n" +
            "4) Leave";

        return output;
    }

    public void goFish() {
        GoFish newGameOfGoFish = new GoFish();
        newGameOfGoFish.setPlayer(PlayerWarehouse.getCurrentPlayer());
        newGameOfGoFish.play();
    }

    public void craps() {
        Craps newGameOfCraps = new Craps();
        newGameOfCraps.setPlayer(PlayerWarehouse.getCurrentPlayer());
        newGameOfCraps.play();
    }
}
