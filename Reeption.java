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
   ResultSet rsx;
   public void ExecuteDB(String q){
       try {
           statement.execute(q);
       } catch (SQLException ex) {
           Logger.getLogger(Reeption.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
      public ResultSet loginData(){
        String sql = "SELECT * FROM login";
        Statement statement;
    try{
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    statement = conn.prepareStatement(sql);
    rsx = statement.executeQuery(sql);
    
    }catch(SQLException ex){
        
    }
        return rsx;
    }

    public static void main(String[] args){
        LoginForm xs = new LoginForm();   
    }
}
