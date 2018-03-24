package io.zipcoder.casino.Games;



import org.junit.Test;



import static junit.framework.TestCase.fail;


public class DiceTest {
    Dice diceTest = new Dice();
    int diceValue;
    int highestDiceValue = 1000;
    int lowestDiceValue = -1000;

    @Test
    public void checkIfDiceAreWithingBoundsTest(){
        for (int i = 0; i < 10000; i++){
            diceValue = Dice.rollDice();
            if (diceValue < 1){
                fail("Dice value too low!");
            } else if (diceValue > 6){
                fail("Dice value too hich");
            } else if (lowestDiceValue > diceValue){
                diceValue = lowestDiceValue;

            } else if (highestDiceValue < diceValue){
                diceValue = highestDiceValue;
            }
        }
    }
}
