package Database;

public class Accounts extends User{

	public double balance;

	public Accounts(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void depositMoney(int amount) {
		balance = getBalance() + amount;
	}

	public void withdrawMoney(int amount) {
		balance = getBalance() - amount;
	}

}
