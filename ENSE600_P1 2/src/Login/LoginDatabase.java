/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yueli
 */
public class LoginDatabase {
    Connection conn = null;
    String url = "jdbc:derby:UserDB;create=true";
    
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    public void dbsetup(){
        try{
            conn = DriverManager.getConnection(url,dbusername,dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";
            
            if(!checkTableExisting(tableName)){
                statement.executeLargeUpdate("CREATE TABLE "+ tableName +" (userid VARCHAR(30), username VARCHAR(30), password VARCHAR(12), isAdmin INT)");
            }
            statement.close();  
        }catch(Throwable e){
            System.out.println("Error");
        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try{
            System.out.println("Checking existing tables...");
            String[] types ={"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            } 
        }catch(SQLException ex){
        }
        return flag; 
    }

    public Data checkName(String userID, String password) {
        Data data = new Data();
      try{
          Statement statement = conn.createStatement();
          String sql ="SELECT userid, password FROM UserInfo WHERE userid = '"+userID+"'and password= '"+password+"'"; 
          ResultSet rs = statement.executeQuery(sql);
          int count = 0;
          while(rs.next()){
              count+=1;
          }
          if(count==1){
              JOptionPane.showMessageDialog(null,"User Found, Login Successfully!");
              data.loginFlag = true; 
          }else if(count>1){
              JOptionPane.showMessageDialog(null, "Duplicate User, Login Denied!"); 
              data.loginFlag = false; 
          }else{
              JOptionPane.showMessageDialog(null, "Login unsuccessfully! Invalid ID or password. Try Again or choose another option.");
              data.loginFlag = false; 
          }
            
      }catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
    }
      return data;
    }  
    
    public Data createNewAccount(String userID, String password, String userName){
        Data data = new Data();
        LoginView view = new LoginView();
        userID = view.newUserId.getText().trim();
        password = view.newUserPassword.getText().trim();
        userName = view.newUserName.getText().trim();
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO UserInfo VALUES('"+userID+"','"+userName+"','"+password+"')";
            statement.execute(sql);
            data.createNewAccDone = true;
            JOptionPane.showMessageDialog(null, "You new Account has been created!");
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void quitSystem(){
        Statement statement;
        try{
            statement = conn.createStatement();
            statement.close();
            
        }catch (SQLException ex) {
           System.out.println("See you next time!");
        }
    }
}
