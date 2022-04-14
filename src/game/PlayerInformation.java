package Game;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PlayerInformation extends JFrame implements ActionListener {

	private JLabel label, labelPlayer1, labelPlayer2;
	private JButton start;
	private JTextField textPlayer1, textPlayer2;
	private int numPlayers;

	private Player gamePlayers[];
	private int counter=0;

	public PlayerInformation(int players) {

		this.numPlayers = players;

		this.setSize(500,200);
		this.setTitle("Player Information");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(4,3));

		//Label for the information
		label = new JLabel("Enter Player Information!");
		panel.add(label); 
		panel.add(new JLabel(""));

		this.gamePlayers = new Player[players];

		labelPlayer1 = new JLabel("Player " + (counter+1) + " :");
		textPlayer1 = new JTextField(20);
		panel.add(labelPlayer1);
		panel.add(textPlayer1);
		panel.add(new JLabel(""));


		//Start button
		panel.add(new JLabel(""));
		start = new JButton("Next");
		panel.add(new JLabel(""));
		panel.add(start);


		start.addActionListener(this);
		this.add(panel);
		this.setVisible(true);     

	}

	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == start){
			gamePlayers[counter] = new Player(textPlayer1.getText(), counter, 0);

			counter++;
			labelPlayer1.setText("Player " + (counter+1) + " :");
			textPlayer1.setText("");

			if(counter == numPlayers) {
				Level ob = new Level(gamePlayers);
				this.setVisible(false);
			}

		}

	}

}


