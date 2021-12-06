package thread;



import java.io.IOException;

import javafx.application.Platform;
import ui.GameGUI;

public class ProgressBarThread extends Thread{
	
	
	private GameGUI gameGui;
	
	public ProgressBarThread(GameGUI gui) {
		gameGui=gui;
	}
	
	public void run() {
		int seg=0;
		int mil=0;
		int width=0;
		boolean cronometroActivo = true;
		try{
			while( cronometroActivo ) {
				Thread.sleep( 4 );
				mil += 4;
				if( mil == 1000 ){
					mil = 0;
					seg += 1;
					width += 4;
					gameGui.fillProgressBar(width);	
					Platform.runLater(new Thread() {
						public void run() {
							
							gameGui.countSeconds();
						}
					});
					if(seg==30) {
						cronometroActivo = false;
					}
				}
			}
		}
		catch(Exception e){}
		seg=0;
		Platform.runLater(new Thread() {
			public void run() {
				try {
					gameGui.finishGame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	public GameGUI getGameGUI() {
		return gameGui;
	}
	 

}
