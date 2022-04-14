package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Game.Player;
import Game.PostGame;

class PostGameTest {

	Player p1 = new Player("Tim",1,20);
	Player p2 = new Player("Jim",1,30);
	Player p3 = new Player("Fred",1,10);

	Player players[] = {p1,p2,p3};

	PostGame postgame = new PostGame(players);

	// assert winning player is p2
	@Test
	public void testWinningPlayer() {
		
		//create postgame object with player list
		PostGame postgame = new PostGame(players);

		//assert p2 as winner
		assertEquals(p2.getName(),postgame.winningPlayer(players).getName());
	}

}