package bank.managment.system;

import java.awt.Color;
import javax.swing.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
    
    String pinnumber;

    MiniStatement(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel bank = new JLabel ("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel ();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{
            Conn c = new Conn();
            String query = "Select * from login where pinnumber = ?;";
            
            c.stmt = c.con.prepareStatement(query);
            c.stmt.setString(1,pinnumber);
            ResultSet rs = c.stmt.executeQuery();

// for testing 
//          ResultSet rs = c.s.executeQuery("Select * from login where pinnumber = 4444");
//            
            while(rs.next()){
                card.setText("Card Number : "+ rs.getString("cardnumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));        
            }
        } catch (Exception e){
            System.out.println(e);
        }
        int bal=0;
        try{
            Conn c = new Conn();
            String query = "Select * from bank where pin = ?;";        
            c.stmt = c.con.prepareStatement(query);
            c.stmt.setString(1,pinnumber);
            ResultSet rs = c.stmt.executeQuery();
//            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '4444';");
            
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><HTML>");  
                if(rs.getString("type").equals("Deposit"))
                    bal += Integer.parseInt(rs.getString("amount"));
                else
                    bal -= Integer.parseInt(rs.getString("amount"));
            }
            balance.setText("Your current balance is Rs. "+ bal);
        } catch (Exception e){
            System.out.println(e);
        }
      
        
        
        setSize(400,600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
