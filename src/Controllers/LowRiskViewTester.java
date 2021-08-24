package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LowRiskViewTester extends Application {
	// Creates stage which will be called later
	Stage primaryStage;
	
	/**
	 * Creates scene and stage by linking with LowRiskViewController
	 */
	private void LowRiskView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent LowRiskView = (Parent) loader.load(new FileInputStream("src/Views/LowRiskView.fxml"));
			LowRiskViewController LowRiskViewController = loader.getController();
			LowRiskViewController.LinkWithApplication(this);
			scene = new Scene(LowRiskView, 800, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		LowRiskView();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
