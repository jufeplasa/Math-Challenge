package ui;
import model.Game;
import java.util.Scanner;
public class Main {
	private static Game game;
	private static Scanner sc;
	
	public static void main(String[] args) {
		game=new Game();
		sc=new Scanner(System.in);
		boolean exit=false;
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
		}
	}
}
