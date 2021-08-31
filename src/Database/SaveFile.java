package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SaveFile {
	static String UserTextFileName = User.getUsername() + ".txt";

	/**
	 * This creates the save file and save the Username and password
	 */
	public static void CreateFile() {
		String Username = User.getUsername();
		String Password = User.getPassword();

		try {
			File file = new File(UserTextFileName);
			if (file.createNewFile()) {
				System.out.println("File created:" + file.getName());
				FileWriter writer = new FileWriter(UserTextFileName);
				writer.write(Username + ", " + Password + "\n");
				writer.close();
			} else {
				System.out.println("File already exists");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * This saves the accounts information so that it can be retrieved if the
	 * account is accessed again
	 */
	public static void SaveAccounts() {

		Accounts Chequing = User.Chequing;
		Accounts Savings = User.Savings;
		Accounts LowRisk = User.LowRisk;
		Accounts HighRisk = User.HighRisk;

		try {
			FileWriter writer = new FileWriter(UserTextFileName, true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(Chequing + ": " + Chequing.getBalance());
			bw.newLine();
			bw.write(Savings + ": " + Savings.getBalance());
			bw.newLine();
			bw.write(LowRisk + ": " + LowRisk.getBalance());
			bw.newLine();
			bw.write(HighRisk + ": " + HighRisk.getBalance());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void SaveBills() {
		for (Bill bills : User.BillList) {
			try {
				FileWriter writer = new FileWriter(UserTextFileName, true);
				BufferedWriter bw = new BufferedWriter(writer);
				bw.write(User.BillList.indexOf(bills) + ". " + bills.getBillname() + ", " + bills.getBillFrequency()
						+ ", " + bills.getBillcost() + "\n");
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
