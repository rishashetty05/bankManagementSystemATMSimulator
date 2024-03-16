package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null); 
        
        // handling image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //setting up image
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900); //make sure setLayout is set to null
        add(image);
        
        JLabel text = new JLabel ("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text); //plain add(text) will add the text value behind the image
        
        amount = new JTextField ();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String amountDeposited = amount.getText();
            Date date = new Date();
            String dateString = date.toString();
            if (amountDeposited.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try{
                    Conn c = new Conn();
                    String query = "INSERT into bank VALUES (? , ? , ? , ?);";
                    c.stmt = c.con.prepareStatement(query);
                    c.stmt.setString(1,pinnumber);
                    c.stmt.setString(2,dateString);
                    c.stmt.setString(3,"Deposit");
                    c.stmt.setString(4,amountDeposited);
                    c.stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs "+amountDeposited+" deposited succesfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        // TODO code application logic here
        new Deposit("");
    }
}
