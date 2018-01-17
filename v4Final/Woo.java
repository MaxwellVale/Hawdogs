// Driver class for the Casino

import cs1.Keyboard;

public class Woo {

    // ***** Instance Variables *****

    private Player _p1;

    private int _area;
    private int _game;

    // ****************************

    // ***** Default Constructor *****

    public Woo() {
	enterCasino();
    }

    // *****************************

    // ***** Methods *****

    public void enterCasino() {

	String s;
	String playerName;
	int playerAge;

	s = "\n *** Welcome to The HawDog Casino! ***\n";
	s += "First, may we have your ID?\n";
	s += "(Handing over ID...)\n";
	s += "So tell me, what is your name, fellow CSer? ";

	System.out.println(s);

	playerName = cs1.Keyboard.readString();

	s = "\nThank you very much.\n";
	s += "Now, what is your age? ";

	System.out.println(s);


	playerAge = cs1.Keyboard.readInt();

	_p1 = new Player(playerName, playerAge);

	if (_p1.getAge() == Integer.MIN_VALUE) {
	    System.out.println("Please provide valid Identification...");
	    enterCasino();
	}
	else if (_p1.getAge() < 21 || _p1.getAge() > 100) {
	    System.out.println("\nSorry, someone of your age does not belong in The HawDog Casino.");
	    System.out.println("We are going to have to ask you to leave.");
	}
	else {
	    System.out.println("\nWelcome, " + _p1.getName() + "!");
	    System.out.println("Please enjoy your time in The HawDog Casino!\n");
	    System.out.println("Entering the casino.....");
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    areaSelect();
	}

    }

    public void areaSelect() {

	String s;
	s = "\nWhere would you like to go? \n";
	s += "\t1: Games\n";
	s += "\t2: Leave (if you've had enough for today)\n";
	s += "\nWhere would you like to go? ";
	System.out.println(s);

	_area = cs1.Keyboard.readInt();

	if (_area == 1) {
	    gameSelect();
	}
	else {
	    leave();
	}
    }

    public void gameSelect() {
	System.out.println("You have chosen to go to the game area.");
	String s;
	s = "\nPlease choose a game to play\n";
	s += "\t1: Keno\n";
	s += "\t2: Blackjack\n";
	System.out.println(s);

	_game = cs1.Keyboard.readInt();

	if (_game == 1) {
	    playKeno();
	}
	else if (_game == 2) {
	    playBlackjack();
	}
	areaSelect();

    }

    public void leave() {
	System.out.println("You have chosen to leave (but why tho?)");
    }

    public void playKeno() {
      
	System.out.println("You are now playing Keno.");
	Keno newGame = new Keno();

	if (newGame.getCost() > _p1.getBalance()) {
	    System.out.println("Sorry, you don't have enough money to play this game...");
	    gameSelect();
	}
	else {
	    double earning = newGame.getWinnings();
	    System.out.println("You have won " + earning);
	    _p1.deposit(earning);
	    _p1.deposit(newGame.getCost() * -1);
	    System.out.println("Current Balance is now " + _p1.getBalance());
	}

    }

    public void playBlackjack() {
	System.out.println("You are now playing Blackjack.");
	Blackjack newGame = new Blackjack();

	if (newGame.getCost() > _p1.getBalance()) {
	    System.out.println("Sorry, you don't have enough money to play this game....");
	    gameSelect();
	}
	else {

	    double earning = (newGame.getMult() * 10);
	    System.out.println("You have won " + (earning));
	    _p1.deposit(earning);
	    _p1.deposit(newGame.getCost() * -1);
	    System.out.println("Current Balance is now " + _p1.getBalance());
	}
	
    }

    //********************

    public static void main (String args[]) {

	Woo game = new Woo();

    }// end main method

} // end class Woo
