import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class dialogue1 implements ActionListener
{
    private final static String newline = "\n",tab="\t";
    public static final Color c = new Color(0,0,153),k=new Color(153,0,0);
    public int min=0,max=100;
    JTextArea details;
    JFrame frame;
    JPanel panel;
    JButton start,exit,about;
    JLabel title;
    dialogue1()
    {
        title=new JLabel("----GUESS THE NUMBER----");
        title.setForeground(Color.RED);
        title.setFont(new Font("Serif", Font.ITALIC, 120));
        panel=new JPanel();
        panel.setBounds(70,100,50,20); 
        panel.setBackground(c);
        frame=new JFrame();
        start=new JButton(" Start ");
        start.setBackground(Color.cyan);
        start.setForeground(Color.blue);
        start.setFont(new Font("Serif", Font.ITALIC, 30));
        start.addActionListener(this); 
        exit=new JButton("Exit");
        exit.setBackground(Color.cyan);
        exit.addActionListener(this);
        exit.setForeground(Color.red);
        exit.setFont(new Font("Serif", Font.ITALIC, 30));
        about=new JButton("About");
        about.setBackground(Color.cyan);
        about.setForeground(Color.blue);
        about.setFont(new Font("Serif", Font.ITALIC, 30));
        about.addActionListener(this);
        panel.add(start);
        FlowLayout f=new FlowLayout(FlowLayout.CENTER, 50, 200);
       panel.add(exit);
       panel.add(about);
       panel.setLayout(f);
       frame.add(panel,BorderLayout.SOUTH);
       frame.add(title);
       frame.setSize(300,300);
        frame.setVisible(true);
    }  
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==start)
                {
                    String name;
                    int guessed,random,i=1,j=4,w=0;
                    name = JOptionPane.showInputDialog("Enter your name? ");
                    while(true)    
                    {    
                        if(name.isEmpty()){name = JOptionPane.showInputDialog("Enter your name? ");}
                        else{break;}
                    }
                    JOptionPane.showMessageDialog(null, "Hello " + name+",Click OK to Start your Game");
                    guessed=(int)(Float.parseFloat(JOptionPane.showInputDialog("Guess a Number!!")));
                    while(i<j)
                    {
                        random=(int)(Math.random()*(max-min+1)+min);
                        guessed=(int)(Float.parseFloat(JOptionPane.showInputDialog("Guess a Number!!(available chances: "+ (j-i)+")")));
                        if(guessed==random)
                        {
                            w++;
                           if(w==1)
                           { 
                            JOptionPane.showMessageDialog(null, name+",Congratualtions ,Sucessfully completed level 1");
                            max=1000;i=0;j=3;
                            }
                            else{JOptionPane.showMessageDialog(null, name+",Congratualtions ,Sucessfully completed  2 Levels");}
                        }
                           
                        
                        i++;
                    }
                    if(i>=j){JOptionPane.showMessageDialog(null,  name+",You Lost the Game(Click OK to go Back)");}
                }
                if(e.getSource()==exit)
                {
                    System.exit(0);
                }
                if(e.getSource()==about)
                {
                    JFrame sub=new JFrame("About the game");
                    JButton close=new JButton("close");
                    close.addActionListener(new ActionListener()
                    {  
                    public void actionPerformed(ActionEvent e)
                    {
                        sub.dispose();
                    }});
                    sub.add(close);
                    String x="*****WELCOME to Guess The Number Game*****",x1="There are 2 levels :",x2="1)Guessing a number from 1 to 100 ",x3="2)Guessing a number from 1 to 1000 ";
                    String x4="Intially player has 4 chances..",x5="Based on the level, number of chances will be reduced by 1 ";
                    details=new JTextArea();
                    details.append(tab+tab+tab+tab+x+newline+x1 + newline+x2 + newline+x3 + newline+x4 + newline+x5 + newline);
                    details.setEditable(false);
                    details.setFont(new Font("Serif", Font.ITALIC, 20));
                    details.setBackground(Color.white);
                    details.setForeground(k);
                    sub.add(details);
                    sub.setSize(400,200);
                    sub.setVisible(true);

                }
            }
        
       
    
    public static void main(String a[])
    {
        new dialogue1();
    }
}
