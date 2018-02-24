package io.zipcoder.casino;


import static io.zipcoder.casino.Person.createNewPlayerFromUserInput;


public class Casino {
    //both methods call methods that have Scanner and Wilhelm said you can't do tests on methods with Scanner

    //createNewPlayer creates a new player based on user input of their name
    //fillPlayerWallet fills the new player's wallet with chips based on user's input
    public static Person newPlayer() {
        Person player = createNewPlayerFromUserInput();
        player.getWallet().fillPlayerWalletFromUserInput();
        return player;
    }

    //first call newPlayer, then use the Person it returns as the parameter
    public static void sendPlayerToGame(Person player) {
        MainMenu menu = new MainMenu();
        String choice = menu.displayGameChoices();
        Game myGame = MainMenu.chooseGame(choice, player);
        myGame.start();
    }


}
