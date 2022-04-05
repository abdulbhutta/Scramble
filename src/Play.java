import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Play extends JFrame implements ActionListener
{
    public static void main(String[] args) throws Exception
    {
    	String difficulty = "assets/Novice.txt";
    	String player1 = "Abdul", player2 = "Usman";
		//String difficulty = "assets/Novice.txt";
        new Play(player1, player2, difficulty);
    }
    private JButton button1,button2,button3,button4;
    private JTextField text1;
    private JLabel label1;
    public String word;
    public String wordlist[] = new String[255];
    public int numwords = 0;
    public int playerOneScore = 0;
    public int playerTwoScore = 0;
    
    public Play(String player1, String player2, String difficulty)
    {
    	System.out.println(player1);
        try 
	 	{
        	System.out.println(difficulty);
        	BufferedReader in = new BufferedReader(new FileReader(difficulty));
        	String str;
        	while ((str = in.readLine()) != null) 
        	{
            	wordlist[numwords++] = str;
        	}
        	in.close();
        } 
        catch (IOException e){}
        this.setSize(575, 750);
        this.setTitle("Scramble");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        JPanel panel = new JPanel(new GridLayout(10,3));
        button1 = new JButton("Enter");
        button2 = new JButton("Main Menu");
        button3 = new JButton("Exit");
        button4 = new JButton("Get the answer!");
        label1 = new JLabel("");
        text1 = new JTextField(10);
        
        
        panel.add(new JLabel("")); panel.add(new JLabel("               Welcome")); panel.add(new JLabel(""));
        panel.add(new JLabel("Player Turn: " + player1)); panel.add(new JLabel("         Word Scramble")); panel.add(new JLabel("<html>TOTAL SCORE<br/><br/>Name: " + player1 + " ---> Score: " + playerOneScore 
        		+ "<br/>Name: " + player2 + " ---> Score: " + playerTwoScore + "</html>"));
        
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("Word to be scrambled: ")); panel.add(label1); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("Your Guess :")); panel.add(text1); panel.add(button1);
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(button2); panel.add(button4); panel.add(button3);
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        getnewword();
        this.add(panel);
        this.setVisible(true);
        text1.requestFocus();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == button1)
        {
            String text = text1.getText();
            if(text.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Come on, guess something");
            }
            else if(text.equalsIgnoreCase(word))
            {
                JOptionPane.showMessageDialog(this,"Correct!");
                getnewword();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Wrong");
            }
        }
        else if(event.getSource() == button2)
        {
            this.setVisible(false);
            Game ob = new Game();
        }
        else if(event.getSource() == button3)
        {
            System.exit(0);
        }
        else if(event.getSource() == button4)
        {
            JOptionPane.showMessageDialog(this,"Correct word : "+word);
            getnewword();
        }
		text1.setText("");
		text1.requestFocus();
    }
    
    public String getnewword() 
    {
        int rndword;
        Random randGen2 = new Random();
        rndword = randGen2.nextInt(numwords);
        word = wordlist[rndword].replace(" ","");
        label1.setText(scramble(word));
        return word;
    }
    
    public static String lowerCaseWord (String word) {
    	String lowerCaseWord = word.toLowerCase();
    	return lowerCaseWord;
    }
       
    public static String scramble(String wordtoscramble) 
    {
		String newword = "";
		String lowerCaseWord;
		int rndnum;
		Random randGen = new Random();
		boolean letter[] = new boolean[wordtoscramble.length()];
		do {
			rndnum = randGen.nextInt(wordtoscramble.length());
			if (letter[rndnum] == false) {
				newword = newword + wordtoscramble.charAt(rndnum);
				letter[rndnum] = true;
			}
		} while (newword.length() < wordtoscramble.length());
		
		lowerCaseWord = lowerCaseWord(newword);
		
		return lowerCaseWord;
	}
}