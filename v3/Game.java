

public abstract class Game {

    protected double cost;

    protected double mult;
    
    public double getCost(){
	return cost;
    }

    public double getMult(){
	return mult;
    }
    
    public abstract String about();

    public abstract boolean win();

    public abstract void play();

}
