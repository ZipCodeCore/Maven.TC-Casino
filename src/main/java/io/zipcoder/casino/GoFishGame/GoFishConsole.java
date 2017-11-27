package io.zipcoder.casino.GoFishGame;

import io.zipcoder.casino.Console;
import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class GoFishConsole {

    public static void printOrderOfPlayers(ArrayList<Player> playersList) {
        Console.print("\nOrder Of Players Turns: \n");
        playersList.forEach(n -> System.out.println(n.getName()));
    }

    public static void printPlayersHand(Player aPlayer) {
        Console.print("\nThis is "+aPlayer.getName()+"'s hand: ");
        aPlayer.sortPlayerHand();
        String playersHand = aPlayer.playersHandToString();

        Console.print(playersHand);
    }

    public static void printPlayerOpponents(TurnOfGoFish aTurnOfGoFish) {
        Console.print(aTurnOfGoFish.stringOfOpponentsNames());
    }

    public static void printSizeOfDrawPile(Deck deck) {
        Console.print("There are "+deck.getAllCards().size() + " cards left in the draw pile.");
    }




}
