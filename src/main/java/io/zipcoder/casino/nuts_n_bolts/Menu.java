package io.zipcoder.casino.nuts_n_bolts;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by leon on 10/24/17.
 * Yup, totally stole most of this from Leon, he makes good stuff.
 */

public abstract class Menu {

    private final Enum[] menuOptions;

    public Menu(Enum[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    abstract public void selectOption(String userInput);

    public void display() {
        String userInput;
        do {
            System.out.printf("\n\n===== %s =====\n", getClass().getSimpleName());
            userInput = this.getMenuInput().toUpperCase();
            try {
                selectOption(userInput);
            } catch (IllegalArgumentException iae) {
                handleIllegalArgumentException(userInput, iae);
            } catch (NullPointerException npe) {
                handleNullPointerException(npe);
            }
        } while (!"back".equalsIgnoreCase(userInput));
    }

    protected void handleIllegalArgumentException(String illegalArgument, IllegalArgumentException iae) {
        handleException("What's this [ %s ]?\n", illegalArgument);
    }

    protected void handleNullPointerException(NullPointerException npe) {
        handleException("Unable to retrieve data with input value.\n");
    }

    private void handleException(String message, Object... args) {
        System.out.printf(message, args);
    }

    protected String getMenuInput() {
        System.out.println("Type in your selection to proceed:");
        for (Enum e : menuOptions) {
            System.out.printf("[ %s ] ", e.name());
        }
        return Input.getStringInput("\n");
    }

}


