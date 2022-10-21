package Login;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leo
 */
public class QnaDatabase {

    private Connection conn = null;
    private static final String url = "jdbc:derby:QuestionDB;create=true";
    private static final String dbusername = "pdc";  //your DB username
    private static final String dbpassword = "pdc";   //your DB password
    private Statement myStatObj = null;
    private ResultSet myResObj = null;

    public void setup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            myStatObj = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String tableName = "Questions";

            if (!checkTableExisting(tableName)) {
                myStatObj.executeUpdate("CREATE TABLE " + tableName + " (questionid VARCHAR(38), question VARCHAR(120), username VARCHAR(30), topic VARCHAR(30))");
            }
            myStatObj.close();

        } catch (Throwable e) {
            System.out.println("SQL error");
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
        }
        return flag;
    }

    public void quitSystem() {
        try {
            myStatObj.close();

        } catch (SQLException ex) {
            System.out.println("Qna Database quit");
        }
    }

    public void newQuestion(Question question) {
        String statement = "INSERT INTO QUESTIONS (QUESTIONID, QUESTION, USERNAME, "
                + "TOPIC) VALUES ('" + question.getqId() + "', '" + question.getText()
                + "', '" + question.getAuthor() + "', '" + question.getTopic() + "')";
        try {
            myStatObj.executeUpdate(statement);
        } catch (Throwable e) {
            System.out.println("newQuestion SQL error");
        }
    }

    public void initialiseQuestions() {
        try {
            myResObj = myStatObj.executeQuery("SELECT * FROM BOOKINGS");
            while (myResObj.next()) {
                
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        QnaDatabase q = new QnaDatabase();
        q.setup();
        Question qu = new Question("Does anyone know Weihua's email?", "Lily Chen", "General");
        q.newQuestion(qu);
    }
}
