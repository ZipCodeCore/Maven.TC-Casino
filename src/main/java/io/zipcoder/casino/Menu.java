package io.zipcoder.casino;

import java.util.Scanner;
import java.util.StringJoiner;

import static io.zipcoder.casino.Card.Suit.*;

public abstract class Menu {

    private final Enum[] menuOptions;

    public Menu(Enum[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    public abstract void selectOption(String userInput);

    public void display() {
        String userInput;
        do {
            System.out.printf("\n\n%s%s%s%s\u2685\u2685 %s \u2680\u2680%s%s%s%s\n",
                    SPADES.getIcon(), HEARTS.getIcon(), DIAMONDS.getIcon(), CLUBS.getIcon(),
                    getClass().getSimpleName(),
                    CLUBS.getIcon(), DIAMONDS.getIcon(), HEARTS.getIcon(), SPADES.getIcon());
            userInput = getMenuInput().toUpperCase();
            try {
                selectOption(userInput);
            } catch (IllegalArgumentException iae) {
                System.out.println("Invalid selection");
            } catch (NullPointerException npe) {
                System.out.println("Invalid selection");
            }
        } while (true);
    }

    public String getMenuInput() {
        String prompt = "Enter your selection to proceed: \n";
        StringJoiner stringJoiner = new StringJoiner(" ] * [ ", "[ ", " ]\n");
        for(Enum option : menuOptions) {
            stringJoiner.add(option.name());
        }
        prompt += stringJoiner.toString();
        return getUserInput(prompt);
    }

    public static String getUserInput(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public static Double getDoubleInput(String prompt) {
        String userInput = getUserInput(prompt);
        Double userDoubleInput = 0.0;
        try {
            userDoubleInput = Double.parseDouble(userInput);
        } catch (IllegalArgumentException iae) {
            System.out.println("Invalid input");
        }

        return userDoubleInput;
    }

    public static Integer getIntegerInput(String prompt) {
        Double userDoubleInput = getDoubleInput(prompt);
        Integer userIntegerInput = (int) Math.round(userDoubleInput);
        return userIntegerInput;
    }
}

/*


public abstract class Menu {

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
        } while (!"Home".equalsIgnoreCase(userInput));
    }

    protected void handleIllegalArgumentException(String illegalArgument, IllegalArgumentException iae) {
        handleException("[ %s ] is an invalid argument.\n", illegalArgument);
    }

    protected void handleNullPointerException(NullPointerException npe) {
        handleException("Unable to retrieve data with input value.\n");
    }

    private void handleException(String message, Object... args) {
        System.out.printf(message, args);
    }

    protected Person getPersonByName(){
        Scanner in = new Scanner(System.in);
        Person match=null;
        do {
            System.out.println("Enter Name: ");
            String name = in.nextLine();
            ArrayList<Person> matchList = personWarehouse.getPersonByName(name);
            if (matchList.size()==0) {
                System.out.println("Invalid Name. Choices: \n");
                System.out.println(personWarehouse.getAllPeople());
            }
            else if (matchList.size()==1){
                match=matchList.get(0);
            }
            else
            {
                do {
                    System.out.println("Multiple matches for " + name + ". Choose ID from choices below:\n");
                    for (Person p : matchList) {
                        System.out.println(p.toString());
                    }
                    match = getPersonById();
                    if (!name.equalsIgnoreCase(match.getContactInfo().getName())) {
                        System.out.println("That ID doesn't match any person named " + name);
                    }
                }while (!name.equalsIgnoreCase(match.getContactInfo().getName()) );
            }

        }while (match==null);
        return match;

    }

    protected Person getPersonByName(EmploymentStatus employmentStatus){
        Scanner in = new Scanner(System.in);
        Person match=null;
        do {
            System.out.println("Enter Name: ");
            String name = in.nextLine();
            ArrayList<Person> matchList = personWarehouse.getPersonByName(name, employmentStatus);
            if (matchList.size()==0) {
                System.out.println("Invalid Name. Choices: \n");
                personWarehouse.printAllOfType(employmentStatus);
            }
            else if (matchList.size()==1){
                match=matchList.get(0);
            }
            else
            {
                do {
                    System.out.println("Multiple matches for " + name + ". Choose ID from choices below:\n");
                    for (Person p : matchList) {
                        System.out.println(p.toString());
                    }
                    match = getPersonById(employmentStatus);
                    if (!name.equalsIgnoreCase(match.getContactInfo().getName())) {
                        System.out.println("That ID doesn't match any person named " + name);
                    }
                }while (!name.equalsIgnoreCase(match.getContactInfo().getName()) );
            }

        }while (match==null);
        return match;

    }

    protected Person getPersonById(){
        Scanner in = new Scanner(System.in);
        Person match;
        do {
            System.out.println("Enter ID: ");
            String id = in.nextLine();
            match = personWarehouse.getPersonById(id);
            if (match == null) {
                System.out.println("Invalid ID. Choices: \n");
                System.out.println(personWarehouse.getAllPeople());
            }
        }while (match==null);
        return match;
    }

    protected Person getPersonById(EmploymentStatus employmentStatus){
        Scanner in = new Scanner(System.in);
        Person match=null;
        do {
            System.out.println("Enter ID: ");
            String id = in.nextLine();
            match = personWarehouse.getPersonById(id, personWarehouse.getAllOfType(employmentStatus));
            if (match == null) {
                System.out.println("Invalid ID. Choices: \n");
                personWarehouse.printAllOfType(employmentStatus);
            }
        }while (match==null);
        return match;
    }
}



 */