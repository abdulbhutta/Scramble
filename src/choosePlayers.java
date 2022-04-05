

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class choosePlayers extends JFrame implements ActionListener {
	
    public static void main(String[] wer) throws Exception
    {
        new choosePlayers();
    }
    private JLabel label;
    private JButton onePlayerButton, twoPlayerButton;

    public choosePlayers()
    {
        this.setSize(500,200);
        this.setTitle("Select Level");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        label = new JLabel("How many players are playing? ");

        onePlayerButton= new JButton("1 Player");
        twoPlayerButton = new JButton("2 Player");
        
        
        panel.add(label); 
        panel.add(onePlayerButton);
        panel.add(twoPlayerButton);
        
        onePlayerButton.addActionListener(this);
        twoPlayerButton.addActionListener(this);
        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == onePlayerButton)
        {
            playerInformation ob = new playerInformation(1);
            this.setVisible(false);
        }
        else if(event.getSource() == twoPlayerButton)
        {
            playerInformation ob = new playerInformation(2);
            this.setVisible(false);
        }
    }
}

