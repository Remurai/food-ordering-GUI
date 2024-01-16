import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
 public class WelcomeForm extends JFrame implements ActionListener
 {
     //Add GUI to Welcome Form
     JTextField txtFieldName = new JTextField(10);
     JButton btnProceed = new JButton("Proceed");
     JLabel labelTitle = new JLabel ("Welcome To COV Italian Food");
     JLabel labelName = new JLabel ("Enter Your Name: ");
     JLabel labelWarn = new JLabel ("");
        
     public static void main(String[] args)
     {
         new WelcomeForm();
     }
     
     public WelcomeForm() // a constructor- used to make up the interface
     {
         setLayout(new FlowLayout());
         setSize(400, 120);
         setTitle("Login");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setResizable(false);
         
         //Add a title at the top of the form
         add("North", labelTitle);
         
         //Add label and text field at the center of the form
         JPanel center= new JPanel();
         center.setLayout(new FlowLayout());
         center.add(labelName);
         center.add(txtFieldName);
         add("Center", center);
         
         //Add a button at the right side of the form
         add("South", btnProceed);
         add(labelWarn);
         btnProceed.addActionListener(this);
        
         setVisible(true);
     }
 
     public void actionPerformed(ActionEvent e)
     {
         //If the user presses the proceed button, the system performs that action
         if (e.getSource()==btnProceed){
             //If the user didn't enter the name, the system will warn the user
             if (txtFieldName.getText().equals("")){
                 labelWarn.setForeground (Color.red);
                 labelWarn.setText("Please fill in your name");
             }
             //Else it will proceed to the next form which is MainForm
             else{
                 new MainForm().setVisible(true);
                 this.setVisible(false);
             }
         }
     }
 }
