package Database;

public class Accounts {

	public double balance = 0;

	public Accounts() {
		balance = 0;

	}

	public Accounts(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void depositMoney(double d) {
		balance = getBalance() + d;
	}

	public void withdrawMoney(double d) {
		if ((getBalance() - d) < 0) {
			;
		} else if ((getBalance() - d >= 0)) {
			balance = getBalance() - d;
		}

	}

}
