package Database;

public class Accounts {

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
		if ((getBalance() - amount) < 0) {
			;
		} else if ((getBalance() - amount >= 0)) {
			balance = getBalance() - amount;
		}

	}

}
