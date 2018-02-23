package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class MainMenuTest {

    //follow the prompts in the scanner to create the person for the test
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.makePerson();
        //this checks to make sure player is created
        System.out.println(menu.player.getName());
        menu.chooseGame();
        System.out.println(menu.player.getName());
    }



}
