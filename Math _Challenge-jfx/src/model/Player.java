package model;

public class Player {

	private int points;
	private String name;
	

	private Player up;
	private Player right;
	private Player left;
	
	public Player(String n) {
		name=n;
		points=0;
	}
	
	public int getPoints() {
		return points;
	}

	public void increasePoints() {
		points+=10;
	}
	
	public void decreasePoints() {
		points-=10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getUp() {
		return up;
	}

	public void setUp(Player up) {
		this.up = up;
	}

	public Player getRight() {
		return right;
	}

	public void setRight(Player right) {
		this.right = right;
	}

	public Player getLeft() {
		return left;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	public String toString() {
		return name+"      "+points;
	}
	
}
