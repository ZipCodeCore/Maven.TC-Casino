package io.zipcoder.casino.ConcreteMenus;

public class GoFishMenu extends Menu {
    public static final GoFishMenu INSTANCE = new GoFishMenu();

    public enum goFishMenuEnums {LOOKATYOURHAND, PICKANAME, }

    public GoFishMenu() {
        super(goFishMenuEnums.values());
    }

    @Override
    public void userMenuSelection(String input) {

    }

    @Override
    public void menuTitle() {

    }

    @Override
    public String toString() {
        return null;
    }
}
