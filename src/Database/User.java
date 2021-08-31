package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class User {
	public static String Username;
	public static String Password;
	public static Accounts Chequing;
	public static Accounts Savings;
	public static Accounts LowRisk;
	public static Accounts HighRisk;
	public static Bill Bill;

	public static ArrayList<Accounts> AccountsList;
	public static ArrayList<Bill> BillList;

	public User(String Username, String Password) {
		User.Username = Username;
		User.Password = Password;
	}

//	public User(ArrayList<Accounts> list) {
//		for (Accounts accounts : list) {
//			AccountsList.add(accounts);
//		}
//	}

	/**
	 * @return the bill
	 */
	public static Bill getBill() {
		return Bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public static void setBill(Bill bill) {
		Bill = bill;
	}

	public User(String Username, String Password, Accounts Chequing, Accounts Savings, Accounts LowRisk,
			Accounts HighRisk, ArrayList<Bill> BillList) {
		User.Username = Username;
		User.Password = Password;
		User.Chequing = Chequing;
		User.Savings = Savings;
		User.LowRisk = LowRisk;
		User.HighRisk = HighRisk;
		User.BillList = BillList;
	}

	public User(String Username, String Password, Accounts Chequing, Accounts Savings, Accounts LowRisk,
			Accounts HighRisk) {
		User.Username = Username;
		User.Password = Password;
		User.Chequing = Chequing;
		User.Savings = Savings;
		User.LowRisk = LowRisk;
		User.HighRisk = HighRisk;

	}

	public User(Accounts Chequing, Accounts Savings) {
		User.Chequing = Chequing;
		User.Savings = Savings;
	}

	/**
	 * @return the username
	 */
	public static String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the accountsList
	 */
	public static ArrayList<Accounts> getAccountsList() {
		return AccountsList;
	}

	/**
	 * @param accountsList the accountsList to set
	 */
	public void setAccountsList(ArrayList<Accounts> accountsList) {
		AccountsList = accountsList;
	}

	/**
	 * @return the billList
	 */
	public static ArrayList<Bill> getBillList() {
		return BillList;
	}

	/**
	 * @param billList the billList to set
	 */
	public void setBillList(ArrayList<Bill> billList) {
		BillList = billList;
	}

	/**
	 * @return the chequing
	 */
	public static Accounts getChequing() {
		return Chequing;
	}

	/**
	 * @param chequing the chequing to set
	 */
	public static void setChequing(Accounts chequing) {
		Chequing = chequing;
	}

	/**
	 * @return the savings
	 */
	public static Accounts getSavings() {
		return Savings;
	}

	/**
	 * @param savings the savings to set
	 */
	public static void setSavings(Accounts savings) {
		Savings = savings;
	}

	/**
	 * @return the lowRisk
	 */
	public static Accounts getLowRisk() {
		return LowRisk;
	}

	/**
	 * @param lowRisk the lowRisk to set
	 */
	public static void setLowRisk(Accounts lowRisk) {
		LowRisk = lowRisk;
	}

	/**
	 * @return the highRisk
	 */
	public static Accounts getHighRisk() {
		return HighRisk;
	}

	/**
	 * @param highRisk the highRisk to set
	 */
	public static void setHighRisk(Accounts highRisk) {
		HighRisk = highRisk;
	}

}
