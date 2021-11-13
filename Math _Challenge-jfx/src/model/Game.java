package model;

public class Game {

	private int correctAnswer;
	private int failAnswer1;
	private int failAnswer2;
	private int failAnswer3;
	private int a;
	private int b;

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

	public int generateChallenge() {
		a =(int)Math.floor(Math.random()*99);
		b =(int)Math.floor(Math.random()*99);
		int min;
		int max;
		int operation=(int)Math.floor(Math.random()*5);
		switch(operation) {
		case(0):
			correctAnswer=a+b;
		min=correctAnswer-10;
		max=correctAnswer+10;
		failAnswer1=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer2=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer3=(int) Math.floor(Math.random()*(max-min)+min);
		if(failAnswer1==correctAnswer) {
			failAnswer1++;
		}
		if(failAnswer2==correctAnswer) {
			failAnswer2++;
		}
		if(failAnswer3==correctAnswer) {
			failAnswer3--;
		}
		break;
		
		case(1):
			correctAnswer=a-b;
		min=correctAnswer-10;
		max=correctAnswer+10;
		failAnswer1=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer2=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer3=(int) Math.floor(Math.random()*(max-min)+min);
		if(failAnswer1==correctAnswer) {
			failAnswer1++;
		}
		if(failAnswer2==correctAnswer) {
			failAnswer2++;
		}
		if(failAnswer3==correctAnswer) {
			failAnswer3--;
		}
		break;
		
		case(2):
		correctAnswer=a*b;
		min=correctAnswer-10;
		max=correctAnswer+10;
		failAnswer1=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer2=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer3=(int) Math.floor(Math.random()*(max-min)+min);
		if(failAnswer1==correctAnswer) {
			failAnswer1++;
		}
		if(failAnswer2==correctAnswer) {
			failAnswer2++;
		}
		if(failAnswer3==correctAnswer) {
			failAnswer3--;
		}
		break;
		case(3):
		correctAnswer=a/b;
		min=correctAnswer-10;
		max=correctAnswer+10;
		failAnswer1=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer2=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer3=(int) Math.floor(Math.random()*(max-min)+min);
		if(failAnswer1==correctAnswer) {
			failAnswer1++;
		}
		if(failAnswer2==correctAnswer) {
			failAnswer2++;
		}
		if(failAnswer3==correctAnswer) {
			failAnswer3--;
		}
		break;
		case(4):
			correctAnswer=a%b;
		min=correctAnswer-10;
		max=correctAnswer+10;
		failAnswer1=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer2=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer3=(int) Math.floor(Math.random()*(max-min)+min);
		if(failAnswer1==correctAnswer) {
			failAnswer1++;
		}
		if(failAnswer2==correctAnswer) {
			failAnswer2++;
		}
		if(failAnswer3==correctAnswer) {
			failAnswer3--;
		}
		break;
		case(5):
			correctAnswer=a^2;
		min=correctAnswer-10;
		max=correctAnswer+10;
		failAnswer1=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer2=(int) Math.floor(Math.random()*(max-min)+min);
		failAnswer3=(int) Math.floor(Math.random()*(max-min)+min);
		if(failAnswer1==correctAnswer) {
			failAnswer1++;
		}
		if(failAnswer2==correctAnswer) {
			failAnswer2++;
		}
		if(failAnswer3==correctAnswer) {
			failAnswer3--;
		}
		break;	


		}
		return operation;
	}

		public String showOptions() {
			String message="";
			int option=(int)Math.floor(Math.random()*3);
			switch(option) {
			case(0):
				message="A) "+correctAnswer+"           B) "+failAnswer1+"\n";
				message+="C) "+failAnswer2+"           D) "+failAnswer3;
				break;
			case(1):
				message="A) "+failAnswer2+"           B) "+correctAnswer+"\n";
			message+="C) "+failAnswer3+"           C) "+failAnswer1;
			break;
			case(2):
				message="A) "+failAnswer3+"           B) "+failAnswer2+"\n";
			message+="C) "+failAnswer1+"           C) "+correctAnswer;
			break;
			case(3):
				message="A) "+failAnswer1+"           B) "+failAnswer3+"\n";
			message+="C) "+correctAnswer+"           D) "+failAnswer2;
			break;
			}
			return message;
		}

		public String showCallenge() {
			String message="";
			int option=generateChallenge();
			if(option==0) {
				message=a+"+"+b;
			}
			else if(option==1) {
				message=a+"-"+b;
			}
			else if(option==2) {
				message=a+"*"+b;
			}
			else if(option==3) {
				message=a+"/"+b;
			}
			else if(option==4) {
				message=a+"%"+b;
			}
			else {
				message=a+"^"+2;
			}
			return message;
		}

	}
