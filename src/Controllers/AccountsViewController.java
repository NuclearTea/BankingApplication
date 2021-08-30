package Controllers;

import Database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountsViewController implements Initializable {
	// Username equals previously created User's Username
	static String Username = User.getUsername();

	// Creats Local accounts to be linked with User created in login in screen in
	// initializable
	static Accounts Chequing = new Accounts();
	static Accounts Savings = new Accounts();

	@FXML
	private TextField WithdrawMoneyInputChequing;

	@FXML
	public Label UsernameLabel2;

	@FXML
	private Label SavingsAccountBalanceLabel1;

	@FXML
	private Button LogOutButton;

	@FXML
	private Button DepositButtonChequing;

	@FXML
	public Label UsernameLabel;

	@FXML
	public Label SavingsOutput;

	@FXML
	private Label ChequingAccountBalanceLabel;

	@FXML
	private Button LogOutButton2;

	@FXML
	private TextField DepositMoneyInputSavings;

	@FXML
	private TextField WithdrawMoneyInputSavings;

	@FXML
	private Button DepositButtonSavings;

	@FXML
	private Button WithdrawButtonSavings;

	@FXML
	private Button WithdrawButtonChequing;

	@FXML
	private Button LogOutButton3;

	@FXML
	private TextField DepositMoneyInputChequing;

	@FXML
	private Button HighRiskButton;

	@FXML
	private Button LowRiskButton;

	@FXML
	private Label ErrorOutputLabelChequing;

	@FXML
	public Label ChequingOutput;

	@FXML
	private Button Bills;

	/**
	 * Links with Tester
	 */
	public void linkWithApplication(AccountsViewTester accountsViewTester) {

	}

	/**
	 * Method that updates balance label every time a transaction is made used for
	 * Chequing. Always rounds to 2 decimal places.
	 */
	public void setBalanceChequing(double amount) {
		// Rounds to 2 decimal places
		ChequingAccountBalanceLabel.setText(String.format("%.2f", amount));
	}

	/**
	 * Method that updates balance label every time a transaction is made used for
	 * Savings. Always rounds to 2 decimal places
	 */
	public void setBalanceSavings(double amount) {
		// Rounds to 2 decimal places
		SavingsAccountBalanceLabel1.setText(String.format("%.2f", amount));
	}

	/**
	 * Displays Username to @param name
	 * 
	 * @throws IOException
	 */
	public void setUsername(String name) throws IOException {

		UsernameLabel.setText(Username);
		UsernameLabel2.setText(Username);
	}

	/**
	 * Gets Username and returns string
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * Goes to Bill view
	 */
	@FXML
	void BillsButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
		FXMLLoader loader = new FXMLLoader();
		// sets location of loader to BillView
		loader.setLocation(getClass().getResource("/Views/BillView.fxml"));

		// loads Bill Viiew
		Parent BillViewParent = loader.load();

		// Sets scene
		Scene BillViewScene = new Scene(BillViewParent);

		// Creates an instance of the controller so methods can be accessed
		BillViewController bill = loader.getController();

		// sets table view items
		bill.tableView.setItems(BillViewController.bill);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Sets scene and shows upon button press
		window.setScene(BillViewScene);
		window.show();
	}

	/**
	 * Access Accounts Class from Database package and Deposits money into account
	 * Two ways to call: First: Press Button Second: User presses enter
	 */
	@FXML
	void DepositButtonClickedChequing(ActionEvent event) {
		// Checks if input is negative
		// if so, gives error message
		if (Double.parseDouble(DepositMoneyInputChequing.getText()) < 0) {
			ChequingOutput.setText("You cannot input a negative number! Please try again.");
			DepositMoneyInputChequing.clear();
		} else {

			User.Chequing.depositMoney(Double.parseDouble(DepositMoneyInputChequing.getText()));

			setBalanceChequing(User.Chequing.getBalance());

			// Removes user previous input
			DepositMoneyInputChequing.clear();
		}
	}

	/**
	 * Access Accounts Class from Database package and Withdraws money from account
	 * Two ways to call: First: Press Button Second: User presses enter
	 */
	@FXML
	void WithdrawButtonClickedChequing(ActionEvent event) {
		// Checks if input is negative
		// if so, gives error message
		if (Double.parseDouble(WithdrawMoneyInputChequing.getText()) < 0) {
			ChequingOutput.setText("You cannot input a negative number! Please try again.");
			WithdrawMoneyInputChequing.clear();
		} else {
			// Checks if you can withdraw more money than you have
			if (User.Chequing.getBalance() - Double.parseDouble(WithdrawMoneyInputChequing.getText()) < 0) {
				ChequingOutput.setText("You are taking out more money than you have! Please try again.");
				WithdrawMoneyInputChequing.clear();
			} else {

				User.Chequing.withdrawMoney(Double.parseDouble(WithdrawMoneyInputChequing.getText()));

				setBalanceChequing(User.Chequing.getBalance());

				// removes user previous input
				WithdrawMoneyInputChequing.clear();
			}
		}
	}

	/**
	 * Goes back to User Info Screen
	 * Saves Information about Accounts in User Text File
	 */
	@FXML
	void LogOut(ActionEvent event) throws FileNotFoundException, IOException {
		SaveFile.SaveAccounts();
		FXMLLoader loader = new FXMLLoader();
		// Access UserInfoView fxml file to set new scene
		Parent UserInfoViewParent = (Parent) loader.load(new FileInputStream("src/Views/UserInfoView.fxml"));

		// Sets scene
		Scene UserInfoViewScene = new Scene(UserInfoViewParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Sets scene and shows upon button press
		window.setScene(UserInfoViewScene);
		window.show();
	}

	/**
	 * Access Accounts Class from Database package and Deposits money into account
	 * Two ways to call: First: Press Button, Second: User presses enter
	 */
	@FXML
	void DepositButtonClickedSavings(ActionEvent event) {
		// Checks if input is negative
		// if so, gives error message
		if (Double.parseDouble(DepositMoneyInputSavings.getText()) < 0) {
			SavingsOutput.setText("You cannot input a negative number! Please try again.");
			DepositMoneyInputSavings.clear();
		} else {

			User.Savings.depositMoney(Double.parseDouble(DepositMoneyInputSavings.getText()));

			setBalanceSavings(User.Savings.getBalance());

			// Removes user previous input
			DepositMoneyInputSavings.clear();
		}
	}

	/**
	 * Access Accounts Class from Database package and Withdraws money from account
	 * Two ways to call: First: Press Button, Second: User presses enter
	 */
	@FXML
	void WithdrawButtonClickedSavings(ActionEvent event) {
		// Checks if input is negative
		// if so, gives error message
		if (Double.parseDouble(WithdrawMoneyInputSavings.getText()) < 0) {
			SavingsOutput.setText("You cannot input a negative number! Please try again.");
			WithdrawMoneyInputSavings.clear();
		} else {
			// Checks if withdrawing more money than possible including the interest
			if (User.Savings.getBalance() * 1.05 - Double.parseDouble(WithdrawMoneyInputSavings.getText()) < 0) {
				SavingsOutput.setText("You are taking out more money than you have! Please try again.");
				WithdrawMoneyInputSavings.clear();
			} else {
				User.Savings.balance = User.Savings.getBalance() * 1.05
						- Double.parseDouble(WithdrawMoneyInputSavings.getText());

				setBalanceSavings(User.Savings.getBalance());
				// Removes user previous input
				WithdrawMoneyInputSavings.clear();
				// Displays that Interest was applied
				SavingsOutput.setText("5% interest was applied to the balance before withdrawing.");
			}
		}
	}

	/**
	 * Changes Screen to Low Risk page
	 */
	@FXML
	void LowRiskButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
		// creates a new loader
		FXMLLoader loader = new FXMLLoader();
		// sets the location of the new loader to LowRiskView
		loader.setLocation(getClass().getResource("/Views/LowRiskView.fxml"));
		// loads loader so methods can be accessed
		Parent LowRiskViewParent = loader.load();

		// sets scene
		Scene LowRiskViewScene = new Scene(LowRiskViewParent);

		// access LowRiskViewController
		LowRiskViewController lowRisk = loader.getController();

		// sets balance to the balance inside lowRisk
		lowRisk.setBalanceLowRisk(User.LowRisk.getBalance());
		// sets values inside buttons
		lowRisk.setTextInvestmentOptionButton();

		// if balance of LowRisk is 0, will keep buttons disabled
		// and buttons are clear
		// but if greater, activates
		lowRisk.EmptyInvestmentCheck();

		// Gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// Sets Scene and shows upon button press
		window.setScene(LowRiskViewScene);
		window.show();
	}

	/**
	 * Changes Screen to High Risk page
	 */
	@FXML
	void HighRiskButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
		// creates a new loader
		FXMLLoader loader = new FXMLLoader();
		// sets the location of the new loader to LowRiskView
		loader.setLocation(getClass().getResource("/Views/HighRiskView.fxml"));
		// loads loader so methods can be accessed
		Parent HighRiskViewParent = loader.load();

		// sets scene
		Scene LowRiskViewScene = new Scene(HighRiskViewParent);

		// access LowRiskViewController
		HighRiskViewController highRisk = loader.getController();

		// sets balance to the balance inside lowRisk
		highRisk.setBalanceHighRisk(User.HighRisk.getBalance());
		// sets values inside buttons
		highRisk.setTextInvestmentOptionButton();

		// if balance of LowRisk is 0, will keep buttons disabled
		// and buttons are clear
		// but if greater, activates
		highRisk.EmptyInvestmentCheck();

		// Gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// Sets Scene and shows upon button press
		window.setScene(LowRiskViewScene);
		window.show();
	}

	/**
	 * Links Accounts to user created in UserInfo initially so those accounts can be
	 * used
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		AccountsViewController.Chequing = User.Chequing;
		AccountsViewController.Savings = User.Savings;

	}

}
