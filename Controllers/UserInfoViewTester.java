package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserInfoViewTester extends Application {

	// Creates stage which will be called later
	Stage primaryStage;

	/**
	 * Creates scene and stage by linking with UserInfoViewController
	 */
	private void userInfoView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent userInfoView = (Parent) loader.load(new FileInputStream("src/Views/UserInfoView.fxml"));
			UserInfoViewController userInfoViewController = loader.getController();
			userInfoViewController.linkWithApplication(this);
			scene = new Scene(userInfoView, 425, 400);
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
		userInfoView();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
