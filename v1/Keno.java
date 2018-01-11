// Code for the Keno Casino Game
// Keno is-a Random Number Game

import java.util.ArrayList;
import cs1.Keyboard;

public class Keno {

  // ***** Instance Vars *****
  private int playCost; // money cost for each play
  private ArrayList<Integer> nums; // list that holds numbers to guess from
  private ArrayList<Integer> wins; // list that holds the winning numbers
  private int guess; // Player's guess
  // *************************

  // ***** Default Constructor *****
  public Keno() {

    // Create the array of answers to guess from
    nums = new ArrayList<Integer>();
    for (int i = 1; i <= 10; i++) {
      nums.add(i);
    }

    // Generate Winning numbers for this play
    wins = new ArrayList<Integer>();
    while (wins.size() < 3) {
      int winNum = (int) (Math.random() * 10 + 1);
      if (wins.indexOf(winNum) == -1) {
        wins.add(winNum);
      }
    }

    play();

  }
  // *******************************

  // ***** Methods *****
  public String about() {

    String s;
    s = "\nKeno is a Random Number Casino game playable at The HawDog Casino.\n";
    s += "At the beginning of every game, 20 random numbers from 1 - 80 (inclusive) are chosen as the winning numbers.\n";
    s += "The Player is prompted to choose 20 numbers from 1 - 80, inclusive.\n";
    s += "The Player's guesses are then compared to the random winning numbers and paid for each number guessed correctly.\n";

    return s;
  }

  public void guessNum() {

    guess = cs1.Keyboard.readInt();

    if (guess < 1 || guess > 10) {
      System.out.println("Please enter a valid guess.");
      guessNum();
    }
  }

  public boolean win() {
    return (wins.indexOf(guess) != -1);
  }

  public void play() {

    String s;
    s = "Would you like to see the rules of the game? \n";
    s += "\t1: Yes\n";
    s += "\t2: No\n";
    System.out.println(s);

    int rules = cs1.Keyboard.readInt();

    if (rules == 1) {
      System.out.println(about());
    }

    s = "Ok, now please make your guess from 1 - 10 inclusive: ";
    System.out.println(s);

    guessNum();

    if (win()) {
      System.out.println("Congratulations, you have guessed a winning number!");
    }
    else {
      System.out.println("Sorry, that was not one of the winning numbers...");
    }

    System.out.println("Winning Numbers: " + wins);
  }


  // *******************


}// end class Keno
