package thread;

import java.io.IOException;

import model.Game;

public class SaveDataThread extends Thread {
private Game game;
	
	public SaveDataThread(Game g) {
		game=g;
	}
	
	public void run() {
		try {
			game.loadData();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Game getGame() {
		return game;
	}
}
