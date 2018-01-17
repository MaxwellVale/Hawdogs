import java.util.Random;
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
	cards = new ArrayList<Card>();
	for (int suit=1; suit<=4; suit++) {
	    for (int rank=1; rank<=13; rank++) {
		cards.add(new Card(suit, rank));
	    }
	}
    }

    public Card draw() {
	Random generator =  new Random();
	int index = generator.nextInt( cards.size() );
	return cards.remove(index);
    }

    public int totalCards() {
	return cards.size();
    }

    public static void main(String[] args) {
    }
}
