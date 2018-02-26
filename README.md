# TC-Casino
* Objective:
  * To create a casino simulation.

## Minimum Viable Product (MVP)
* Your application must have at the very least 3 games:
  * Go Fish a card game
  * BlackJack a card game
  * Craps a dice game

## Specs
* This repo contains a [UML](https://github.com/Zipcoder/CR-MacroLabs-OOP-Casino/blob/master/UML.pdf) to help get you started.
* The project should include some concept of
  * `io.zipcoder.casino.Player` class
    * `io.zipcoder.casino.Player` objects should be created upon input from a user.
  * `Game` interface
    * Contract which ensures that a class enforces some aspect of _playing_.
  * `Gamble` interface
    * Contract which ensures that a class enforces some aspect of _waging money_.
  
 

## Developmental Notes
* Go fish is a friendly game and should not involve gambling.
* `BlackJack` and `io.zipcoder.casino.Game.Game.cardGame.GoFIsh.GoFish` are both Card Games and should therefore inherit from a common `io.zipcoder.casino.Game.Game.cardGame.CardGame`.
* Any common logic or fields between the games should live io.zipcoder.casino.Game.Game.cardGame.CardGame class, **not** BlackJack **nor** io.zipcoder.casino.Game.Game.cardGame.GoFIsh.GoFish.
* The UML provided is missing classes, properties, and definitions required to complete this project.
* You must have a completed and approved UML diagram before you proceed to do any development
* You can either work by yourself , or in a group no bigger than 3.
* All public methods should be tested.
