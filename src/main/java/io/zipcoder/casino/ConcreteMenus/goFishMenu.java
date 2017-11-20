package io.zipcoder.casino.ConcreteMenus;

public class goFishMenu extends Menu {
    public static final goFishMenu INSTANCE = new goFishMenu();

    public enum goFishMenuEnums {LOOKATYOURHAND, PICKANAME, }

    public goFishMenu() {
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
