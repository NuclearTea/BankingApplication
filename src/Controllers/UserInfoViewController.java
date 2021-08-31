package Controllers;

import Database.*;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
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

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInfoViewController {
	// public so it can be accessed outside this class
	// static so it does not change in between scene changes
	public static String Username;

	@FXML
	public TextField UsernameInput;

	@FXML
	private Label ActionTextOutput;

	@FXML
	private Button ResetButton;

	@FXML
	public TextField PasswordInput;

	@FXML
	private Button EnterButton;

	/**
	 * Clears Username and password input and displays message
	 */
	@FXML
	void ResetButtonClicked(ActionEvent event) {
		UsernameInput.clear();
		PasswordInput.clear();
		ActionTextOutput.setText("Your information has been Reset, please enter information.");
	}

	/**
	 * Saves user input for username and password, Changes Scene to access accounts
	 * with different functionalities, Does some error handling: Same Username &
	 * Password, did not fill in response
	 */
	@FXML
	void EnterButtonClicked(ActionEvent event) throws IOException {

		Username = UsernameInput.getText();
		// Check whether Username and password are the same
		// If so, Prompts the user to try again
		if (UsernameInput.getText().equals(PasswordInput.getText()) && UsernameInput.getLength() > 0
				&& PasswordInput.getLength() > 0) {
			ActionTextOutput.setText("Your Username and Password are the same. Please make them different!");
		}

		// Checks if one of the boxes is empty, if so, prompts the user to fill in
		// remaining box
		else if (UsernameInput.getLength() == 0 || PasswordInput.getLength() == 0) {
			ActionTextOutput.setText("Either your Username or Password are empty. Please fill it out.");
			// Clears text fields
			PasswordInput.clear();
			UsernameInput.clear();
		} else {
			Accounts Chequing = new Accounts();
			Accounts Savings = new Accounts();
			Accounts LowRisk = new Accounts();
			Accounts HighRisk = new Accounts();
			ArrayList<Bill> BillList = new ArrayList<Bill>();
			new User(Username, PasswordInput.getText(), Chequing, Savings, LowRisk, HighRisk, BillList);
			SaveFile.CreateFile();
			
			
			
			
			
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
			
			// calls method to set display user name
			accounts.setUsername(Username);
			
			// call method to set Chequing Balance
			accounts.setBalanceChequing(User.Chequing.getBalance());
			
			// call method to set Savings Balance
			accounts.setBalanceSavings(User.Savings.getBalance());

			// Gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			// Sets Scene and shows upon button press
			window.setScene(AccountViewScene);
			window.show();
		}
	}

	/**
	 * links with tester so it can be run independently
	 */
	public void linkWithApplication(UserInfoViewTester userInfoViewTester) {

	}

	/**
	 * Links with main application named BankingApplication
	 */
	public void linkWithApplication(BankingApplication bankingApplication) {

	}

}
