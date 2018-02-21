## Ceelo specific UML
`#### class CeeloGame implements Game
    - CeeloGamble bet
    - Player player (set)
---------------------------------
    + play -> Player(is this the best way? only way?)
    - getBankerPoint -> int
    - getPlayerPoint -> int`

`#### class Die
    - int sides
---------------------------------
    + roll(int numberOfDie, long seed) -> int[]`

`#### class CeeloGamble
    - long base
---------------------------------
    + win -> long
    - lose -> long`

## potential design edits (opinions?)
1. Gamble interface
    * payout(WIN), payout(LOSE) 
    * win(), lose(), push(), etc.. 

2. Player class
    * +betChips(long chips)
    * +canCoverBet(long chips) -> bool
    * +addChips(long chips)
