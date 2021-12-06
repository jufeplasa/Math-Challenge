package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Game;
import thread.ProgressBarThread;
import thread.SaveDataThread;

public class GameGUI {

    private Game game;
    
    private ProgressBarThread barThread;
    
    private SaveDataThread st;

    private Stage mainStage;
    
    @FXML
    private TextField nameField;
    
    @FXML
    private Button optionA;

    @FXML
    private Button optionC;

    @FXML
    private Button optionB;

    @FXML
    private Button optionD;

    @FXML
    private Label challengeLabel;
    
    @FXML
    private Label pointsLabel;
    
    @FXML
    private Label timeOut;
    
    @FXML
    private Rectangle progressBar;
    
    @FXML
    private Label posicionActual;

    @FXML
    private Label quintoPuesto;

    @		FXML
    private Label cuartoPuesto;

    @FXML
    private Label tercerPuesto;

    @FXML
    private Label segundoPuesto;

    @FXML
    private Label primerPuesto;
    
	
	public GameGUI() throws FileNotFoundException, ClassNotFoundException, IOException  {
		game=new Game();	
		barThread= new ProgressBarThread(this);
		st= new SaveDataThread(game);
		
		st.start();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage primaryStage) {
		mainStage=primaryStage;
	}

    @FXML
    public void startChallenge(ActionEvent event) throws IOException, InterruptedException, ClassNotFoundException {
    	
    	String namePlayer=nameField.getText();
    	if(namePlayer.isEmpty()) {
    		Alert alert=new Alert(null); 
    		alert.setAlertType(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Please enter your name");
			alert.setContentText("The cant star without a name.");
			alert.showAndWait();
    	}
    	else {
    		game.starGame(namePlayer);
        	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("ChallengePage.fxml"));
        	fxmlloader.setController(this);
        	Parent root= fxmlloader.load();
        	Scene scene= new Scene (root);
    		mainStage.setScene(scene);
        	mainStage.setTitle("window2");
    		challengeLabel.setText(game.showCallenge());
    		showOptions();
    		mainStage.show();
    		barThread.start();
    	
    	}
    }
    
    
    public void showOptions() {


		int option=(int)Math.floor(Math.random()*4);
		switch(option) {
		case(0):
			optionA.setText(game.getCorrectAnswer()+"");
			optionB.setText(game.getFailAnswer1()+"");
			optionC.setText(game.getFailAnswer2()+"");
			optionD.setText(game.getFailAnswer3()+"");
			break;
		case(1):
			optionA.setText(game.getFailAnswer3()+"");
			optionB.setText(game.getCorrectAnswer()+"");
			optionC.setText(game.getFailAnswer1()+"");
			optionD.setText(game.getFailAnswer2()+"");	
		break;
		case(2):
			optionA.setText(game.getFailAnswer3()+"");
			optionB.setText(game.getFailAnswer2()+"");
			optionC.setText(game.getCorrectAnswer()+"");
			optionD.setText(game.getFailAnswer1()+"");
		break;
		case(3):
			optionA.setText(game.getFailAnswer1()+"");
			optionB.setText(game.getFailAnswer2()+"");
			optionC.setText(game.getFailAnswer3()+"");
			optionD.setText(game.getCorrectAnswer()+"");
		break;
		}
		pointsLabel.setText(game.getCurrentP().getPoints()+"");
	}



    @FXML
    public void selectOptionA(ActionEvent event) throws IOException {
    	if(game.getCorrectAnswer()==Integer.parseInt(optionA.getText())) {
    		game.getCurrentP().increasePoints();
    	}
    	else {
    		game.getCurrentP().decreasePoints(); 
    	}
		challengeLabel.setText(game.showCallenge());
		showOptions();
    }

    @FXML
    public void selectOptionB(ActionEvent event) throws IOException {
    	if(game.getCorrectAnswer()==Integer.parseInt(optionB.getText())) {
    		game.getCurrentP().increasePoints();
    	}
    	else {
    		game.getCurrentP().decreasePoints(); 
    	}
		challengeLabel.setText(game.showCallenge());
		showOptions();
    }

    @FXML
    public void selectOptionC(ActionEvent event) throws IOException {
    	if(game.getCorrectAnswer()==Integer.parseInt(optionC.getText())) {
    		game.getCurrentP().increasePoints();
    	}
    	else {
    		game.getCurrentP().decreasePoints(); 
    	}
		challengeLabel.setText(game.showCallenge());
		showOptions();
    }

    @FXML
    public void selectOptionD(ActionEvent event) throws IOException {
    	if(game.getCorrectAnswer()==Integer.parseInt(optionD.getText())) {
    		game.getCurrentP().increasePoints();
    	}
    	else {
    		game.getCurrentP().decreasePoints(); 
    	}
		challengeLabel.setText(game.showCallenge());
		showOptions();
    }
   
    
    public boolean fillProgressBar(int w) {
    	progressBar.setWidth(w);
       	return false;
    }
    int seconds;
    
    public void countSeconds() {
    	seconds++;
    	timeOut.setText(seconds+"");
    }


    
    public void showFirstPLace() {
    	if(game.findFirstPlace(game.getRoot())!=null) {
    		primerPuesto.setText(game.findFirstPlace(game.getRoot()).toString());
    	}
    }
    
    public void showSecondPLace() {
    	if(game.findSecondPlace()!=null) {
    		segundoPuesto.setText(game.findSecondPlace().toString());
    	}
    }
    
    public void showThirdPLace() {
    	if(game.findThirdPlace()!=null) {
    		tercerPuesto.setText(game.findThirdPlace().toString());
    	}
    }
    
    public void showFourthPLace() {
    	if(game.findFourthPlace()!=null) {
    		cuartoPuesto.setText(game.findFourthPlace().toString());
    	}
    }
    
    public void showFifthPLace() {
    	if(game.findFifthPlace()!=null) {
        	quintoPuesto.setText(game.findFifthPlace().toString());
    	}
    }
    
    public void showCurrentPlayer() {
    	posicionActual.setText("Hola");
    }
    
    public void finishGame() throws IOException {
    	game.addPlayer(game.getCurrentP());
    	game.addPlayer2();
    	showScoreBoard();
    }
    
    @FXML
    public void DeletedInfo(ActionEvent event) {

    }
    @FXML
    public void saveInfo(ActionEvent event) throws FileNotFoundException, IOException {
    	game.saveData();
    	Alert alert=new Alert(null); 
		alert.setAlertType(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Save data successful");
		alert.setContentText("Your party has save");
		alert.showAndWait();
    }
    
    public void showScoreBoard() throws IOException {
    	
    	FXMLLoader fxmlloader= new FXMLLoader (getClass().getResource("ScoreBoard.fxml"));
    	fxmlloader.setController(this);
    	Parent root= fxmlloader.load();
    	Scene scene= new Scene (root);
		mainStage.setScene(scene);
    	mainStage.setTitle("window3");
    	showFirstPLace();
    	showSecondPLace();
    	showThirdPLace();
    	showFourthPLace();
    	showFifthPLace();
		mainStage.show();

    }

}
