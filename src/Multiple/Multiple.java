
package Multiple;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public  class Multiple extends JFrame{

    public Multiple() {
       JPanel panel=new JPanel(new FlowLayout()); 
       DefaultListModel<String>DefaultListModel=new DefaultListModel<>();
       JList<String> list=new JList<>(DefaultListModel); 
       list.setPreferredSize(new Dimension(100, 100));
       DefaultListModel.addElement("Black");
        DefaultListModel.addElement("Blue");
        DefaultListModel.addElement("Cyan");
        DefaultListModel.addElement("Dark Gray");
        DefaultListModel.addElement("Gray");
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(120, 100));
        panel.add(scroll);
      
        
        JButton but=new JButton("Copy >>>");
        but.setFocusPainted(false);
       
       panel.add(but);
         
         JTextArea text=new JTextArea();
         JScrollPane scrollText=new JScrollPane(text);
         scrollText.setPreferredSize(new Dimension(100,100) );
        panel.add(scrollText);
        
        //**********************************************
         but.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
                String lister=" ";
               for (int i = 0; i < list.getSelectedValuesList().size(); i++) {
                   lister=lister+list.getSelectedValuesList().get(i)+"\n";
               }
              
              text.setText(lister);
           }
       });
         //***********************************
        this.add(panel);
       this.setLayout(new FlowLayout());
        setTitle("Multiple Selection Lists");
        setSize(400,170);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
   public static void main(String []args){
       new Multiple();
   }

  
    
}
