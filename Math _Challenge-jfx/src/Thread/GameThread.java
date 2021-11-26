package Thread;

import model.Game;

public class GameThread extends Thread {
	
	
	private Game game;
	
	public GameThread(Game g) {
		game=g;
	}
	
	public void run() {
		
	}

	public Game getGame() {
		return game;
	}
	
}
