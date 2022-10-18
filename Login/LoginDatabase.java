/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author yueli
 */
public class LoginDatabase {
    Connection conn = null;
    String url = "jdbc:derby:UserDB;create=true";
    
    String dbuserid = "100";
    String dbpassword = "0000";
    
    public void dbsetup(){
        try{
            conn = DriverManager.getConnection(url,dbuserid,dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";
            
            if(!checkTableExisting(tableName)){
                statement.executeLargeUpdate("CREATE TABLE "+ tableName +" (userid VARCHAR(12), password VARCHAR(12), isAdmin INT)");
            }
            statement.close();  
        }catch(Throwable e){
            System.out.println("Error");
        }
    }

    private boolean checkTableExisting(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Data checkName(String userID, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
   
    
    
    
}
