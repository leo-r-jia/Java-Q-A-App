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
                myStatObj.executeUpdate("CREATE TABLE " + tableName + " "
                        + "(questionid VARCHAR(38), question VARCHAR(120), "
                        + "username VARCHAR(30), topic VARCHAR(30))");
            }
            tableName = "Answers";

            if (!checkTableExisting(tableName)) {
                myStatObj.executeUpdate("CREATE TABLE " + tableName
                        + " (questionid VARCHAR(38), answer VARCHAR(120), "
                        + "username VARCHAR(30))");
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
        }
    }

    public void insertAnswer(Answer answer) {
        String statement = "INSERT INTO Answers VALUES ('" + answer.getQuestionid()
                + "', '" + answer.getText() + "', '" + answer.getAuthor() + "')";
        System.out.println(statement);
        try {
            myStatObj.execute(statement);
        } catch (Throwable e) {
            Logger.getLogger(QnaDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void initialiseQuestions(QuestionData qd) {
        try {
            myResObj = myStatObj.executeQuery("SELECT * FROM Questions");
            while (myResObj.next()) {
                String questionid = myResObj.getString("questionid").replace("''", "'");
                String question = myResObj.getString("question");
                String author = myResObj.getString("username");
                String topic = myResObj.getString("topic");
                Question q = new Question(questionid, question, author, topic);
                qd.questions.put(questionid, q);
                System.out.println(q.getqId());
                System.out.println(q.toString());
            }
        } catch (SQLException e) {
            Logger.getLogger(QnaDatabase.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("initialiseQuestions SQLException: " + e.getMessage());
        }
    }

    public void initialiseAnswers(QuestionData qd) {
        try {
            myResObj = myStatObj.executeQuery("SELECT * FROM Answers");
            while (myResObj.next()) {
                String questionid = myResObj.getString("questionid").replace("''", "'");
                String answer = myResObj.getString("question").replace("''", "'");
                String author = myResObj.getString("username");
                Answer a = new Answer(questionid, answer, author);
                qd.questions.get(questionid).answers.add(a);
                System.out.println(a.toString());
            }
        } catch (SQLException e) {
            Logger.getLogger(QnaDatabase.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("initialiseQuestions SQLException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        QnaDatabase q = new QnaDatabase();
        QuestionData qd = new QuestionData();
        q.setup();
        q.initialiseQuestions(qd);
        q.initialiseAnswers(qd);
        Answer a = new Answer("84cefe42-2ed7-4046-bf6e-d5cf06e3c941", "No I don't think so")
    }
}
