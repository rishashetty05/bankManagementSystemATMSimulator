package bank.managment.system;
import java.sql.PreparedStatement; //import mysql library
import java.sql.*;

public class Conn {
    
    Connection con;
    Statement s;
    PreparedStatement stmt;
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver); //1. calll driver using static function . Make sure u have downloaded
            //the connector jar file for mySQL. Mine is in Downloads
            con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root"); 
            //This is connection string. no need to write /localhost/3306 where mySQL runs bydefault
            s = con.createStatement();
            
        }    
        catch(Exception e){
              System.out.println(e);     
        }
    }
}
