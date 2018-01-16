

import java.util.ArrayList;
import cs1.Keyboard;

public class Blackjack extends Game {

    private ArrayList<Card> _dealer;
    private ArrayList<Card> _player;
    private Deck _deck;

    public Blackjack() {
	cost = 10;
	_deck = new Deck();

	_player.add(_deck.draw());
	_player.add(_deck.draw());
	System.out.println("Your hand is: " + _player + "\n");

	_dealer.add(_deck.draw());
	_dealer.add(_deck.draw());	
	System.out.println("The dealer has a: " + _dealer.get(0) + "\n");	
	play();
	
	

    }

    public int value(ArrayList<Card> hand){
	int sum = 0;
	for (int i = 0; i < hand.size(); i++){
	    if ((hand.get(i)).getRank == "Ace"){
		sum += 11; }
	    else if ((hand.get(i)).getRank == "Jack"){
		sum += 10; }
	    else if ((hand.get(i)).getRank == "King"){
		sum += 10; }
	    else if ((hand.get(i)).getRank == "Queen"){
		sum += 10; }
	    else{
		sum += (hand.get(i)).getrank;}
	}
	return sum;
    }
    
    public void play() {
	if (value(_player) == 21){
	    System.out.println("You had a blackjack! \n");	    
	    win();
	}
	if (value(_dealer) == 21){
	    System.out.println("You lost. The dealer had a blackjack! \n");


	    // Here the player gets to choose what to do :
	    /*      Stand: Do nothing
		    Hit: They enter a number and draw that many cards
		    Double: Double their bet and draw 1 card
		    Split: If both cards in their hand are the same value, they can split it into two hands and draw a card for each hand, then act again.
	    */

	    /* After this : 
	       If player has value > 21, lose
	       If dealer had value < 16, dealer draws
	       If dealer has value > 21, win
	       Else, whoever had > value wins

	       No need for a loop there is only one "turn"
	    */
    }

}
