# Coinpurse by Nitith Chayakul

## Objectives
  Implement an object-oriented program using a List for collection of objects.

## Aplications
* Application is simulate a coin purse that we can insert and remove coins.
* A purse has a fixed capacity. Capacity is the maximum number of coins that you can put in the purse, not the value of the coins. The value is unlimited.
* A purse can tell us how much money is in the purse.
* We can insert and withdraw money. For withdraw, we ask for an amount and the purse decides which coins to withdraw.

## Classes

There is total of 8 class in this coinpurse project.
### Coin class
An imitation of coin with a monetary value and currency.

### Purse class
An imitation of purse that contain coin.
* Able to insert coin.
* Able to withdraw money.
* Able to check the balance.
* Able to check if the purse is full.
* When you withdraw money, the class decide which coin to remove.

### ConsoleDialog class
User Interface for the Coin Purse.
* Provide simple dialog for inserting, remove money to/from the purse, and displaying the balance.

### Main class
As the name suggest, It is a main class to create object and connect object together.

### CoinUtil class
A collection of Coin's utility method for practice using List and Comparator.

### CompareByCurrency class
A Comparator implements class to compare order of the Coin object by their currency, use in CoinUtil class.

### Addition : PurseTest class
A project tester using JUnit 4 test
