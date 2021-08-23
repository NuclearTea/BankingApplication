package Database;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class User {
	public UserInfo UserInfo;
	public ArrayList<Accounts> AccountsList;
	public ArrayList<Bill> BillList;

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return UserInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		UserInfo = userInfo;
	}

	/**
	 * @return the accountsList
	 */
	public ArrayList<Accounts> getAccountsList() {
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
	public ArrayList<Bill> getBillList() {
		return BillList;
	}

	/**
	 * @param billList the billList to set
	 */
	public void setBillList(ArrayList<Bill> billList) {
		BillList = billList;
	}

	public User() {

	}

	public User(UserInfo userInfo) {
		this.UserInfo = userInfo;
	}

	public User(ArrayList<Bill> billList) {
		this.BillList = billList;
	}

	public User(UserInfo UserInfo, ArrayList<Accounts> AccountsList, ArrayList<Bill> BillList) {
		this.UserInfo = UserInfo;
		this.AccountsList = AccountsList;
		this.BillList = BillList;

	}

	public void SavingUser(String FileName) throws FileNotFoundException, UnsupportedEncodingException {
		User.this.getUserInfo();
		String Username = Database.UserInfo.getUsername();
		String Password = Database.UserInfo.getPassword();

		PrintWriter writer = new PrintWriter(FileName, "UTF-8");
		writer.println(Username);
		writer.println(Password);
		for (Accounts accounts : User.this.getAccountsList()) {
			writer.println(accounts);
		}
		for (Bill bills : User.this.getBillList()) {
			writer.println(bills);
		}
		writer.close();
	}

}
