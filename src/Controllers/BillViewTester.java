package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BillViewTester extends Application{

	// Creates stage which will be called later
	Stage primaryStage;

	/**
	 * Creates scene and stage by linking with UserInfoViewController
	 * 
	 */
	private void BillView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent BillView = (Parent) loader.load(new FileInputStream("src/Views/BillView.fxml"));
			BillViewController BillViewController = loader.getController();
			BillViewController.linkWithApplication(this);
			scene = new Scene(BillView, 800, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		this.primaryStage = arg0;
		BillView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
