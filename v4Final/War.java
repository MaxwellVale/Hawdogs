
import java.util.ArrayList;
import cs1.Keyboard;

public class War extends Game {

  private ArrayList<Card> _dealer = new ArrayList<Card>();
  private ArrayList<Card> _player = new ArrayList<Card>();
  private Deck _deck;
  private boolean win;
  private int flip;


  public War() {
    cost = 10.0;
    mult = 2.0;
    _deck = new Deck();

    String s;
    s = "Would you like to see the rules of the game? \n";
    s += "\t1: Yes\n";
    s += "\t2: No\n";
    System.out.println(s);

    int rules = cs1.Keyboard.readInt();

    if (rules == 1) {
      System.out.println(about());
    }
    else if (rules == 2) {
      System.out.println("\nAlright we get it, you're a pro...\n");
    }
    else {
      System.out.println("\nSomething tells me you're confused, so here are the rules anyway...\n");
      System.out.println(about());
    }

    play();
  }

  public String about() {
    String s;
    s = "\nWar is a very simplistic game, and can be one of the fastest way you can win money\n";
<<<<<<< HEAD
    s += "\nAt the start of every game, you and the dealer are dealt a random card, \nand you both will reveal their values.";
    s += "\nIf the value of your card is greater than the dealer, then you win! \nSimple as that.";
    s += "\nIf the dealer beats you, then you will lose, \nand have to play another round of War.";
    s += "\nIn the event that the value of your card is equal to the dealer's, \nyou are given two options:";
    s += "\nYou can either forfeit and receive half your bet, or go to War.";
    s += "\nYou will keep drawing cards, comparing them, all the way until \none of you has the higher card. Welcome to War.";
=======
    s += "\nAt the start of every game, you and the dealer are dealt a random card, and you both will reveal their values.";
    s += "\nIf the value of your card is greater than the dealer, then you win! Simple as that.";
    s += "\nIf the dealer beats you, then you will lose, and have to play another round of War.";
    s += "\nIn the event that the value of your card is equal to the dealer's, you are given two options:";
    s += "\nYou can either forfeit and receive half your bet, or go to War.";
    s += "\nYou will keep drawing cards, comparing them, all the way until one of you has the higher card. Welcome to War.";
>>>>>>> 38110d83fffc603d7e3d80939bdd4502699bf6ce
    return s;
  }

  public boolean getWin() {
    return win;
  }

  public boolean win() {
    Card player = _player.remove(0);
    Card dealer = _dealer.remove(0);

    win = false;
    if (value(player) == value(dealer)) {
      String s;
      s = "Would you like to risk war?\n";
      s += "\t1: Forfeit\n";
      s += "\t2: Go to War";
      System.out.println(s);
      int choice = cs1.Keyboard.readInt();

      if (choice == 1) {
        mult= 0.5;
        win = true;
      }
      else {
        play();
      }
    }
    else if (value(player) > value(dealer)) {
      win = true;
    }

    else if (value(player) < value(dealer)) {
      win = false;
    }
    winnings = mult * cost;
    return win;

  }

  public int value (Card card) {
    int actual;
    if (card.getRank() == 1) {
      actual = 14;
    }
    else {
      actual = card.getRank();
    }
    return actual;
  }

  public void play() {

    _player.add(_deck.draw());

    _dealer.add(_deck.draw());

    System.out.println("\nDealer has drawn a " + _dealer);

    String s;
    s = "Are you ready to reveal your card?\n";
    s += "\t1: Yes\n";
    s += "\t2: No\n";
    System.out.println(s);

    flip = cs1.Keyboard.readInt();

    if (flip == 1) {
      System.out.println("\nAlright, here we go.");
    }
    else if (flip == 2) {
      System.out.println("\nSorry, but I don't have all day. Let's just reveal now.");
    }
    else {
      System.out.println("\nYou're clearly confused. Revealing now is the best choice.");
    }


    System.out.println("\nYou drew a " + _player);


    if (win()) {
      System.out.println("\nCongrats! you have bested your opponent in combat");
    }
    else {
      System.out.println("\nYour opponent had the greater manpower. Sorry");
    }
  }
}
