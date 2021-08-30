package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HighRiskViewTester extends Application{

	// Creates stage which will be called later
	Stage primaryStage;

	/**
	 * Creates scene and stage by linking with HighRiskViewController
	 */
	private void HighRiskView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent HighRiskView = (Parent) loader.load(new FileInputStream("src/Views/HighRiskView.fxml"));
			HighRiskViewController HighRiskViewController = loader.getController();
			HighRiskViewController.linkWithApplication(this);
			scene = new Scene(HighRiskView, 800, 600);
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
		HighRiskView();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
