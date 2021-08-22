package Database;

public class Accounts {

	private final double balance;

	public Accounts(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void depositMoney(int amount) {
		newBalance(getBalance() + amount);
	}

	protected void newBalance(double d) {
	}

	public void withdrawMoney(int amount) {
		newBalance(getBalance() - amount);
	}
	
}
