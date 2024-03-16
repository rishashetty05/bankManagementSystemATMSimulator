package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.Date;//compiler gets confused where to pick up Date class from

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdrawal, fastcash, ministatement, pinchange, balanceenquiry, back;
    String pinnumber;
    
     FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
       // System.out.print(pinnumber);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); //Image comes from awt package
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel ("Please select withdrawal amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text); //plain add(text) will add the text value behind the image
        
        deposit = new JButton("Rs.100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Rs.500");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Rs.1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs.2000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs.5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs.10000");
        balanceenquiry.addActionListener(this);
        balanceenquiry.setBounds(355, 485, 150, 30);
        image.add(balanceenquiry);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //keep this line before setVisible to implement it
        setVisible(true);
        
    }
     
      public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //convert object into string USING jbutton & TAKE SUBSTRING
            Conn c = new Conn();
            try{
                String query = "Select * from bank where pin = ?;";
                c.stmt = c.con.prepareStatement(query);
                c.stmt.setString(1,pinnumber);
               // Resultset rs = c.con.prepareStatement("Select * from bank where pin = ?");
                ResultSet rs = c.stmt.executeQuery();
                int balance =0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit"))
                        balance += Integer.parseInt(rs.getString("amount"));
                    else
                        balance -= Integer.parseInt(rs.getString("amount"));
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String dateString = date.toString();
                String query2 = "INSERT into bank VALUES (? , ? , ? , ?);";
                c.stmt = c.con.prepareStatement(query2);
                c.stmt.setString(1,pinnumber);
                c.stmt.setString(2,dateString);
                c.stmt.setString(3,"Withdrawal");
                c.stmt.setString(4,amount);
                c.stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Rs."+amount+" debited successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]) {
        // TODO code application logic here
        new FastCash("");
    }
}
