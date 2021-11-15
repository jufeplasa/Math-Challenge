package ui;
import model.Game;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
	private static Game game;
	private static GameGUI gameGUi;
	private static Scanner sc;
	
	public static void main(String[] args) {
		
		gameGUi=new GameGUI();
		game=new Game();
		sc=new Scanner(System.in);
		launch(args);
		/*boolean exit=false;
		while(!exit) {
			System.out.println("Presione 1");
			int option=sc.nextInt();
			sc.nextLine();
			switch(option) {
			case(1):
				System.out.println("          "+game.showCallenge());
				System.out.println(game.showOptions());
				break;
			}
		}*/
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
