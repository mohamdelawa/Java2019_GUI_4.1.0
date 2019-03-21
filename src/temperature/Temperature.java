
package temperature;




import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Temperature extends JFrame {

    public Temperature() {
        JPanel panelAll=new JPanel(new GridLayout(4,1));
        
        JLabel print1=new JLabel("Enter Celsius temperature ");
        JPanel panel=new JPanel(new GridLayout(1,1));
        JTextField text=new JTextField();
      
        panel.add(text);
        panelAll.add(print1);
        panelAll.add(panel);
        JPanel panelbut=new JPanel(new FlowLayout());
        ButtonGroup group = new ButtonGroup(); 
        JRadioButton but1=new JRadioButton("Fahrenheit");
        JRadioButton but2=new JRadioButton(" Kelvin ");
        group.add(but1);
        group.add(but2);
        panelbut.add(but1);
        panelbut.add(but2);
        JLabel print2=new JLabel("New Temperature in is :");
        panelAll.add(panelbut);
        panelAll.add(print2);
       //action lisiner
        but1.addActionListener(new ActionListener() {
          @Override
        public void actionPerformed(ActionEvent ae) {
               try{
               double x=Double.parseDouble(text.getText());
               x =(x*9)/5+32;
              print2.setText("New Temperature in is :"+x);
               }catch(Exception e){
                text.setText("error input");
               }
               
           }
       });
       but2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               try{
               double x=Double.parseDouble(text.getText());
               x =x+273.15; 
              print2.setText("New Temperature in is :"+x);
              }catch(Exception e){
                text.setText("error input");
               }
           }
       });
       add(panelAll);
        this.setLayout(new FlowLayout());
        
        setTitle("temperature-conversion");
        setSize(350,170);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
   public static void main(String []args){
       new Temperature();
   }
    
}
