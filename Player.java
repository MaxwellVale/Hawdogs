public class Player {

    // Instance Variables
    private String name;
    private int age;
    private double balance;
    // ******************

    //Default Constructor
    public Player() {
	setName("John Smith");
	setAge(21);
	balance = 100;
    }

    public Player(String inputName, int inputAge) {
	this();
	setName(inputName);
	setAge(inputAge);
    }

    // Methods
    
    public String getName() {
	return name;
    }

    public int getAge() {
	return age;
    }

    public double getBalance() {
	return balance;
    }

    public String setName(String newName) {
	String oldName = name;
	name = newName;
	return oldName;
    }

    public int setAge (int newAge) {
	int oldAge = age;
	age = newAge;
	return oldAge;
    }

    public double deposit (double amount) {
	double oldBalance = balance;
	balance += amount;
	return oldBalance;
    }

}//end class Player
