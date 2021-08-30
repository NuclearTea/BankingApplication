package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountsViewTester extends Application {

	// Creates stage which will be called later
	Stage primaryStage;

	/**
	 * Creates scene and stage by linking with UserInfoViewController
	 * 
	 */
	private void AccountsView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent AccountsView = (Parent) loader.load(new FileInputStream("src/Views/AccountsView.fxml"));
			AccountsViewController accountsViewController = loader.getController();
			accountsViewController.linkWithApplication(this);
			scene = new Scene(AccountsView, 800, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		AccountsView();

	}

	public static void main(String[] args) {
		launch(args);
	}


}
