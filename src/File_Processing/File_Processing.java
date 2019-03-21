
package File_Processing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;



public class File_Processing extends JFrame{
    JMenuBar menuBar;
    JMenu file, edit;
    JMenuItem open, close, exit, font, color;
    JTextArea text;
    JScrollPane scroll;
    
    public File_Processing() {
        text=new JTextArea();
        text.setLineWrap(true); 
        text.setEditable(false);
        text.setText("Enter File??");
        text.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        scroll = new JScrollPane(text);

        this.add(scroll);
             //add menuBar
        menuBar = new JMenuBar();
            //add File and add open,close,exit
        file=new JMenu("File");
        open=new JMenuItem("Open",'O');
        close=new JMenuItem("Close",'C');
        exit=new JMenuItem("Exit",'x');
            //add open,close,exit in file
        file.add(open);
        file.add(close);
        file.add(exit);
        
            //add Edit and add font,color
        edit=new JMenu("Edit");
        font=new JMenuItem("Font",'F');
        color=new JMenuItem("color");
      
             //add font,color in edit
        edit.add(font);
        edit.add(color);
       
           //add file ,edit in menuBar
        menuBar.add(file);
        menuBar.add(edit);
                //add JMenuBar in jframe 
        setJMenuBar(menuBar);
        
      //  ********************************************************************************************************************
              //action items in menues
             // action on menuItem open
        open.setAction(new AbstractAction("open") {
            @Override
            public void actionPerformed(ActionEvent event){
                try{
                    
                   JFileChooser fileChooser = new JFileChooser();
                   FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
                   fileChooser.setFileFilter(filter);
                   fileChooser.showOpenDialog(File_Processing.this);
                   File selectedFile = fileChooser.getSelectedFile(); 
                   if (selectedFile!=null) {
                      
                       Scanner Scanner=new Scanner(selectedFile);
                       text.setText("");
                       while(Scanner.hasNextLine()){
                            text.append(Scanner.nextLine()+"\n");
                         
                        }
                       System.out.println("Open File and write True.");
                    }
		    text.setEditable(true);
                }
                catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error File ");
                        System.out.println("Open File or  writing False");
                }
	   }
        });
            // action on menuItem close
        close.setAction(new AbstractAction("close") {
             @Override
             public void actionPerformed(ActionEvent event){
                 text.setText("Enter File??");
                 text.setEditable(false);
		               System.out.println("Close True");
	    }
        });
            // action on menuItem  exit
        exit.setAction(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent event){
                System.out.println("Exit True");
		System.exit(0);
	    }
        });
             // action on menuItem font
        font.setAction(new AbstractAction("font") {
            @Override
            public void actionPerformed(ActionEvent event){
	 
                String x=  (String) JOptionPane.showInputDialog(
                     null,
                     "Choose Font Size",
                     "Font Size",
                     JOptionPane.INFORMATION_MESSAGE,
                     null, 
                     new String[]{"8", "14", "18", "24", "30", "37", "48", "60", "68","75", "82","90"},
                    "18"
                );
                
                
                
                text.setFont(new Font("TimesRoman", Font.PLAIN,Integer.parseInt(x)));
                System.out.println("Font Size Text :"+x+ " \n in true ");
	    }
        });
            // action on menuItem color
        color.setAction(new AbstractAction("color") {
            @Override
            public void actionPerformed(ActionEvent event){
                Color initialcolor=Color.BLACK;    
		Color selectedColor = JColorChooser.showDialog(null,"hty", initialcolor);
                text.setForeground(selectedColor);
                System.out.println("Color Choose \n True");
	    }
        });

              // private jframe
        setTitle(" File_Processing");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
         new File_Processing();
    
   
       
    }
    
  
}
