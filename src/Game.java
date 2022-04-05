import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Game extends JFrame implements ActionListener
{
    public static void main(String[] asd)
    {
        new Game();
    }
    private JButton button1,button2,button3;
    private JLabel label1;
    //private String[] words;

    public Game()
    {
        this.setSize(400,500);
        this.setTitle("Word Scramble Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(12,3));
        label1 = new JLabel("Main Menu");
        button1 = new JButton("Play the Game!");
        button2 = new JButton("Want a help?");
        button3 = new JButton("Bored of game");
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(label1); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(button1); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(button2); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(button3); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == button3)
        {
            System.exit(0);
        }
        else if(event.getSource() == button2)
        {
            Help ob = new Help();
            this.setVisible(false);
        }
        else if(event.getSource() == button1)
        {
            Level ob1 = new Level();
            this.setVisible(false);
        }
    }
}

class Help extends JFrame implements ActionListener
{
    public static void main(String[] asd) throws Exception
    {
        new Help();
    }
    private JButton button;
    
    public Help()
    {
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
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == button)
        {
            this.setVisible(false);
            Game ob = new Game();
        }
    }
}