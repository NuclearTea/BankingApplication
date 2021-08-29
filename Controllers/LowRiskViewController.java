package Controllers;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Database.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LowRiskViewController implements Initializable {
	// static so it doesn't change between scene changes
	static Accounts LowRisk = new Accounts();

	@FXML
	private Button GoBackButton;

	@FXML
	private TextField LowRiskDepositInput;

	@FXML
	private Label LowRiskTFSABalance;

	@FXML
	private Button LowRiskDepositButton;

	@FXML
	public Button LowestInvestmentOptionButton;

	@FXML
	public Button HighInvestmentOptionButton;

	@FXML
	private Label InvestmentOptionOutput;

	@FXML
	public Button MiddleInvestmentOptionButton;

	/**
	 * Sets balance of TFSA based on
	 * 
	 * @param amount while also rounding to 2 decimal places
	 */
	public void setBalanceLowRisk(double amount) {
		LowRiskTFSABalance.setText(String.format("%.2f", amount));
	}

	/**
	 * links with tester so it can be run independently
	 */
	public void LinkWithApplication(LowRiskViewTester lowRiskViewTester) {

	}

	/**
	 * Appropriately changes buttons text to represent new balance values including
	 * rounding to 2 decimal places
	 **/
	public void setTextInvestmentOptionButton() {
		LowestInvestmentOptionButton.setText("$" + String.format("%.2f", LowRisk.balance * 0.025));
		MiddleInvestmentOptionButton.setText("$" + String.format("%.2f", LowRisk.balance * 0.0625));
		HighInvestmentOptionButton.setText("$" + String.format("%.2f", LowRisk.balance * 0.10));
	}

	/**
	 * Deposits inputed amount of money into TFSA Removes user input after
	 * 
	 * @param event can be activated two ways: Clicking deposit Pressing Enter on
	 *              keyboard Re-enables investment option buttons and adds text to
	 *              them
	 */
	@FXML
	void LowRiskDepositButtonClicked(ActionEvent event) {
		// Checks if input is negative
		// if so, displays error message and clears
		// previous input
		if (Double.parseDouble(LowRiskDepositInput.getText()) < 0) {
			InvestmentOptionOutput.setText("Cannot deposit negative number! Please try again.");
			LowRiskDepositInput.clear();
		} else {
			// Deposit method invoked from accounts class
			LowRisk.balance = LowRisk.balance + Double.parseDouble(LowRiskDepositInput.getText());
			// Prints current balance in Low Risk
			setBalanceLowRisk(LowRisk.balance);
			// Removes previous User input
			LowRiskDepositInput.clear();

			// Reactivates option buttons after there is money in TFSA
			LowestInvestmentOptionButton.setDisable(false);
			MiddleInvestmentOptionButton.setDisable(false);
			HighInvestmentOptionButton.setDisable(false);

			// Resets Text in other buttons
			// while accounting for 2 decimal places
			setTextInvestmentOptionButton();
		}
	}

	/**
	 * Represents an investment of 2.5 percent Displays text output Changes balance
	 * of TFSA Changes text of all 3 buttons appropriately based on current balance
	 */
	@FXML
	void LowInvestmentButtonClicked(ActionEvent event) {
		// Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 2.5 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceLowRisk(LowRisk.balance - LowRisk.balance * 0.025);
		// Actually changes the balance
		LowRisk.balance = LowRisk.getBalance() - LowRisk.balance * 0.025;

		// Resets text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();

		// Checks if any button invests 0.00
		// if so, disables that button
		EmptyInvestmentCheck();
	}

	/**
	 * Represents an investment of 6.25 percent Displays text output Changes balance
	 * of TFSA Changes text of all 3 buttons appropriately based on current balance
	 */
	@FXML
	void MiddleInvestmentButtonClicked(ActionEvent event) {
		// Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 6.25 percent of your TFSA balance");
		// Changes the balance displayed on screen
		setBalanceLowRisk(LowRisk.getBalance() - LowRisk.getBalance() * 0.0625);
		// Actually changes the balance
		LowRisk.balance = LowRisk.getBalance() - LowRisk.getBalance() * 0.0625;

		// Resets text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();

		// Checks if any button invests 0.00
		// if so, disables that button
		EmptyInvestmentCheck();
	}

	/**
	 * Represents an investment of 10 percent Displays text output Changes balance
	 * of TFSA Changes text of all 3 buttons appropriately based on current balance
	 */
	@FXML
	void HighInvestmentButtonClicked(ActionEvent event) {
		// Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 10 percent of your TFSA balance");
		// Changes the balance displayed on screen
		setBalanceLowRisk(LowRisk.getBalance() - LowRisk.getBalance() * 0.10);
		// Actually changes the balance
		LowRisk.balance = LowRisk.getBalance() - LowRisk.getBalance() * 0.10;

		// Resets text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();

		// Checks if any button invests 0.00
		// if so, disables that button
		EmptyInvestmentCheck();
	}

	/**
	 * goes back to accounts tabs while retaining previous information
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
		accounts.setBalanceChequing(User.Chequing.getBalance());
		accounts.setBalanceSavings(User.Savings.getBalance());

		// sets username to previous name
		accounts.setUsername(User.getUsername());

		// Gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// Sets Scene and shows upon button press
		window.setScene(AccountViewScene);
		window.show();

	}

	/**
	 * Checks if any investment option is 0 if so, disables the button
	 */
	public void EmptyInvestmentCheck() {
		// Creates an array of object buttons
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LowRiskViewController.LowRisk = User.LowRisk;
		
	}

}
