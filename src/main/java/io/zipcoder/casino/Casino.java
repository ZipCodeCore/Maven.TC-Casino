package io.zipcoder.casino;

public class Casino {
    public static void main(String[] args) {
        int option;
        Player player1;
        String name;
        Double money;
        BlackJack blackJack = new BlackJack();
        GoFish goFish = new GoFish();
        System.out.println("Welcome to Casio App");
        do {
            option = Console.getIntegerInput("What game you want to play?\n 1. BlackJack" +
                    "\n 2. Go Fish\n 3. Craps\n 0. To exit from the App");
            switch (option) {
                case 1:
                    name = Console.getStringInput("Enter your name");
                    money = Console.getDoubleInput("Enter the amount you want to play with");
                    player1 = new CardPlayer(name, money);
                    blackJack.startGame(player1);
                    break;
                case 2:
                    name = Console.getStringInput("Enter your name");
                    player1 = new CardPlayer(name, 100.00);
                    goFish.startGame(player1);
                    break;
                case 3:
                    break;
            }
        } while (option != 0);


    }
}