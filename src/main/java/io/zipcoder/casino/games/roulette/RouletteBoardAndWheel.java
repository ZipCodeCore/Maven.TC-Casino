package io.zipcoder.casino;

import java.util.concurrent.TimeUnit;

public class RouletteBoardAndWheel {
    //Start array init
    public int[][] rouletteInnerBoard = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12},
            {13, 14, 15},
            {16, 17, 18},
            {19, 20, 21},
            {22, 23, 24},
            {25, 26, 27},
            {28, 29, 30},
            {31, 32, 33},
            {34, 35, 36}
    };
    //End array init



    public RouletteBoardAndWheel(){
    }


    public Integer[] columnBetSelection(int column){
        Integer[] columnArray = new Integer[this.rouletteInnerBoard.length];
        for(int i = 0; i < columnArray.length; i++){
            columnArray[i] = this.rouletteInnerBoard[i][column];
        }
        return columnArray;
    }

    public Integer[] twelveNumberBet(int boxSelection){
        int start = 0;
        switch(boxSelection){
            case 1: start = 0; break;
            case 2: start = 4; break;
            case 3: start = 8; break;
        }
        Integer[] numberSelection = new Integer[12];
        for(int i = 0; i < numberSelection.length; i++){
            numberSelection[i] = i + start;
        }
        return numberSelection;
    }

    public Integer[] evenNumberSet(){
        Integer[] numberSelection = new Integer[18];
        int counterForArray = 0;
        for(int i = 0; i < numberSelection.length*2; i++){
            if (i % 2 == 0) {
                numberSelection[counterForArray] = i;
                counterForArray++;
            }
        }
        return numberSelection;
    }

    public Integer[] oddNumberSet(){
        Integer[] numberSelection = new Integer[18];
        int counterForArray = 0;
        for(int i = 0; i < numberSelection.length*2; i++){
            if (i % 2 != 0) {
                numberSelection[counterForArray] = i;
                counterForArray++;
            }
        }
        return numberSelection;
    }

    public Integer[] blackNumberSet(){
        Integer[] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        return blackNumbers;
    }

    public Integer[] redNumberSet(){
        Integer[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        return redNumbers;
    }




    //Wheel portion of the table

    public Integer generateWinningNumber() throws InterruptedException{
        long timeout1 = 2;
        long timeout2 = 5;
        System.out.println("\n\n\nSpinning the wheel...\n\n\n");
        TimeUnit.SECONDS.sleep(timeout1);
        System.out.println("\n\n\nWHOOSH (wheel spin sound)\n\n\n");
        TimeUnit.SECONDS.sleep(timeout2);
        Integer winningNumber = (int) (Math.random()*36);
        if (winningNumber == 0){
            int whichZeroChoice = (int) ((Math.random()*2)+1);
            winningNumber = (whichZeroChoice == 1 ? 0 : 00);
        }
        return winningNumber;
    }
}
