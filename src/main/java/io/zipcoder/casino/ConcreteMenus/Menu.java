package io.zipcoder.casino.ConcreteMenus;

import io.zipcoder.casino.Console;

public abstract class Menu {
    private Enum[] menuEnum;

    public Menu(Enum[] menuEnums) {
        this.menuEnum = menuEnums;
    }

    public abstract void userMenuSelection(String input);

    public void display() {
        String userInput;

        do {
            try {
                do {
                    userInput = this.getInput().toUpperCase();
                    userMenuSelection(convertEnumsToNums(userInput));
                } while (!"quit".equalsIgnoreCase(userInput));
                break;
            } catch (IllegalArgumentException|ArrayIndexOutOfBoundsException e) {
                Console.print("\nINVALID INPUT!!! Please enter a valid menu option.");
                continue;
            }
        }while (true);
    }

    public String convertEnumsToNums(String menuNum) {
        int stringToNum = Integer.parseInt(menuNum)-1;
        return ""+this.menuEnum[stringToNum];
    }

    public String getInput() {
        this.menuTitle();
        Console.print(this.toString());
        return Console.getStringInput("");
    }

    public abstract void menuTitle();

    public abstract String toString();


}
