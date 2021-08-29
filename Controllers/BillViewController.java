package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Database.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BillViewController implements Initializable {
	public static ObservableList<Bill> bill = FXCollections.observableArrayList();
	private static ArrayList<Bill> BillsArrayList = new ArrayList<Bill>();

	@FXML
	private Button GoBackButton;
	@FXML
	private TextField BillFrequencyInput;
	@FXML
	private TextField BillNameInput;
	@FXML
	private Button ResetButton;
	@FXML
	private Button SubmitButton;
	@FXML
	private TextField BillCostInput;
	@FXML
	public TableView<Bill> tableView;
	@FXML
	private TableColumn<Bill, String> BillNameColumn;
	@FXML
	private TableColumn<Bill, Double> BillPriceColumn;
	@FXML
	private TableColumn<Bill, Double> BillFrequencyColumn;

	public ObservableList<Bill> getBill() {
		return bill;
	}

	/**
	 * links with tester so it can be run independently
	 */
	public void linkWithApplication(BillViewTester billViewTester) {

	}

	/**
	 * Clears User inputs
	 */
	@FXML
	void ResetButtonClicked(ActionEvent event) {
		BillNameInput.clear();
		BillCostInput.clear();
		BillFrequencyInput.clear();

	}

	/**
	 * 
	 * linking submit with creating new table element
	 */
	@FXML
	void SubmitButtonClicked(ActionEvent event) {
		Bill newBill = new Bill(BillNameInput.getText(), Double.parseDouble(BillCostInput.getText()), Double.parseDouble(BillFrequencyInput.getText()));
		tableView.getItems().add(newBill);
		
		ResetButtonClicked(event);
	}

	/**
	 * Goes back to AccountsView
	 * 
	 * @throws IOException
	 */
	@FXML
	void GoBackButtonClicked(ActionEvent event) throws IOException {
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
		accounts.setUsername(AccountsViewController.Username);

		// Gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// Sets Scene and shows upon button press
		window.setScene(AccountViewScene);
		window.show();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// set up columns in the table
		BillNameColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("Billname"));
		BillPriceColumn.setCellValueFactory(new PropertyValueFactory<Bill, Double>("Billcost"));
		BillFrequencyColumn.setCellValueFactory(new PropertyValueFactory<Bill, Double>("BillFrequency"));

		// load data
		tableView.getColumns().addAll(BillNameColumn, BillPriceColumn, BillFrequencyColumn);
		
		tableView.setItems(bill);
	}

}
