package game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Help extends JFrame implements ActionListener {

    private JButton button;

    public Help() {

        this.setSize(500,300);
        this.setTitle("Help");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        button = new JButton("   OK   ");

        panel.add(new JLabel("                                       Help                                       "));
        panel.add(new JLabel("You will get a word, present in the Oxford Dictionary, whose letters are dearranged."));
        panel.add(new JLabel("You have to arrange those letters to form a word which is in the Oxford Dictionary."));
        panel.add(new JLabel("You can guess the word three times before the answer is displayed."));
        panel.add(new JLabel("The first alphabet of the word is given in Capital."));
        panel.add(new JLabel(" There are two levels in the game - novice and genius."));
        panel.add(new JLabel(" Novice  :  In this level you will get small words."));
        panel.add(new JLabel("                                    Genius  :  In this level you will get long words.                    "));
        panel.add(button);

        this.add(panel);
        button.addActionListener(this);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {

        if(event.getSource() == button) {
            this.setVisible(false);
            Game ob = new Game();
        }

    }
}