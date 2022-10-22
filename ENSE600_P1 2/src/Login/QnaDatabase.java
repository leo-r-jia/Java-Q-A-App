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
        } catch (Throwable e) {
            Logger.getLogger(QnaDatabase.class.getName()).log(Level.SEVERE, null, e);
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

    public void insertQuestion(Question question) {
        String statement = "INSERT INTO Questions VALUES ('" + question.getqId()
                + "', '" + question.getText() + "', '" + question.getAuthor()
                + "', '" + question.getTopic() + "')";
        System.out.println(statement);
        try {
            myStatObj.execute(statement);
        } catch (Throwable e) {
            Logger.getLogger(QnaDatabase.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("newQuestion SQL error");
        }
    }

    public QuestionData initialiseQuestions() {
        QuestionData questionData = new QuestionData();
        int i = 0;
        try {
            myResObj = myStatObj.executeQuery("SELECT * FROM Questions");
            while (myResObj.next()) {
                String questionid = myResObj.getString("questionid").replace("''", "'");
                String question = myResObj.getString("question");
                String author = myResObj.getString("username");
                String topic = myResObj.getString("topic");
                Question q = new Question(questionid, question, author, topic);
                questionData.questions.put(i, q);
                i++;
            }
        } catch (SQLException e) {
            Logger.getLogger(QnaDatabase.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("initialiseQuestions SQLException: " + e.getMessage());
        }
        return questionData;
    }

    public static void main(String[] args) {
        QnaDatabase q = new QnaDatabase();
        q.setup();
        
    }
}
