package bank.managment.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author RishaS
 */
public class Login extends JFrame implements ActionListener{//inheritance
    
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    Login(){
        setTitle("Automated Teller Machine");
        
        setLayout(null); //to nullify by default layout and use the custom layout from line 23
        
        //steps to add a icon on to JFrame
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image imgScaler = img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //JLabel label = new JLabel(img);//img can be placed on JLabel but imgScaler cannot because its not part of that package
        //so converting imgScaler to ImageIcon again to place on JLabel
        ImageIcon img2 = new ImageIcon(imgScaler);
        JLabel label = new JLabel(img2);
        label.setBounds(70, 10, 100,100); //---starting from origin in x direction -> / starting from origin in y direction |v / length of this bound (a) / breadth of this bound (b)
        add(label); //to display on Label after setVisible is true
        
        //to add content 'Welcome to ATM'
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));// make sure to changee length of the text frame in setBounds based on the font chosen here
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        //to add content Card No
        JLabel cardNo = new JLabel("Card No :");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));// make sure to changee length of the text frame in setBounds based on the font chosen here
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);
        
        //adding text field for Card No entry
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        //to add content pin
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Osward", Font.BOLD, 28));// make sure to changee length of the text frame in setBounds based on the font chosen here
        pin.setBounds(120, 220, 400, 30);
        add(pin);
        
        //adding text field for Pin entry
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);  //background will be Black
        login.setForeground(Color.WHITE); //font will be white
        login.addActionListener(this);   //to perform on click event
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);  //background will be Black
        clear.setForeground(Color.WHITE); //font will be white 
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);  //background will be Black
        signup.setForeground(Color.WHITE); //font will be white 
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        
        
        setSize(800, 480);
        setVisible(true); //make image visible on the frame which by default is set to not display
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login){
            Conn c = new Conn();

            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            
            String query = "Select * from login where cardnumber = ? and pinnumber = ?;";
            
            try{
                c.stmt = c.con.prepareStatement(query);
                c.stmt.setString(1,cardnumber);
                c.stmt.setString(2,pinnumber);
                
                ResultSet rs = c.stmt.executeQuery();
                
                if(rs.next()){
                    setVisible(false);
                    //System.out.println(pinnumber);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
                
            } catch(Exception e){
                System.out.println(e);
            }
            
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        new Login();
    }
}
