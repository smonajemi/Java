package ws4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Control {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Control(){
      prepareGUI();
   }
   public static void main(String[] args){
      Control Control = new Control();  
      Control.showEventDemo();       
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Student Info");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showEventDemo(){
      headerLabel.setText("JAC444 - Workshop 5s"); 

      JButton AddButton = new JButton("Add Student");
      JButton SearchButton = new JButton("Search Student");
      JButton ExitButton = new JButton("Exit");

      AddButton.setActionCommand("Add");
      SearchButton.setActionCommand("Search");
      ExitButton.setActionCommand("Exit");

      AddButton.addActionListener(new ButtonClickListener()); 
      SearchButton.addActionListener(new ButtonClickListener()); 
      ExitButton.addActionListener(new ButtonClickListener()); 

      controlPanel.add(AddButton);
      controlPanel.add(SearchButton);
      controlPanel.add(ExitButton);       

      mainFrame.setVisible(true);  
   }
   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         
         if( command.equals( "Add" ))  {
            statusLabel.setText("Ok Button clicked.");
         } else if( command.equals( "Submit" ) )  {
            statusLabel.setText("Submit Button clicked."); 
         } else if(command.equals("Exit")){
            System.exit(0);
         }  	
      }		
   }
}