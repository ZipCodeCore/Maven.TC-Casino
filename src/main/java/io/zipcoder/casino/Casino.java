package io.zipcoder.casino;

public class Casino {
    public static void main(String[] args) {
        int option;
        Player player1;
        String name;
        Double money;
        BlackJack blackJack = new BlackJack();
        System.out.println("Welcome to Casio App");
        do {
            option = Console.getIntegerInput("What game you want to play Card / Dice \n 1. To play Card game" +
                    "\n 2. To play Dice game.\n 0. To exit from the App");
            switch (option) {
                case 1:
                    name = Console.getStringInput("Enter your name");
                    money = Console.getDoubleInput("Enter the amount you want to play with");
                    player1 = new CardPlayer(name, money);
                    blackJack.startGame(player1);
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } while (option != 0);

    }
}