package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import Database.*;

public class HighRiskViewController {
	// static so it doesn't change between scene changes
	static double balanceHighRisk = 0;
	Accounts HighRisk = new Accounts(balanceHighRisk);

	@FXML
	private Button GoBackButton;

	@FXML
	private TextField HighRiskDepositInput;

	@FXML
	public Button LowestInvestmentOptionButton;

	@FXML
	public Button HighInvestmentOptionButton;

	@FXML
	private Button HighRiskDepositButton;

	@FXML
	private Label InvestmentOptionOutput;

	@FXML
	public Button MiddleInvestmentOptionButton;

	@FXML
	private Label HighRiskTFSABalance;

	/**
	 * links with tester so can be run independently
	 */
	public void linkWithApplication(HighRiskViewTester highRiskViewTester) {

	}

	/**
	 * Appropriately changes buttons text to represent new balance values including
	 * rounding to 2 decimal places
	 **/
	public void setTextInvestmentOptionButton() {
		LowestInvestmentOptionButton.setText("$" + String.format("%.2f", balanceHighRisk * 0.12));
		MiddleInvestmentOptionButton.setText("$" + String.format("%.2f", balanceHighRisk * 0.18));
		HighInvestmentOptionButton.setText("$" + String.format("%.2f", balanceHighRisk * 0.24));
	}

	/**
	 * Deposits inputed amount of money into TFSA Removes user input after
	 * 
	 * @param event can be activated two ways: Clicking deposit Pressing Enter on
	 *              Keyboard Re-enables investment option buttons and adds text to
	 *              them
	 */
	@FXML
	void HighRiskDepositButtonClicked(ActionEvent event) {
		// Checks if input is negative
		// if so, displays error message and clears
		// previous input
		if (Double.parseDouble(HighRiskDepositInput.getText()) < 0) {
			InvestmentOptionOutput.setText("Cannot deposit negative number! Please try again.");
			HighRiskDepositInput.clear();
		} else {
			// Deposit method invoked from accounts class
			balanceHighRisk = balanceHighRisk + Double.parseDouble(HighRiskDepositInput.getText());
			// Prints current balance in High Risk
			setBalanceHighRisk(balanceHighRisk);
			// Removes previous User input
			HighRiskDepositInput.clear();

			// Reactivates option buttons after there is money in TFSA
			LowestInvestmentOptionButton.setDisable(false);
			MiddleInvestmentOptionButton.setDisable(false);
			HighInvestmentOptionButton.setDisable(false);

			// Resets Text in other buttons
			// while accounting for 2 decimal places
			setTextInvestmentOptionButton();

			// Checks if any button invests 0.00
			// if so, disables that button
			EmptyInvestmentCheck();
		}
	}

	/**
	 * Represents an investment of 12 percent Displays text output Changes balance
	 * of TFSA Changes Text of all 3 buttons appropriately based on current balance
	 */
	@FXML
	void LowInvestmentButtonClicked(ActionEvent event) {
		// Displays Amount used to invest
		InvestmentOptionOutput.setText("You have invested 12 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceHighRisk(balanceHighRisk - balanceHighRisk * 0.12);
		// Actually changes the balance
		balanceHighRisk = balanceHighRisk - balanceHighRisk * 0.12;

		// Resets Text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();

		// Checks if any button invests 0.00
		// if so, disables that button
		EmptyInvestmentCheck();
	}

	/**
	 * Represents an investment of 18 percent Displays text output Changes balance
	 * of TFSA Changes Text of all 3 buttons appropriately based on current balance
	 */
	@FXML
	void MiddleInvestmentButtonClicked(ActionEvent event) {
		// Displays Amount used to invest
		InvestmentOptionOutput.setText("You have invested 18 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceHighRisk(balanceHighRisk - balanceHighRisk * 0.18);
		// Actually changes the balance
		balanceHighRisk = balanceHighRisk - balanceHighRisk * 0.18;

		// Resets Text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();

		// Checks if any button invests 0.00
		// if so, disables that button
		EmptyInvestmentCheck();
	}

	/**
	 * Represents an investment of 24 percent Displays text output Changes balance
	 * of TFSA Changes Text of all 3 buttons appropriately based on current balance
	 */
	@FXML
	void HighInvestmentButtonClicked(ActionEvent event) {
		// Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 24 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceHighRisk(balanceHighRisk - balanceHighRisk * 0.24);
		// Actually changes the balance
		balanceHighRisk = balanceHighRisk - balanceHighRisk * 0.24;

		// Resets Text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();

		// Checks if any button invests 0.00
		// if so, disables that button
		EmptyInvestmentCheck();
	}

	/**
	 * Goes back to accounts tabs while retaining previous information
	 */
	@FXML
	void GoBackButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
		// creates a new loader
		FXMLLoader loader = new FXMLLoader();
		// sets the location of new loader to AccountsView
		loader.setLocation(getClass().getResource("/Views/AccountsView.fxml"));
		// loads loader so methods can be accessed
		Parent AccountViewParent = loader.load();

		// sets scene
		Scene AccountViewScene = new Scene(AccountViewParent);

		// access AccountsViewController
		AccountsViewController accounts = loader.getController();

		// sets balance to previous amounts
		accounts.setBalanceChequing(accounts.getChequingBalance());
		accounts.setBalanceSavings(accounts.getSavingsBalance());

		// sets username to previous name
		accounts.setUsername(AccountsViewController.Username);

		// Gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// Sets Scene and shows upon button press
		window.setScene(AccountViewScene);
		window.show();
	}

	/**
	 * Sets balance of TFSA based on
	 * 
	 * @param amount while also rounding to 2 decimal places
	 */
	public void setBalanceHighRisk(double amount) {
		// Rounds to 2 decimal places
		HighRiskTFSABalance.setText(String.format("%.2f", amount));
	}

	/**
	 * Checks if any investment option is 0 if so, disables the button
	 */
	public void EmptyInvestmentCheck() {
		// Creates an array of object Buttons
		// so they can be iterated through quickly
		Button[] investmentButtons = { LowestInvestmentOptionButton, MiddleInvestmentOptionButton,
				HighInvestmentOptionButton };
		// Iterates through Button list
		for (int i = 0; i < investmentButtons.length; i++) {
			// Checks if Buttons are 0
			// if so, clears them and disables them
			if (investmentButtons[i].getText().equals("$0.00") || investmentButtons[i].getText().equals(null)
					|| investmentButtons[i].getText().equals("")) {
				investmentButtons[i].setDisable(true);
				investmentButtons[i].setText("");
			} else {
				investmentButtons[i].setDisable(false);
			}
		}
	}
}
