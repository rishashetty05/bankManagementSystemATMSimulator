package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class SignupThree extends JFrame implements ActionListener{//JFrame comes from swing package
    // ActionListener is an Abstract class coming from event package
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null); //for setBounds to work you have to make the existing default layout to null;
        
        JLabel l1 = new JLabel ("Page 3 : Account details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));// Font Class comes from awt 
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel ("Account Type : ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));// Font Class comes from awt 
        type.setBounds(100, 120, 200, 30);//100 is horizontal length from left & 140 is vertical length from top so obviously has to be more than 40 of l1
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));// RadioButton option 1 for label "type"
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 160, 150, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));// RadioButton option 2 for label "type"
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 160, 250, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));// RadioButton option 3 for label "type"
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 200, 250, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));// RadioButton option 4 for label "type"
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 200, 250, 20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup(); //GroupButton to avoid multple RadioButton Selection
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel ("Card Number : ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));// Font Class comes from awt 
        card.setBounds(100, 280, 200, 30);
        add(card);
        
        JLabel number = new JLabel ("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));// Font Class comes from awt 
        number.setBounds(330, 280, 300, 30);
        add(number);
        
        JLabel carddetail = new JLabel ("This is your 16 digit card number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));// Font Class comes from awt 
        carddetail.setBounds(100, 310, 300, 20);
        add(carddetail);
        
        JLabel pin = new JLabel ("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));// Font Class comes from awt 
        pin.setBounds(100, 350, 200, 30);
        add(pin);
        
        JLabel pnumber = new JLabel ("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));// Font Class comes from awt 
        pnumber.setBounds(330, 350, 300, 30);
        add(pnumber);
        
        JLabel pindetail = new JLabel ("Your 4 digit Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));// Font Class comes from awt 
        pindetail.setBounds(100, 380, 300, 20);
        add(pindetail);
        
        JLabel services = new JLabel ("Services Required : ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));// Font Class comes from awt 
        services.setBounds(100, 430, 300, 30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));// Font Class comes from awt 
        c1.setBounds(100, 480, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));// Font Class comes from awt 
        c2.setBounds(350, 480, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));// Font Class comes from awt 
        c3.setBounds(100, 530, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));// Font Class comes from awt 
        c4.setBounds(350, 530, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));// Font Class comes from awt 
        c5.setBounds(100, 580, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));// Font Class comes from awt 
        c6.setBounds(350, 580, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that teh above entered information is correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));// Font Class comes from awt 
        c7.setBounds(100, 660, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        //change colour of the window
        
        setSize(850,800); // sets size of the frame first and the dsplays JLabel l1 in it
        setLocation (350,0); //Location of the frmae from the origin on the screen which is usually at top left most
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()){
                accountType = "Current Account";
            } else if (r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random random = new Random(); //this comes from util package
            String cardnumber = ""+ Math.abs((random.nextLong() % 9000000L) + 5040936000000000L);
            
            String pinnumber = ""+ Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if (c1.isSelected()){
                facility = facility + " ATM CARD";
            } else if (c2.isSelected()){
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()){
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()){
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()){
                facility = facility + " E-Statement";
            } 
            
            try {
                if (accountType == ""){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }else{
                    Conn c = new Conn();
                    //Using Prepared Statement
                    String query1 = "INSERT INTO  signupthree(formno, accountType, cardnumber, pinnumber, facility)"
                       + "VALUES(?, ?, ?, ?, ?);";
                    c.stmt = c.con.prepareStatement(query1);
                    c.stmt.setString(1,formno);
                    c.stmt.setString(2,accountType);
                    c.stmt.setString(3,cardnumber);
                    c.stmt.setString(4,pinnumber);
                    c.stmt.setString(5,facility);
                    c.stmt.executeUpdate();
                    
                    String query2 = "INSERT INTO  login(formno, cardnumber, pinnumber)"
                       + "VALUES(?, ?, ?);";
                    c.stmt = c.con.prepareStatement(query2);
                    c.stmt.setString(1,formno);
                    c.stmt.setString(2,cardnumber);
                    c.stmt.setString(3,pinnumber);
                    c.stmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Card Number : "+ cardnumber+ "\n Pin : "+ pinnumber );
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            } catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new SignupThree("");
    }
}
