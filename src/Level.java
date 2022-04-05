import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Level extends JFrame implements ActionListener
{
    public static void main(String[] wer) throws Exception
    {
        new Level();
    }
    private JLabel label;
    private JButton button1, button2;

    public Level()
    {
        this.setSize(500,200);
        this.setTitle("Select Level");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(4,3));
        label = new JLabel("Select a difficulty of level");
        button1 = new JButton("Novice");
        button2 = new JButton("Genius");
        panel.add(label); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        panel.add(button1); panel.add(new JLabel("")); panel.add(button2);
        panel.add(new JLabel("")); panel.add(new JLabel("")); panel.add(new JLabel(""));
        button1.addActionListener(this);
        button2.addActionListener(this);
        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == button1)
        {
            Play ob = new Play();
            this.setVisible(false);
        }
        else if(event.getSource() == button2)
        {
            Play2 ob = new Play2();
            this.setVisible(false);
        }
    }
}