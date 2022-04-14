package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;
import game.*;

public class PlayTest {
	
	//test players
	Player p1 = new Player("jeff",1,0);
	Player p2 = new Player("tim",2,0);
	
	Player players[] = {p1,p2};
	
	Play test = new Play(players, "assets/Novice.txt");
	
	//Validate the first word from the text file is abacus
	@Test
	public void firstWordTest() {
		//Play word = new Play(players, "assets/Novice.txt");
		String firstWord = test.wordlist[0];
		firstWord = test.lowerCaseWord(firstWord);
		System.out.println(firstWord);
		String expected = "abacus";
		assertEquals (expected, firstWord);
	}
	

	@Test
	public void test_getScore() { // testing the method getScore

        test.getNewWord(); // Calls getnewword() to generate a word for a user to guess 
        test.userCorrect = true; // Simulation to show user guessed the word correctly if true vice versa  
        
		String word = test.word; // setting the word
		
		assertNotNull(word); // testing the word is not null and from the list provided
		
		int result = test.getScore(word);
		int size = word.length();
		assertEquals(size, result); // test the size versus the getScore methods output
		//System.out.println(word);
		//System.out.println(result);
		
	}

	@Test // This test case shows that the scores are incremented once incScore() is called based on the word 
	public void test_incScore() {

		int total = 0; // total to increment locally
        test.userCorrect = true; // guess is true always
        
		test.getNewWord(); // gets word
        int w1Size = test.word.length(); // changes to int of length assuming users guessed correctly 
        test.incScore(); // appends size using incScore
        
        test.getNewWord(); 
        int w2Size = test.word.length();
        test.incScore();
        
        test.getNewWord();
        int w3Size = test.word.length();
        test.incScore();
		
        total = w1Size + w2Size + w3Size; // adds to the total manually
		int functionsScore = test.total_score; // assigns the global variable to compare with the assert
        //System.out.println(w1Size + " " + w2Size + " " + w3Size);
		//System.out.println(total);
        assertNotNull(functionsScore);
        assertSame(total, functionsScore);
        
	}
	
	@Test // This test case shows that the user guesses are equal to the word it passes 
	public void test_scramble() {

		test.userCorrect = true;
		
		test.getNewWord();
		String word = test.word;
		String scrambled = test.scramble(word);
		//System.out.println(word + " " + scrambled);
		assertNotEquals(word, scrambled);
		
		String userGuess1 = test.scramble(word);
		//System.out.println(scrambled);
		//System.out.println(userGuess1);
		
		assertNotEquals(word, userGuess1);
		//System.out.println(word);
		
		String userGuess2 = word;
		assertSame(word, userGuess2);
		
	}
	
	@Test
	public void test_game() { // A simulation of the games score adding function
		
		// A word is generated from the list provided
		test.getNewWord();
		String word = test.word;
		assertNotNull(word);
		
		// User guesses the word incorrectly 
		test.userCorrect = false;
		test.incScore(); // increments the score based on if it is correct 0 if not
		assertEquals(0,test.score);
		
		// A new word is chosen
		test.getNewWord();
		word = test.word;
		// In this case the user Guess correctly 
		test.userCorrect = true;
		test.incScore();
		assertEquals(word.length(), test.score);
		
		test.getNewWord();
		word = test.word;
		// User guesses the word incorrectly 
		test.userCorrect = false;
		test.incScore(); // increments the score based on if it is correct 0 if not
		
		test.getNewWord();
		word = test.word;
		// User guesses the word incorrectly 
		test.userCorrect = false;
		test.incScore(); // increments the score based on if it is correct 0 if not
		// since the user failed to guess 3 times they should have 0 lives
		assertSame(0, test.lives);
		
		test.gameOver();
		assertSame(true, test.gameOver); // when lives = 0 game is over
		
	}
	
}