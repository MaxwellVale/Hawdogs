// Driver class for the Casino

import cs1.Keyboard;

public class CasinoDriver {

  // ***** Instance Variables *****

  private Player _p1;

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

    if (_p1.getAge() < 21 || _p1.getAge() > 99) {
      System.out.println("\nSorry, someone of your age does not belong in The HawDog Casino.");
      System.out.println("We are going to have to ask you to leave.");
    }
    else {
      System.out.println("\nWelcome, " + _p1.getName() + "!");
      System.out.println("Please enjoy your time in The HawDog Casino!");
    }

  }

  //********************

  public static void main (String args[]) {

    CasinoDriver game = new CasinoDriver();


  }// end main method

} // end class CasinoDriver
