import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

 public class MainForm extends JFrame implements ActionListener
 {
     //Add GUI to Main Form
     double total;
     DecimalFormat df = new DecimalFormat("#,###,##0.00");
     JTextArea txtArea = new JTextArea(9,20);
     JScrollPane jsp = new JScrollPane(txtArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
     JButton btnAdd = new JButton("Add");
     JButton btnClear = new JButton("Clear");
     JButton btnPay = new JButton("Pay now");
     JLabel lTotal = new JLabel ("Total");
     JLabel label = new JLabel ("What would you like to order                            Ordered list");
     JRadioButton f1 = new JRadioButton();
     JRadioButton f2 = new JRadioButton();
     JRadioButton f3 = new JRadioButton();
     JRadioButton f4 = new JRadioButton();
     JRadioButton f5 = new JRadioButton();
     JRadioButton f6 = new JRadioButton();
     JRadioButton f7 = new JRadioButton();
     ButtonGroup food = new ButtonGroup();
     
     public static void main(String[] args)
     {
         new MainForm();
     }
     
     public MainForm() // a constructor- used to make up the interface
     {
         setSize(420, 260);
         setTitle("Menu");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setResizable(false);
         
         //Set each radio buttons with text
         f1.setText("Pizza                   RM 15.00");
         f2.setText("Burger                RM 10.10");
         f3.setText("Spaghetti           RM 11.50");
         f4.setText("Ravioli                RM 9.55");
         f5.setText("Baguette            RM 5.15");
         f6.setText("Mac&Cheese    RM 10.20");
         f7.setText("Lasagna            RM 12.30");
         
         //Add a text which ask the user to order at the top of the form
         add("North", label);
         
         //Add radio buttons at the left side of the form
         JPanel west= new JPanel();
         west.setLayout(new BoxLayout(west, BoxLayout.PAGE_AXIS));
         west.add(f1);
         west.add(f2);
         west.add(f3);
         west.add(f4);
         west.add(f5);
         west.add(f6);
         west.add(f7);
         add("West", west);
         
         //Add radio buttons into a group
         food.add(f1);
         food.add(f2);
         food.add(f3);
         food.add(f4);
         food.add(f5);
         food.add(f6);
         food.add(f7);
         
         //Add the order list form
         JPanel text= new JPanel();
         text.add(jsp);
         text.add(lTotal);
         add(text);
         
         //Add buttons at the bottom of the form
         JPanel bottom= new JPanel();
         bottom.setLayout(new FlowLayout());
         bottom.add(btnAdd);
         bottom.add(btnClear);
         bottom.add(btnPay);
         add("South", bottom);
         
         //Makes the buttons to function
         btnAdd.addActionListener(this);
         btnClear.addActionListener(this);
         btnPay.addActionListener(this);       
         setVisible(true);
     }
 
     public void actionPerformed(ActionEvent e)
     {  
         String text;
         
         //If the user presses the pay button, the system performs that action
         if (e.getSource()==btnPay){
             //If the user didn't order anything, the system warns the user.
             if (txtArea.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "You didn't order anything yet!!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
             }
             //Else the system will display a summary of the user's order.
             else{
                 JOptionPane.showMessageDialog(null, "Your total bill is RM" + df.format(total) + "\nYour order will be delivered soon."
                 + "\nThank you for ordering from COV Italian Food.", "Summary", JOptionPane.PLAIN_MESSAGE);
                 this.setVisible(false);
                 System.exit(0);
             }
         }
         
         //If the user presses the add button, the system performs that action
         else if (e.getSource()==btnAdd){
             //If the user selects the specific food, add it on the text area and calculate the total 
             if (f1.isSelected()){
                 text = f1.getText();
                 txtArea.append(text + "\n");
                 total+=15;
             }
             else if (f2.isSelected()){
                 text = f2.getText();
                 txtArea.append(text + "\n");
                 total+=10.10;
             }
             else if (f3.isSelected()){
                 text = f3.getText();
                 txtArea.append(text + "\n");
                 total+=11.50; 
             }
             else if (f4.isSelected()){
                 text = f4.getText();
                 txtArea.append(text + "\n");
                 total+=9.55; 
             }
             else if (f5.isSelected()){
                 text = f5.getText();
                 txtArea.append(text + "\n");
                 total+=5.15;
             }
             else if (f6.isSelected()){
                 text = f6.getText();
                 txtArea.append(text + "\n");
                 total+=10.20;
             }
             else if (f7.isSelected()){
                 text = f7.getText();
                 txtArea.append(text + "\n");
                 total+=12.30;
             }
             //If the user didn't selects any food, the system will display warning message
             else{
                 JOptionPane.showMessageDialog(null, "You haven't choose the food yet!!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
             }
             lTotal.setText("Total: RM " + df.format(total));
         }
         
         //If the user presses the clear button, the system performs that action
         else if (e.getSource()==btnClear){
             //If there is nothing to clear, the system will tell the user.
             if (txtArea.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "There is nothing to clear!!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
             }
             //If there are orders, then the system will clears all of them.
             else{
                 txtArea.setText("");
                 total = 0;
                 lTotal.setText("Total");
             }
         }
     }
 }
