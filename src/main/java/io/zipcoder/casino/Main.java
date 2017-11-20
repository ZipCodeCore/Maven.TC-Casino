package io.zipcoder.casino;

import io.zipcoder.casino.ConcreteMenus.WelcomeMenu;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WelcomeMenu.INSTANCE.display();

    }
}
