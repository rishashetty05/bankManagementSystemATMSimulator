package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    JLabel repintext, pintext, text;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //setting up image
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900); //make sure setLayout is set to null
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        pintext = new JLabel("New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(160, 320, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField ();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        repintext = new JLabel("Re-enter New PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);
        
        repin = new JPasswordField ();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //keep this line before setVisible to implement it
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                    return;
                }
                
                Conn c = new Conn();
                String query1 = "Update bank set pin = ? where pin = ?;";
                c.stmt = c.con.prepareStatement(query1);
                c.stmt.setString(1,rpin);
                c.stmt.setString(2,pinnumber);
                c.stmt.executeUpdate();
                
                String query2 = "Update login set pinnumber = ? where pinnumber = ?;";
                c.stmt = c.con.prepareStatement(query2);
                c.stmt.setString(1,rpin);
                c.stmt.setString(2,pinnumber);
                c.stmt.executeUpdate();
                
                String query3 = "Update signupthree set pinnumber = ? where pinnumber = ?;";
                c.stmt = c.con.prepareStatement(query3);
                c.stmt.setString(1,rpin);
                c.stmt.setString(2,pinnumber);
                c.stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "PIN changes Successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
