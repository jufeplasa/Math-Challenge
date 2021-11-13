package model;

public class Game {

	private int correctAnswer;
	private int failAnswer1;
	private int failAnswer2;
	private int failAnswer3;


	public Game() {

	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public int getFailAnswer1() {
		return failAnswer1;
	}

	public int getFailAnswer2() {
		return failAnswer2;
	}

	public int getFailAnswer3() {
		return failAnswer3;
	}

	public void generateChallenge() {
		int a =(int)Math.floor(Math.random()*99);
		int b =(int)Math.floor(Math.random()*99);

		int operation=(int)Math.floor(Math.random()*4);

		if(operation==0) {
			correctAnswer=a+b;
		}
		else if(operation==1) {

		}
		else if(operation==2) {

		}
		else if(operation==3) {

		}
		else if(operation==4) {

		}
	}
}
