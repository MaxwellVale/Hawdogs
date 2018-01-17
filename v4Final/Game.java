

public abstract class Game {

    protected double cost;

    protected double mult;

    protected double winnings;

    public double getCost(){
	return cost;
    }

    public double getMult(){
	return mult;
    }

    public double getWinnings(){
	return winnings;
    }
    
    public abstract String about();

    public abstract boolean win();

    public abstract void play();

}
