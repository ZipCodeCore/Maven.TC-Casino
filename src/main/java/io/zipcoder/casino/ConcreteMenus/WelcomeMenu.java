package io.zipcoder.casino.ConcreteMenus;

import io.zipcoder.casino.Console;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.PlayerWarehouse;

public class WelcomeMenu extends Menu {
    public static final WelcomeMenu INSTANCE = new WelcomeMenu();

    public enum welcomeMenuEnums {ExistingPlayer, NewPlayer}


    public WelcomeMenu() {
        super(welcomeMenuEnums.values());
    }

    @Override
    public void userMenuSelection(String input) {
        switch (welcomeMenuEnums.valueOf(input)) {
            case ExistingPlayer:
                existingPlayer();
                break;
            case NewPlayer:
                createNewPlayer();
                break;
        }
    }

    @Override
    public void menuTitle() {
        Console.print("Welcome Menu");
        Console.print("========================================");
    }

    @Override
    public String toString() {
        String output =
                "Are you an existing or new player?\n"+
                "1) Existing Player\n" +
                "2) New Player";

        return output;
    }

    public void createNewPlayer() {
        String playerName = Console.getStringInput("Please enter a username.");
        Double amountOfMoney = Console.getDoubleInput("Please enter the amount of money you have.");

        Player aPlayer = new Player(playerName, amountOfMoney);

        PlayerWarehouse.addPlayer(aPlayer);
        Console.print("\nYour account has been created!\n");
        PlayerWarehouse.setCurrentPlayer(aPlayer);
        CasinoMenu.INSTANCE.display();
    }

    public void existingPlayer() {
        Console.print("Need to finish this method. Not started yet.");
        CasinoMenu.INSTANCE.display();
    }
}
