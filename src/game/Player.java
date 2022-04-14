package game;

public class Player {

	public String name;
	public int playerNum;
	public int score;

	public Player(String name, int playerNum, int score) {
		this.name = name;
		this.playerNum = playerNum;
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPlayerNum() {
		return playerNum;
	}
	
	
}
