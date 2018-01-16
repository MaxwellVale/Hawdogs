import java.util.Random;
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
	cards = new ArrayList<Card>();
	for (int suit=0; suit<=3; suit++) {
	    for (int rank=0; rank<=12; rank++) {
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