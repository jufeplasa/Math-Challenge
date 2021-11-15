package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GameGUI {

    @FXML
    private TextField nameField;
    private Stage mainStage;
	
	public GameGUI() {
		
	}
	
	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage primaryStage) {
		mainStage=primaryStage;
	}

    @FXML
    void startChallenge(ActionEvent event) {

    }





}
