package game;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PostGame extends JFrame implements ActionListener {

	Player players[];
	private JButton button;

	// receive player list and draw window for leaderboard
	public PostGame(Player[] players) {

		//receive player list
		this.players = players;

		//window settings
		this.setSize(500,300);
		this.setTitle("Game Over");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();

		// main menu button
		button = new JButton("   Main Menu   ");

		
		// Find winning player
		Player winner = winningPlayer(players);

		// Draw text
		panel.add(new JLabel("                                       Game Over                                       "));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Player " + winner.getName() + " Wins with a score of " + winner.getScore() + "!\n"));
		panel.add(button);

		//add panel and even listeners
		this.add(panel);
		button.addActionListener(this);
		this.setVisible(true);
	}

	
	// find winning player
	public Player winningPlayer(Player players[]) {

		// initialize highest scoring player
		Player highestScore = players[0];

		// find highest scoring player in list
		for (Player contestant: players) {
			
			// if current player has higher score than max, set max to current player
			if (contestant.getScore() > highestScore.getScore()) {
				highestScore = contestant;
			}

		}

		// return player with highest score
		return highestScore;

	}

	
	// Button event listener
	public void actionPerformed(ActionEvent event) {

		// if player clicks mainmenu button close window and show main menu
		if(event.getSource() == button) {
			this.setVisible(false);
			Game ob = new Game();
		}

	}
}