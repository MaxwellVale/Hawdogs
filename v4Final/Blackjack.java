

import java.util.ArrayList;
import cs1.Keyboard;

public class Blackjack extends Game {

  private ArrayList<Card> _dealer = new ArrayList<Card>();
  private ArrayList<Card> _player = new ArrayList<Card>();
  private Deck _deck;
  private int choice;
  private boolean win;

  // Default Constructor
  public Blackjack() {
    cost = 10.0; // play cost of Blackjack at the casino
    winnings = 15; //  how much is earned if you win
    _deck = new Deck(); // instantiate a new deck to use for Blackjack
    win = false;

    // Both the player and the dealer must draw two cards to begin
    _player.add(_deck.draw());
    _player.add(_deck.draw());

    _dealer.add(_deck.draw());
    _dealer.add(_deck.draw());

    String i;

    // Ask user if they would like to see the rules for Blackjack
    i = "Would you like to see the rules of the game? \n";
    i += "\t1: Yes\n";
    i += "\t2: No\n";
    System.out.println(i);

    int rules = cs1.Keyboard.readInt(); // Reading an integer corresponding to the choice

    if (rules == 1) {
      System.out.println(about());
    }

    play(); // run play() method to start game as soon as new Blackjack game is started

  } // end default constructor

  // accessor for win
  public boolean getWin(){
    return win;
  }

  // about() method returns a String detailing the basic rules of Blackjack
  public String about() {
    String s;
    s = "\nBlackjack is a card game where your objective is to reach a value of 21.\n";
    s += "You are dealt a hand of two cards at the beginning, and a dealer is also dealt two cards. ";
    s += "\nAll of the number cards are valued at their number.";
    s += "\nAll face cards are worth 10 and the ace is worth 11.";
    s += "\nIf you or the dealer automatically gets a total value of 21 (adding together card values), you have blackjack, and win quick money. ";
    s += "Otherwise, you are given the choice to hit, stand, or double. ";
    s += "\nBy hitting, you draw a card from the deck, and can keep going until you go over 21";
    s += "\nBy standing, you trust your luck, and compare your value with the dealer's";
    s += "\nBy doubling, you raise your bet amount, and draw one more card\n";

    return s;
  } // end about()

  // returns the total value of hand
  public int value(ArrayList<Card> hand){
    int sum = 0;
    for (int i = 0; i < hand.size(); i++){
      if ((hand.get(i)).getRank() == 1){ // if card is an ace, add 11
        sum += 11;
      }
      else if ((hand.get(i)).getRank() >= 11){ // if card is one of the face cards, add 10
        sum += 10;
      }
      else {
        sum += (hand.get(i)).getRank(); // otherwise, simply add the numerical value of the card
      }
    }
    return sum;
  } // end value(hand)

  // reveal method to evaluate Player's hand based on action
  // returns false if Player's hand is totaled over 21
  // returns true if Player chooses to Stand (choice 1) or does not bust (go over 21)
  public boolean reveal(int choice) {
    if (choice == 3) { // if player has chosen to Double
      if (value(_player) > 21) { // check for bust
        System.out.println("Sorry, you busted. (Over the winning amount)");
        System.out.println("Your hand was: " + _player + "\n");
        win = false;
        return false;
      }
      else if (value(_player) == 21) { // if _player gets a Blackjack on the turn
        System.out.println("You had a Blackjack!\n");
        System.out.println("Your hand was: " + _player + "\n:");
        winnings *= 1.5; // winnings multiplier goes up more
        win = true;
        return true;
      }
    }

    else if (choice == 2) { // if player has chosen to hit
      if (value(_player) > 21) { // check for bust
        System.out.println("Sorry, you busted. (Over the winning amount)");
        System.out.println("Your hand was: " + _player + "\n");
        win = false;
        return false;
      }
      else if (value(_player) == 21) {
        System.out.println("You had a Blackjack!\n");
        System.out.println("Your hand was: " + _player + "\n:");
        winnings *= 1.5; // winnings multiplier goes up more
        win = true;
        return true;
      }
      else { // if neither, then continue to play
        System.out.println("Your hand is: " + _player + "\n");
        return chooseaction();
      }
    }
    else if (choice == 1) { // if you stand, then move on to final comparison
      return true;
    }
    return true;
  }

  // method prompting Player to make their move
  public boolean chooseaction(){

    String s; // detailing Player's possible moves in Blackjack
    s = "Make your decision\n";
    s += "\t1: Stand\n";
    s += "\t2: Hit\n";
    s += "\t3: Double\n";
    System.out.println(s);

    choice = cs1.Keyboard.readInt(); // reading int corresponding to choice

    if (choice == 1) {
      return reveal(choice);
    }
    else if (choice == 2) {
      _player.add(_deck.draw()); // choosing hit adds one card to hand and checks for bust before continuing
      _dealer.add(_deck.draw());
      return reveal(choice);
    }
    else if (choice == 3) {
      winnings *= 2; //  choosing Double increases winnings, but only allows for one card draw
      cost *= 2; // cost is also double, since bets are increased
      _player.add(_deck.draw());
      _dealer.add(_deck.draw());
      return reveal(choice);
    }
    else { // in case the Player is stubborn or dumb or clumsy and makes an incorrect choice
      System.out.println("\nYou've chosen an invalid choice. Please select again\n");
      return chooseaction();
    }
  }

// once Player chooses to stand, compare the hands of _dealer and _player
  public boolean win() {

    if (value(_dealer) > 21) { // if dealer busts, you win
      System.out.println("Dealer had : " + _dealer + "\n");
      System.out.println("Your hand was: " + _player + "\n");
      System.out.println("Dealer busted. Congrats!");
      return true;
    }

    else if (value(_player) > value(_dealer)) { // if value of hand is higher than _dealer, you win
      System.out.println("Dealer had : " + _dealer + "\n");
      System.out.println("Your hand was: " + _player + "\n");
      System.out.println("Congrats! You beat the dealer!");
      return true;
    }
    else { // otherwise, _dealer wins
      System.out.println("Dealer had : " + _dealer + "\n");
      System.out.println("Your hand was: " + _player + "\n");
      System.out.println("Dealer has beaten you. Sorry");
      return false;
    }
  }

  // play method runs the process of the game
  public void play() {

    System.out.println("Your hand is: " + _player + "\n"); // displays hand to the player

    System.out.println("The dealer has a: " + _dealer.get(0) + "\n"); // only shows the face up card of dealer to player


    if (value(_player) == 21){ // checks for initial Blackjack of _player
      System.out.println("You had a blackjack! \n");
      winnings *= 1.5;
      win = true;
    }

    else if (value(_dealer) == 21) { // check for initial Blackjack of _dealer
      System.out.println("You lost. The dealer had a blackjack! \n");
      win = false;
    }
    else if (chooseaction() == true) { // otherwise, start playing the game normally
      win = win();
    }

  }

}
