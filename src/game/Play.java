package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Play extends JFrame implements ActionListener {

	// variables
	private JButton enterBTN,mainMenuBTN,exitBTN,answerBTN;
	private JTextField text1;
	private JLabel label1;
	private JLabel label2;
	private JLabel gameTurnLabel;

	public String word;
	public String wordlist[] = new String[255];
	public int wordScore = 0;
	public int numwords = 0;
	public int playerOneScore = 0;
	public int playerTwoScore = 0;
	public String scrambledWord;

	public int score = 0;
	public boolean userCorrect;
	public int lives = 3;
	public boolean gameOver;
	public int total_score = 0;
	public int turn = 1;
	public int totalTurn;
	Player players[];
	int currentPlayer = 0;
	JLabel playerTurnLabel = new JLabel("Player Turn: " + (currentPlayer + 1));

	
	// contsrcutor
	// takes array of players and a difficulty
	// both initialized and selected previously
	public Play(Player players[], String difficulty) {

		// save player list to class wide variable
		this.players = players;
		
		// 5 turns for each player to guess
		this.totalTurn = 5 * players.length;

		// read selected difficulty from a file
		try  {
			BufferedReader in = new BufferedReader(new FileReader(difficulty));
			String str;

			// read file to create word list
			while ((str = in.readLine()) != null) {
				wordlist[numwords++] = str;
			}

			in.close();
		} catch (IOException e){}

		// initialize window
		this.setSize(600, 750);
		this.setTitle("Scramble");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		// create panel and buttons
		JPanel panel = new JPanel(new GridLayout(10,3));
		enterBTN = new JButton("Enter");
		mainMenuBTN = new JButton("Main Menu");
		exitBTN = new JButton("Exit");
		answerBTN = new JButton("Get the answer!");

		

		label1 = new JLabel("Player " + players[currentPlayer].getName() + " Guess!");
		gameTurnLabel = new JLabel("Game Turn " + turn + " of " + totalTurn);
		text1 = new JTextField(10);
		label2 = new JLabel("Word Score: " + wordScore);
		getNewWord();

		// game gui
		// grid layout
		panel.add(new JLabel("")); 
		panel.add(new JLabel("               Welcome"));
		panel.add(new JLabel(""));

		panel.add(playerTurnLabel);
		panel.add(new JLabel("         Word Scramble"));
		panel.add(gameTurnLabel);

		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		
		panel.add(new JLabel("Word to be scrambled: "));
		panel.add(label1);
		panel.add((label2));
		
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		
		panel.add(new JLabel("Your Guess :"));
		panel.add(text1);
		panel.add(enterBTN);
		
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		
		panel.add(mainMenuBTN);
		panel.add(answerBTN); 
		panel.add(exitBTN);
		
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		// draw panel and add button listener
		enterBTN.addActionListener(this);
		mainMenuBTN.addActionListener(this);
		exitBTN.addActionListener(this);
		answerBTN.addActionListener(this);

		System.out.println(scrambledWord);

		this.add(panel);
		this.setVisible(true);
		text1.requestFocus();
	}


	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == enterBTN) {

			String text = text1.getText();

			if(text.equals("")) {			// empty string
				JOptionPane.showMessageDialog(this,"Come on, guess something");

			} else if(text.equalsIgnoreCase(word)) {		// Correct answer

				//display correct, set flag
				JOptionPane.showMessageDialog(this,"Correct!");
				userCorrect = true;

				// add word score to player score
				players[currentPlayer].setScore(players[currentPlayer].getScore() + getScore(text));

				// debugging
				System.out.println(players[currentPlayer].getName() + " :" + players[currentPlayer].getScore());

				//increment player, turn and get new word
				currentPlayer = (++currentPlayer) % players.length;
				playerTurnLabel.setText("Player Turn: " + (currentPlayer + 1));
				gameTurnLabel.setText("Game Turn " + ++turn + " of " + totalTurn);
				userCorrect = true;
				getNewWord();

			} else {		// wrong answer

				// display wrong, set correct flag to false
				JOptionPane.showMessageDialog(this,"Wrong");
				userCorrect = false;

				// debugging
				System.out.println(players[currentPlayer].getName() + " :" + players[currentPlayer].getScore());

				//get new word, increment players and turn
				getNewWord();
				currentPlayer = (++currentPlayer) % players.length;
				playerTurnLabel.setText("Player " + players[currentPlayer].getName() + " Turn!");
				gameTurnLabel.setText("Game Turn " + turn + " of " + totalTurn);
				turn += 1;
			}
			
			// if max number of turns passes
			//display leaderboard
			if (turn >= totalTurn) {
				this.setVisible(false);
				PostGame leaderboard = new PostGame(players);
			}

		} else if(event.getSource() == mainMenuBTN) {

			this.setVisible(false);
			Game ob = new Game();
		} else if(event.getSource() == exitBTN) {
			System.exit(0);
		} else if(event.getSource() == answerBTN) {
			JOptionPane.showMessageDialog(this,"Correct word : "+word);
			getNewWord();
		}

		text1.setText("");
		text1.requestFocus();
	}

	// getNewWord
	// gets a new word from list
	public String getNewWord() {

		// generate a random number corresponding to index in list
		int rndword;
		Random randGen2 = new Random();
		rndword = randGen2.nextInt(numwords);

		// replace current word with random word
		word = wordlist[rndword].replace(" ","");
		System.out.println(word);

		
		// get scrambled word
		scrambledWord = scramble(word);
		
		// find score for word
		scoreWord();


		// change labels for new word and word score
		label1.setText(scrambledWord);
		label2.setText(Integer.toString(wordScore));

		// return correct word
		return word;
	}

	// convert word to lower case
	public String lowerCaseWord (String word) {
		String lowerCaseWord = word.toLowerCase();
		return lowerCaseWord;
	}

	// generate a score for the word
	public void scoreWord () {
		Random rand = new Random();
		wordScore = rand.nextInt((10 - 0 + 1)+ 1);

	}

	// get score for word
	public int getScore(String word) {

		if(userCorrect == true) {
			score = word.length();	
		} else {
			score = 0;
			lives--;
		}

		return score;
	}


	// if lives are gone gameover
	public boolean gameOver() {
		if(lives <= 0) {
			gameOver = true;
		}
		else {
			gameOver = false;
		}
		return gameOver;
	}

	// incremenet score
	public int incScore() {
		getScore(word);
		total_score += score;
		return total_score;
	}


	// function for scrambling word
	public String scramble(String wordtoscramble) {
		String newword = "";
		String lowerCaseWord;

		int rndNum;
		Random randGen = new Random();
		boolean letter[] = new boolean[wordtoscramble.length()];
		do {
			rndNum = randGen.nextInt(wordtoscramble.length());
			if (letter[rndNum] == false) {
				newword = newword + wordtoscramble.charAt(rndNum);
				letter[rndNum] = true;
			}
		} while (newword.length() < wordtoscramble.length());
		lowerCaseWord = lowerCaseWord(newword);

		return lowerCaseWord;
	}
}