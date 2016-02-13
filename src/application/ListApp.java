package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.ListController;

public class ListApp {
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
		getClass().getResource("/view/List.fxml"));
		AnchorPane root = (AnchorPane)loader.load();
		ListController listController =
		loader.getController();
		listController.start();
		Scene scene = new Scene(root, 200, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
