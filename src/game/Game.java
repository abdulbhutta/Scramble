package game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Game extends JFrame implements ActionListener {

	// buttons 
    private JButton playBtn,helpBtn,exitBtn;
    private JLabel label1;
    //private String[] words;

	// main
    public static void main(String[] asd) {
        new Game();
    }

    // main menu
    public Game() {

        this.setSize(400,500);
        this.setTitle("Word Scramble Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(12,3));
        
        label1 = new JLabel("Main Menu");
        playBtn = new JButton("Play the Game!");
        helpBtn = new JButton("Want a help?");
        exitBtn = new JButton("Exit");
        
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(label1); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(playBtn); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(helpBtn); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(exitBtn); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        
        playBtn.addActionListener(this);
        helpBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        
        this.add(panel);
        this.setVisible(true);
    }

    //action select
    public void actionPerformed(ActionEvent event) {

    	if (event.getSource() == playBtn) {    	// Play Game

            NumberPlayers ob1 = new NumberPlayers();
            this.setVisible(false);

    	} else if (event.getSource() == helpBtn) {		// Help
        	
            Help ob = new Help();
            this.setVisible(false);

    	} else if (event.getSource() == exitBtn) {		// Exit

            System.exit(0);
        }


    }

}

