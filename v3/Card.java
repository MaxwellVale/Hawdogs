public class Card {

    private int rank, suit;

    private static String[] suits = {"Heart", "Spades", "Diamonds", "Clubs"};
    private static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

    public Card(int suit, int rank) {
	this.suit = suit;
	this.rank = rank;
    }

    public String toString() {
	return ranks[rank] + " of " + suits[suit];
    }

    public int getRank() {
	return rank;
    }

    public int getSuit() {
	return suit;
    }
}