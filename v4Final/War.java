
import java.util.ArrayList;
import cs1.Keyboard;

public class War extends Game {

    private ArrayList<Card> _dealer = new ArrayList<Card>();
    private ArrayList<Card> _player = new ArrayList<Card>();
    private Deck _deck;
    
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

    play();
}

public String about() {
    String s;
    s = "\nWar is a very simplistic game, and can be one of the fastest way you can win money\n";
    s += "\nAt the start of every game, you and the dealer are dealt a random card, and you both will reveal their values.";
    s += "\nIf the value of your card is greater than the dealer, then you win! Simple as that.";
    s += "\nIf the dealer beats you, then you will lose, and have to play another round of War.";
    s += "\nIn the event that the value of your card is equal to the dealer's, you are given two options:";
    s += "\nYou can either forfeit and receive half your bet, or got to War.";
    s += "\nYou will keep drawing cards, comparing them, all the way until one of you has the higher card. Welcome to War.";
    return s;
}

public boolean win() {
    Card player = _player.remove(0);
    Card dealer = _dealer.remove(0);

    boolean win = false;
    if (player.getRank() == dealer.getRank()) {
	String s;
	s = "Would you like to risk war?\n";
	s += "\t1: Forfeit\n";
	s += "\t2: Go to War";
	System.out.println(s);
	int choice = cs1.Keyboard.readInt();

	if (choice == 1) {
	    mult = 0.5;
	    win = true;
	}
	else {
	    play();
	}
    }
    else if (player.getRank() > dealer.getRank()) {
	win = true;
    }

    else if (player.getRank() < dealer.getRank()) {
	win = false;
    }
    return win;

}

public void play() {

    _player.add(_deck.draw());

    _dealer.add(_deck.draw());

    System.out.println("You drew a " + _player);
    System.out.println("Dealer has drawn a " + _dealer);

    if (win()) {
	System.out.println("Congrats! you have bested your opponent in combat");
    }
    else {
	System.out.println("Your opponent had the greater manpower. Sorry");
    }
}
}
