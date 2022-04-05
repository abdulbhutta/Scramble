
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class playerInformation extends JFrame implements ActionListener {
	
	
    public static void main(String[] wer) throws Exception
    {
    	int player = 0;
        new playerInformation(player);
    }
    private JLabel label, labelPlayer1;
    private JButton start;
    private JTextField textPlayer1;

    public playerInformation(int player)
    {
        this.setSize(500,200);
        this.setTitle("Player Information");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        
        JPanel panel = new JPanel(new GridLayout(4,3));
        //JPanel ve = new JPanel (new BorderLayout());
        
        //Label for the information
        label = new JLabel("Enter Player Information!");
        panel.add(label); 
        panel.add(new JLabel(""));
        
        //Textbox for user information
        labelPlayer1 = new JLabel("Player 1 Name:");
        textPlayer1 = new JTextField(20);
        panel.add(labelPlayer1);
        panel.add(textPlayer1);
        panel.add(new JLabel(""));
       
        
        //Start button
        panel.add(new JLabel(""));
        start = new JButton("Click here to start!");
        panel.add(new JLabel(""));
        panel.add(start);
   
   
        start.addActionListener(this);
        this.add(panel);
        this.setVisible(true);     
        
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == start)
        {
        	
        	String player1 = textPlayer1.getText();
        	System.out.println(player1);
        	Level ob = new Level (player1, null);
            this.setVisible(false);
        }
    }
}


