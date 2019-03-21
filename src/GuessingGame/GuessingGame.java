
package GuessingGame;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class GuessingGame extends JFrame{
    JLabel print1,print2,print3;
    JTextField  text;
    JButton but;
    int r= (int) (Math.random()*1000+1);
     
    public GuessingGame() {
         
        print1=new JLabel("I have a number between 1 and 1000.");
        add(print1);
        print2=new JLabel("can you guess my number?");
        add(print2);
        print3=new JLabel("Please Enter Your  Guess :");
        text=new JTextField(4);
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 try{
                    int num=Integer.parseInt(text.getText());
                    if (num==r) {
                        
                        getContentPane().setBackground(Color.PINK);
                        print3.setText("    Your guess is true!!!!   ");
                        text.setEditable(false);
                    }else if(num>r){
                        getContentPane().setBackground(Color.red);
                       print3.setText("Too High.Try a lower number."); 
                    }else if(num<r){
                         getContentPane().setBackground(Color.blue);
                        print3.setText("Too low. Try a higher number..");
                    }
                }catch(NumberFormatException e){
                   JOptionPane.showMessageDialog(null, " Error input .you must input number");
                }
            }
        });
               
          
        add(print3);
        add(text);
        but=new JButton("New Game");
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                print3.setText("Please Enter Your  Guess :");
            text.setEditable(true);
            text.setText("");
            r= (int) (Math.random()*1000+1);
             getContentPane().setBackground(Color.WHITE);
            }
        });
        add(but);
        setTitle("Guessing Game");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
    }
   public static void main(String []arges){
       new GuessingGame();
      
   } 
}
