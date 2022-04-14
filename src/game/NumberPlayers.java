package Game;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NumberPlayers extends JFrame implements ActionListener {

	private JLabel label;
	// private JButton onePlayerButton, twoPlayerButton;
	private JButton next = new JButton ( "Next" );
	private JTextField field = new JTextField(10);    

	public NumberPlayers() {

		this.setSize(500,200);
		this.setTitle("Select Level");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		label = new JLabel("How many players are playing? ");

		panel.add(label); 
		panel.add(field);

		panel.add(next);
		next.addActionListener(this);

		this.add(panel);
		this.setVisible(true);
	}

	// validate valid number of players
	public int validatePlayers(String input) {

		// check if int can be parsed
	    try {
	        Integer.parseInt(input);
	    } catch (final NumberFormatException e) {
	        return -2;
	    }

	    // parse int
		int numPlayers = Integer.parseInt(input);

		// return error if number less than or equal zero
		if (numPlayers <= 0) {	
			return -1;
		} else {
			return 0;	// if all checks pass, indicate valid
		}

	}

	public void actionPerformed(ActionEvent event) {

		// if next button selected
		if(event.getSource() == next) {
			
			switch (validatePlayers(field.getText())) {
			
			case 0:		// Valid Number
				PlayerInformation ob = new PlayerInformation(Integer.parseInt(field.getText()));
				this.setVisible(false);
				break;
			case -1:	// <= 0

				break;
			case -2: 	// Cannot read int

				break;
			}
					
				
					
			if(validatePlayers(field.getText()) == 0) {
			
			} else {
				
			}

		} 

	}

}

