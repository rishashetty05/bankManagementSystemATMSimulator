package bank.managment.system;  
//import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
//import java.util.*;

import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
/**
 * @author RishaS
 */
public class SignupOne extends JFrame implements ActionListener { //JFrame from swing package

    //make global declaration of text fields and variables used
    long random; //RANDOM IS NOT WORKING
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random(); //derived from utils package
        //System.out.println(Math.abs(ran.nextLong()%9000L + 1000L));
        random = Math.abs((ran.nextLong()%9000L) + 1000L);
        
        //this is a repetitive set
        JLabel formno = new JLabel("APPLICATION FORM No. "+ random); //random from util package
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600,40); // works only when setLaout is null as in line 16
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details "); //random from util package
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400,30); // works only when setLaout is null as in line 16
        add(personDetails);
        
        JLabel name = new JLabel("Name: "); //random from util package
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30); // works only when setLaout is null as in line 16
        add(name);
        
        nameTextField = new JTextField ();
        nameTextField.setBounds(300, 140, 400, 30);
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(nameTextField);
        
        JLabel fname = new JLabel("Fathers Name: "); //random from util package
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30); // works only when setLaout is null as in line 16
        add(fname);
        
        fnameTextField = new JTextField ();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: "); //random from util package
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30); // works only when setLaout is null as in line 16
        add(dob);
        
        //Import Jar file to apply calendar against DOB.
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
           
        JLabel gender = new JLabel("Gender: "); //random from util package
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30); // works only when setLaout is null as in line 16
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address: "); //random from util package
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30); // works only when setLaout is null as in line 16
        add(email);
        
        emailTextField = new JTextField ();
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status: "); //random from util package
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30); // works only when setLaout is null as in line 16
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address: "); //random from util package
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30); // works only when setLaout is null as in line 16
        add(address);
        
        addressTextField = new JTextField ();
        addressTextField.setBounds(300, 440, 400, 30);
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(addressTextField);
        
        JLabel city = new JLabel("City: "); //random from util package
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30); // works only when setLaout is null as in line 16
        add(city);
        
        cityTextField = new JTextField ();
        cityTextField.setBounds(300, 490, 400, 30);
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(cityTextField);
        
        JLabel state = new JLabel("State: "); //random from util package
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30); // works only when setLaout is null as in line 16
        add(state);
        
        stateTextField = new JTextField ();
        stateTextField.setBounds(300, 540, 400, 30);
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode: "); //random from util package
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30); // works only when setLaout is null as in line 16
        add(pincode);
        
        pinTextField = new JTextField ();
        pinTextField.setBounds(300, 590, 400, 30);
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(pinTextField);
        
        
        next = new JButton("NEXT");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);  //background will be Black
        next.setForeground(Color.WHITE); //font will be white
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);   //to perform on click event
        add(next);
        
        getContentPane().setBackground(Color.WHITE); //derived throught java.awt.Color Package
        
                
        setSize(850, 800); //1st lines written
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae) {
        String formno = ""+random; //long convert to string by adding " " +
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); //getUiComponent() returnd text value;
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
         if (married.isSelected()){
            marital = "Male";
        }else if (unmarried.isSelected()){
            marital = "Female";
        }else if (other.isSelected()){
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try {
           if (name.equals(""))
               JOptionPane.showMessageDialog(null, "Name is required");
           else{
               Conn c = new Conn();
//               String query = "INSERT into signup VALUES('"+ formno +"', '"+name+"', '"+fname+"', '"+dob"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"state+"');";
//               c.s.executeUpdate(query);
               String query = "INSERT INTO signup (formno, name, father_name, dob, gender, email, marital_status, address, city, pincode, state)"
                       + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
               c.stmt = c.con.prepareStatement(query);
               c.stmt.setString(1,formno);
               c.stmt.setString(2,name);
               c.stmt.setString(3,fname);
               c.stmt.setString(4,dob);
               c.stmt.setString(5,gender);
               c.stmt.setString(6,email);
               c.stmt.setString(7,marital);
               c.stmt.setString(8,address);
               c.stmt.setString(9,city);
               c.stmt.setString(10,pin);
               c.stmt.setString(11,state);
               c.stmt.executeUpdate();
               
               setVisible(false);
               new SignupTwo(formno).setVisible(true);
           }
           //Can add more validations
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupOne();
    }
}
