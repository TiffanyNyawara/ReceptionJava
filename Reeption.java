/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reeption;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author triad
 */
public class Reeption {
     // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/oopclass";

   //  Database credentials
   static final String USER = "triad";
   static final String PASS = "Tony0772780176";
   Statement statement;
   public void InsertDB(String q){
       try {
           statement.execute(q);
       } catch (SQLException ex) {
           Logger.getLogger(Reeption.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

    public static void main(String[] args){
        Connection conn = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
        Statement statement = conn.createStatement();
            String query1 = "SELECT * FROM login";
            ResultSet resultSet = statement.executeQuery(query1);
            System.out.print("\nQuery 1 Success");
            
            while(resultSet.next()){
                String n = resultSet.getString("UserName");
                String p = resultSet.getString("Password");
                
                System.out.print("\nUsername: " + n + " \nPassword:" + p);
            }
            System.out.print("\n\nResults Obtained");
            
   }catch(SQLException se){
            //Handle errors for JDBC

   }catch(ClassNotFoundException e){
            //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
        
        /*try{
            Class.forName("com.mysql.jbdc.Driver");
            // Connection
            Connection connect = DriverManager.getConnection("jbdc:mysql://localhost:3306/oopclass","root","Tony0772780176");
            System.out.print("Connection Established..");
            
            Statement statement = connect.createStatement();
            String query1 = "SELECT * FROM login";
            ResultSet resultSet = statement.executeQuery(query1);
            System.out.print("/nQuery 1 Success");
            
            while(resultSet.next()){
                String n = resultSet.getString("UserName");
                String p = resultSet.getString("Password");
                
                System.out.print("\nUsername: " + n + " Password:" + p);
            }
            System.out.print("\n\nResults Obtained");
            connect.close();  
        }catch(Exception e){
            System.out.print("\nError!");
        }*/
    }
}
