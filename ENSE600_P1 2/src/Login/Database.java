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
 * @author Katie LI and Leo JIA
 * @Student ID:18003055 and 20115737
 */
public class Database {

    private Connection conn = null;
    private static final String url = "jdbc:derby:AppDatabase;create=true";

    private static final String dbusername = "pdc";
    private static final String dbpassword = "pdc";

    private Statement myStatObj = null;
    private ResultSet myResObj = null;

    //initialise database connection
    public void setup() {
        String tableName;
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            myStatObj = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                myStatObj.executeLargeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(30), username VARCHAR(30), password VARCHAR(12), isAdmin INT)");
            }
            tableName = "Questions";
            if (!checkTableExisting(tableName)) {
                myStatObj.executeUpdate("CREATE TABLE " + tableName + " "
                        + "(questionid VARCHAR(38), question VARCHAR(120), "
                        + "username VARCHAR(30), topic VARCHAR(30))");
            }
            tableName = "Answers";
            if (!checkTableExisting(tableName)) {
                myStatObj.executeUpdate("CREATE TABLE " + tableName
                        + " (answerid VARCHAR(38), questionid VARCHAR(38), "
                        + "answer VARCHAR(120), username VARCHAR(30))");
            }
        } catch (Throwable e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Setup error");
        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {
            System.out.println("Checking existing tables...");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + " is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    //a method to check if the input userID and password are matching with the information in the db
    public LoginData loginAcc(String userID, String password) {
        LoginData data = new LoginData();
        try {
            String sql = "SELECT userid, username, password,isAdmin FROM UserInfo WHERE userid = '" + userID + "'and password= '" + password + "'";
            ResultSet rs = myStatObj.executeQuery(sql);
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
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    // a method to check if the account exist by using user ID
    public LoginData checkAccountExist(String userID) {
        // Initialize an instance of Data.
        LoginData data = new LoginData();

        try {
            String checkIfAccExist = "SELECT userID from UserInfo WHERE userID ='" + userID + "'";
            ResultSet rs = myStatObj.executeQuery(checkIfAccExist);
            //check if the user account exist or not, and change the value of accountExist back to Data
            if (rs.next()) {
                data.accountExist = true;
            } else {
                data.accountExist = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    //a method to write the new created account information back to db
    public LoginData createNewAccount(String userID, String password, String userName) {
        //initilizing instance of Data
        LoginData data = new LoginData();
        try {
            data = checkAccountExist(userID);
            //to make sure the user ID is unique, check if the input ID already been used
            if (data.accountExist) {
                JOptionPane.showMessageDialog(null, "User ID alrady exist! Please try another one.");
            } else {
                //collect the information from user input and write them back to db
                //and change the value of createNewAccDone back to Data
                String sql = "INSERT INTO UserInfo (userID, userName, password,isAdmin) VALUES('" + userID + "','" + userName + "','" + password + "',0)";
                myStatObj.execute(sql);
                data.createNewAccDone = true;
                //a message to remind the user the new account has been created successfully
                JOptionPane.showMessageDialog(null, "You new Account has been created!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    //a method to allow the user to reset their password by using their user ID
    public LoginData resetPassword(String userID, String newPassword) {
        // initilizing instance of Data
        LoginData data = new LoginData();

        try {
            data = checkAccountExist(userID);
            if (data.accountExist) {
                //when the input account exist, update the new password to the db and change the value of resetPasswordDone back to Data
                String sql = "UPDATE USERINFO SET PASSWORD = '" + newPassword + "'WHERE USERID= '" + userID + "'";
                myStatObj.execute(sql);
                data.resetPasswordDone = true;
                JOptionPane.showMessageDialog(null, "You new password has reseted!");
            } else {
                //when the input account doesnot exist, pop up a reminding message to the user
                JOptionPane.showMessageDialog(null, "User ID does not exist! Please try again!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    //a method to allow the admin user to delete an account by using userID
    public LoginData deleteAcc(String userID) {
        //initilizing the instance of Data
        LoginData data = new LoginData();
        try {
            data = checkAccountExist(userID);
            if (data.accountExist) {
                //when the input accout exist, delete it from db
                String sql = "DELETE FROM USERINFO WHERE USERID='" + userID + "'";
                myStatObj.execute(sql);
                data.deleteAccDone = true;
                JOptionPane.showMessageDialog(null, "Account deleted successfully!");
            } else {
                //when the input account doesnot exist, pop a message to remind the user
                JOptionPane.showMessageDialog(null, "The user ID you want to delete does not EXSIT!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void insertQuestion(Question question) {
        String statement = "INSERT INTO Questions VALUES ('"
                + question.getqId().replace("'", "''")
                + "', '" + question.getText()
                + "', '" + question.getAuthor()
                + "', '" + question.getTopic() + "')";
        System.out.println(statement);
        try {
            myStatObj.execute(statement);
        } catch (Throwable e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void insertAnswer(Answer answer) {
        String statement = "INSERT INTO Answers VALUES ('"
                + answer.getAnswerid().replace("'", "''") + "', '"
                + answer.getQuestionid() + "', '" + answer.getText() + "', '"
                + answer.getAuthor() + "')";
        System.out.println(statement);
        try {
            myStatObj.execute(statement);
        } catch (Throwable e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteQuestion(String questionId) {
        String statement = "DELETE FROM Questions WHERE questionid = '"
                + questionId + "'";
        System.out.println(statement);
        try {
            myStatObj.execute(statement);
        } catch (Throwable e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteAnswer(String answerid) {
        String statement = "DELETE FROM Answers WHERE answerid = '" + answerid + "'";
        System.out.println(statement);
        try {
            myStatObj.execute(statement);
        } catch (Throwable e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void initialiseQuestions(QuestionData qd) {
        try {
            myResObj = myStatObj.executeQuery("SELECT * FROM Questions");
            while (myResObj.next()) {
                String questionid = myResObj.getString("questionid").replace("''", "'");
                String question = myResObj.getString("question").replace("''", "'");;
                String author = myResObj.getString("username");
                String topic = myResObj.getString("topic");
                Question q = new Question(questionid, question, author, topic);
                qd.questions.put(questionid, q);
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("initialiseQuestions SQLException: " + e.getMessage());
        }
    }

    public void initialiseAnswers(QuestionData qd) {
        try {
            myResObj = myStatObj.executeQuery("SELECT * FROM Answers");
            while (myResObj.next()) {
                String answerid = myResObj.getString("answerid").replace("''", "'");
                String questionid = myResObj.getString("questionid").replace("''", "'");
                String answer = myResObj.getString("answer").replace("''", "'");
                String author = myResObj.getString("username");
                Answer a = new Answer(answerid, questionid, answer, author);
                qd.questions.get(questionid).answers.add(a);
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("initialiseQuestions SQLException: " + e.getMessage());
        }
    }

    // a method to close the db 
    public void quitSystem() {
        try {
            myStatObj.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
