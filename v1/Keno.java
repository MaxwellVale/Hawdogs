// Code for the Keno Casino Game
// Keno is-a Random Number Game

import java.util.ArrayList;
import cs1.Keyboard;

public class Keno {

    // ***** Instance Vars *****
    private int playCost; // money cost for each play
    private ArrayList<Integer> nums; // list that holds numbers to guess from
    private ArrayList<Integer> winNums; // list that holds the winning numbers
    private ArrayList<Integer>  guesses; // Player's guess
    private ArrayList<Integer> matches; // Winning guesses
    private double mult;
    private int winCount = 0;
    // *************************
    

    // ***** Default Constructor *****
    public Keno() {

	playCost = 10; // dollars

	guesses = new ArrayList<Integer>();

	// Create the array of answers to guess from
	nums = new ArrayList<Integer>();
	for (int i = 1; i <= 80; i++) {
	    nums.add(i);
	}

	// Generate Winning numbers for this play
	winNums = new ArrayList<Integer>();
	while (winNums.size() < 20) {
	    int winNum = (int) (Math.random() * 80 + 1);
	    if (winNums.indexOf(winNum) == -1) {
		winNums.add(winNum);
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
	s += "The Player is prompted to choose 15 numbers from 1 - 80, inclusive.\n";
	s += "The Player's guesses are then compared to the random winning numbers and paid for each number guessed correctly.\n";

	return s;
    }

    public void guessNum() {

	int guess = cs1.Keyboard.readInt();

	if (guess < 1 || guess > 80 || guesses.indexOf(guess) != -1) {
	    System.out.println("Please enter a valid guess.");
	    guessNum();
	}
	else {
	    guesses.add(guess);
	}
    }

    public int getCost() {
	return playCost;
    }

    public double getMult() {
	return mult;
    }

    public boolean win() {

	matches = new ArrayList<Integer>();
	
	boolean win = false;
	for (int i = 0; i < guesses.size(); i++) {
	    if (winNums.indexOf(guesses.get(i)) != -1) {
		winCount++;
		mult += 0.3;
		win = true;
		matches.add(guesses.get(i));
	    }
	}
	return win;
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

	s = "Ok, now please make 15 unique guesses from 1 - 80 inclusive: ";
	System.out.println(s);

        while (guesses.size() < 15) {

	    guessNum();
	    
	}

	if (win()) {
	    System.out.println("Congratulations, you have guessed at least one winning number!");
	}
	else {
	    System.out.println("Sorry, those was not the winning numbers...");
	}

	System.out.println("Winning Numbers: " + winNums);
	System.out.println("Number of matches: " + winCount);
	System.out.println("Your winning guesses: " + matches);
    }


    // *******************


}// end class Keno
