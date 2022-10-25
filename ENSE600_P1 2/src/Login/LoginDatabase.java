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
 * @author Katie LI
 * @Student ID:18003055
 */
public class LoginDatabase {

    Connection conn = null;
    String url = "jdbc:derby:UserDB;create=true";

    String dbusername = "pdc";
    String dbpassword = "pdc";

    //the method for initializing the connection between the program and the database.
    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeLargeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(30), username VARCHAR(30), password VARCHAR(12), isAdmin INT)");
            }
            statement.close();
        } catch (Throwable e) {
            System.out.println("Error");
        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {
            System.out.println("Checking existing tables...");
            String[] types = {"TABLE"};
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
        } catch (SQLException ex) {
        }
        return flag;
    }

    //a method to check if the input userID and password are matching with the information in the db
    public Data loginAcc(String userID, String password) {
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT userid, username, password,isAdmin FROM UserInfo WHERE userid = '" + userID + "'and password= '" + password + "'";
            ResultSet rs = statement.executeQuery(sql);
            int count = 0;
            //check if the user exist, initilized the username back to Data; 
            while (rs.next()) {
                count += 1;
                data.username = rs.getString(2);
                //check if the user is admin, if yes, pop up a window for greeting and change the value of isAdmin as true
                //if not admin, change the value of isAdmin as false
                if (rs.getInt(4) == 1) {
                    data.isAdmin = true;
                    JOptionPane.showMessageDialog(null, "Kia ora Admin!");
                } else {
                    data.isAdmin = false;
                }
            }
            //use count to check if the user exist or not, and change the value of loginFlag;
            if (count == 1) {
                JOptionPane.showMessageDialog(null, "User Found, Login Successfully!");
                data.loginFlag = true;
            } else if (count > 1) {
                JOptionPane.showMessageDialog(null, "Duplicate User, Login Denied!");
                data.loginFlag = false;
            } else {
                JOptionPane.showMessageDialog(null, "Login unsuccessfully! Invalid ID or password. Try Again or choose another option.");
                data.loginFlag = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    // a method to check if the account exist by using user ID
    public Data checkAccountExist(String userID) {
        // Initialize an instance of Data.
        Data data = new Data();

        try {
            Statement statement = conn.createStatement();
            String checkIfAccExist = "SELECT userID from UserInfo WHERE userID ='" + userID + "'";
            ResultSet rs = statement.executeQuery(checkIfAccExist);
            //check if the user account exist or not, and change the value of accountExist back to Data
            if (rs.next()) {
                data.accountExist = true;
            } else {
                data.accountExist = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    //a method to write the new created account information back to db
    public Data createNewAccount(String userID, String password, String userName) {
        //initilizing instance of Data
        Data data = new Data();
        try {
            data = checkAccountExist(userID);
            //to make sure the user ID is unique, check if the input ID already been used
            if (data.accountExist) {
                JOptionPane.showMessageDialog(null, "User ID alrady exist! Please try another one.");
            } else {
                //collect the information from user input and write them back to db
                //and change the value of createNewAccDone back to Data
                Statement statement = conn.createStatement();
                String sql = "INSERT INTO UserInfo (userID, userName, password,isAdmin) VALUES('" + userID + "','" + userName + "','" + password + "',0)";
                statement.execute(sql);
                data.createNewAccDone = true;
                //a message to remind the user the new account has been created successfully
                JOptionPane.showMessageDialog(null, "You new Account has been created!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    //a method to allow the user to reset their password by using their user ID
    public Data resetPassword(String userID, String newPassword) {
        // initilizing instance of Data
        Data data = new Data();

        try {
            data = checkAccountExist(userID);
            if (data.accountExist) {
                //when the input account exist, update the new password to the db and change the value of resetPasswordDone back to Data
                Statement statement = conn.createStatement();
                String sql = "UPDATE USERINFO SET PASSWORD = '" + newPassword + "'WHERE USERID= '" + userID + "'";
                statement.execute(sql);
                data.resetPasswordDone = true;
                JOptionPane.showMessageDialog(null, "You new password has reseted!");
            } else {
                //when the input account doesnot exist, pop up a reminding message to the user
                JOptionPane.showMessageDialog(null, "User ID does not exist! Please try again!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

//a method to allow the admin user to delete an account by using userID
    public Data deleteAcc(String userID) {
        //initilizing the instance of Data
        Data data = new Data();
        try {
            data = checkAccountExist(userID);
            if (data.accountExist) {
                //when the input accout exist, delete it from db
                Statement statement = conn.createStatement();
                String sql = "DELETE FROM USERINFO WHERE USERID='" + userID + "'";
                statement.execute(sql);
                data.deleteAccDone = true;
                JOptionPane.showMessageDialog(null, "Account deleted successfully!");
            } else {
                //when the input account doesnot exist, pop a message to remind the user
                JOptionPane.showMessageDialog(null, "The user ID you want to delete does not EXSIT!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    // a method to close the db 
    public void quitSystem() {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
