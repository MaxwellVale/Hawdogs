// Driver class for the Casino

import cs1.Keyboard;

public class CasinoDriver {

  // ***** Instance Variables *****

  private Player _p1;

  private int _area;
  private int _game;

  // ****************************

  // ***** Default Constructor *****

  public CasinoDriver() {
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
    s += "\t2: Ye Olde Shoppe\n";
    s += "\t3: Leave (if you've had enough for today)\n";
    s += "\nWhere would you like to go? ";
    System.out.println(s);

    _area = cs1.Keyboard.readInt();

    if (_area == 1) {
      gameSelect();
    }
    else if (_area == 2) {
      shop();
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
    System.out.println(s);

    _game = cs1.Keyboard.readInt();

    if (_game == 1) {
      playKeno();
    }

    areaSelect();

  }

  public void shop() {
    System.out.println("You have chosen to go to Ye Olde Shoppe.");
    areaSelect();
  }

  public void leave() {
    System.out.println("You have chosen to leave (but why tho?)");
  }

  public void playKeno() {
    System.out.println("You are now playing Keno.");
    Keno newGame = new Keno();

  }

  //********************

  public static void main (String args[]) {

    CasinoDriver game = new CasinoDriver();

  }// end main method

} // end class CasinoDriver
