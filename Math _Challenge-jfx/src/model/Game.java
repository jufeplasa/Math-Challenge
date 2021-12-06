package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final String SAVE_DATA="data/players.dat";
	
	private int correctAnswer;
	private int failAnswer1;
	private int failAnswer2;
	private int failAnswer3;
	private int a;
	private int b;

	private Player currentP;
	private List<Player> player;
	private Player root;

	public Game() {
		player= new ArrayList<Player>();
	}
	
	public void addPlayer2() {
		player.add(currentP);
	}

	public void starGame(String name) {
		Player nPlayer=new Player(name);
		currentP=nPlayer;
	}

	public Player getCurrentP() {
		return currentP;
	}

	public Player getRoot() {
		return root;
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
		int operation=(int)Math.floor(Math.random()*4);
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
		}
		return operation;
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
		return message;
	}
	
	public void addPlayer(Player newPlayer) {
		Player np=newPlayer;
		if(root == null){//vacía
		
			root = np;
		}
		else { //tiene al menos uno
		
			Player temp = root;
			boolean added = false;
			while( !added ) {
				
				if(np.getPoints()<=temp.getPoints()) {
				
					if( temp.getLeft() == null) {
					
						temp.setLeft(np);
						np.setUp(temp);
						added = true;
					}
					else {
						temp = temp.getLeft();
					}

				}
				else if(np.getPoints()>temp.getPoints()){
				
					if( temp.getRight() == null)
					{
						temp.setRight(np);
						np.setUp(temp);
						added = true;
					}
					else
					{
						temp = temp.getRight();
					}
				}
			}
		}
	}
	
	public boolean esHoja(Player aux) {
		if(aux.getRight()==null&&aux.getLeft()==null) {
			return true;
		}
		else {
			return false;
		}
		
	
	}
	
	
	public Player findFirstPlace(Player aux) {
		Player temp=null;
		if(aux!=null) {
			if(aux.getRight()!=null) {
				temp=findFirstPlace(aux.getRight());
			}
			else {
				temp=aux;
			}
		}
		return temp;
	}
	
	public Player findSecondPlace() {
		Player firstPlace=findFirstPlace(root);
		Player temp=null;
		if(firstPlace!=null) {
			if(esHoja(firstPlace)) {
				temp=firstPlace.getUp();
			}
			else{
				Player aux=firstPlace.getLeft();
				while(aux.getRight()!=null) {
					aux=aux.getRight();
				}
				aux=temp;
			}
		}
		return temp;
	}
	
	public Player findThirdPlace() {
		Player secondPlace=findSecondPlace();
		Player temp=null;
		if(secondPlace!=null) {
			if(esHoja(secondPlace)) {
				temp=secondPlace.getUp();
			}
			else{
				Player aux=secondPlace.getLeft();
				while(aux.getRight()!=null) {
					aux=aux.getRight();
				}
				aux=temp;
			}
		}
		return temp;
	}

	public Player findFourthPlace() {
		Player ThirdPlace= findThirdPlace();
		Player temp=null;
		if(ThirdPlace!=null) {
			if(esHoja(ThirdPlace)) {
				temp=ThirdPlace.getUp();
			}
			else{
				Player aux=ThirdPlace.getLeft();
				while(aux.getRight()!=null) {
					aux=aux.getRight();
				}
				aux=temp;
			}
		}
		return temp;
	}

	public Player findFifthPlace() {
		Player FourthPlace=findFourthPlace();
		Player temp=null;
		if(FourthPlace!=null) {
			if(esHoja(FourthPlace)) {
				temp=FourthPlace.getUp();
			}
			else{
				Player aux=FourthPlace.getLeft();
				while(aux.getRight()!=null) {
					aux=aux.getRight();
				}
				aux=temp;
			}
		}
		return temp;
	}
	
	public void saveData() throws FileNotFoundException, IOException {
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(SAVE_DATA) );
		oos.writeObject(player);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f=new File(SAVE_DATA);
		if (f.exists()) {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f));
			player=(List<Player>) ois.readObject();
			ois.close();
		}
		chargeOnBT();
	}
	
	public void chargeOnBT() {
		for(int i=0;i<player.size();i++) {
			addPlayer(player.get(i));
		}
	}

}