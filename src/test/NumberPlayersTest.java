package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Game.NumberPlayers;

class NumberPlayersTest{

	NumberPlayers numPlay = new NumberPlayers();

	//validate players with a valid integer value
	@Test
	public void validatePlayersTest_validInt() {
		String s = "5";
		assertEquals(0,numPlay.validatePlayers(s));
	}

	//validate players with a invalid integer value
	@Test
	public void validatePlayersTest_invalidInt() {
		String s = "-5";
		assertEquals(-1,numPlay.validatePlayers(s));

	}

	//validate players with a value which cannot be parsed
	@Test
	public void validatePlayersTest_NotInt() {
		String s = "ad";
		assertEquals(-2,numPlay.validatePlayers(s));
	}

}

