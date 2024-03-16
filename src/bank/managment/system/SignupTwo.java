package bank.managment.system;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SignupTwo extends JFrame implements ActionListener {//comes from swing package
    //make Global declarations on JFRAMEs
    
   //make global declaration of text fields and variables used

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;
    //setting up constructor
    SignupTwo(String formno){
        this.formno = formno;
        
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290, 80, 400,30);
        add(additionalDetails);
                
        JLabel religionLabel = new JLabel("Religion: "); //random from util package
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30); // works only when setLaout is null as in line 16
        add(religionLabel);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion= new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
       
        JLabel categoryLabel = new JLabel("Category: "); //random from util package
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 200, 30); // works only when setLaout is null as in line 16
        add(categoryLabel);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category= new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel incomeLabel = new JLabel("Income: "); //random from util package
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30); // works only when setLaout is null as in line 16
        add(incomeLabel);
        
        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income= new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
           
        JLabel educationLabel = new JLabel("Educational "); //random from util package
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 200, 30); // works only when setLaout is null as in line 16
        add(educationLabel);
    
        JLabel qualification = new JLabel("Qualification: "); //random from util package
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30); // works only when setLaout is null as in line 16
        add(qualification);
        
        String educationalValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        education= new JComboBox(educationalValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occupationLabel = new JLabel("Occupation: "); //random from util package
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 390, 200, 30); // works only when setLaout is null as in line 16
        add(occupationLabel);
        
        String occupationalValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation= new JComboBox(occupationalValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panLabel = new JLabel("PAN Number: "); //random from util package
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 440, 200, 30); // works only when setLaout is null as in line 16
        add(panLabel);
        
        pan = new JTextField ();
        pan.setBounds(300, 440, 400, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        add(pan);
        
        JLabel aadharLabel = new JLabel("AADHAR No: "); //random from util package
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 490, 200, 30); // works only when setLaout is null as in line 16
        add(aadharLabel);
        
        aadhar = new JTextField ();
        aadhar.setBounds(300, 490, 400, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        add(aadhar);
        
        JLabel scitizen = new JLabel("Senior Citizen: "); //random from util package
        scitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        scitizen.setBounds(100, 540, 200, 30); // works only when setLaout is null as in line 16
        add(scitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup scitizengroup = new ButtonGroup();
        scitizengroup.add(syes);
        scitizengroup.add(sno);
        
        JLabel ecustomer = new JLabel("Existing Customer: "); //random from util package
        ecustomer.setFont(new Font("Raleway", Font.BOLD, 20));
        ecustomer.setBounds(100, 590, 200, 30); // works only when setLaout is null as in line 16
        add(ecustomer);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
        next = new JButton("NEXT");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);  //background will be Black
        next.setForeground(Color.WHITE); //font will be white
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);   //to perform on click event
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String)religion.getSelectedItem(); //this function returns object
        String scategory = (String)category.getSelectedItem();
        String sincome    = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "Yes";
        }else if (sno.isSelected()){
            seniorcitizen = "No";
        }
       
        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
        }else if (eno.isSelected()){
            existingaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        
        try {
//          Validations removed
               Conn c = new Conn();
//          Using Prepared Statement
               String query = "INSERT INTO  signuptwo(formno, religion, category, income, education, occupation, seniorcitizen, existingaccount, pan, aadhar)"
                       + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
               c.stmt = c.con.prepareStatement(query);
               c.stmt.setString(1,formno);
               c.stmt.setString(2,sreligion);
               c.stmt.setString(3,scategory);
               c.stmt.setString(4,sincome);
               c.stmt.setString(5,seducation);
               c.stmt.setString(6,soccupation);
               c.stmt.setString(7,seniorcitizen);
               c.stmt.setString(8,existingaccount);
               c.stmt.setString(9,span);
               c.stmt.setString(10,saadhar);
              
               c.stmt.executeUpdate();
               
               //after this add signup 3 page object
               setVisible(false);
               new SignupThree(formno).setVisible(true);
           //Can add more validations
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]) {
        // TODO code application logic here
        new SignupTwo("");
    }
}
