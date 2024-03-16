package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{ //JFrame comes from swing package
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); //Image comes from awt package
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance =0;
        try{
            String query = "Select * from bank where pin = ?;";
            c.stmt = c.con.prepareStatement(query);
            c.stmt.setString(1,pinnumber);
            ResultSet rs = c.stmt.executeQuery();
            
            while (rs.next()){
            if(rs.getString("type").equals("Deposit"))
                balance += Integer.parseInt(rs.getString("amount"));
            else
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your Current Account balance is Rs. "+balance);
        text.setForeground(Color.WHITE);
        //text.setBackground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
