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
          ResultSet rs = statement.executeQuery("SELECT userid, password FROM UserInfo "
                    + "WHERE userid = '" + userID + "'");
          if(rs.next()){
              String pass = rs.getString("password");
              System.out.println("***"+pass);
              System.out.println("found user");  
              if(password.compareTo(pass)==0){
                  data.loginFlag = true;
              }else{
                  data.loginFlag = false;
              }
          }else{
              System.out.println("no such user");
              this.quitSystem();
              data.loginFlag = false;
          }
            
      }catch (SQLException ex) {
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
