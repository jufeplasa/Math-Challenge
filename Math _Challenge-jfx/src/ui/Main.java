package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
	private static GameGUI gameGUi;
	
	public static void main(String[] args) {
		gameGUi=new GameGUI();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartPage.fxml"));
		fxmlLoader.setController(gameGUi);
		Parent root = fxmlLoader.load();
		gameGUi.setMainStage(primaryStage);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MATH CHALLENGE");
		primaryStage.show();
	}
}
