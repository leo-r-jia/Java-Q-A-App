package Project2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katie LI and Leo JIA
 */
public class QnaAppTest {

    public QnaAppTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setup method, in class Database.
     */
    @Test
    public void testDbsetup() {
        System.out.println("dbsetup");
        Database instance = new Database();
        instance.setup();

    }

    /**
     * Test of createNewAcc method, in class Model.
     */
    @Test
    public void testCreateNewAcc() {
        System.out.println("createNewAcc");
        String userID = "";
        String userName = "";
        String password = "";
        Model instance = new Model();
        instance.createNewAcc(userID, userName, password);
    }

    /**
     * Test of deleteAcc method, in class Model.
     */
    @Test
    public void testDeleteAcc() {
        System.out.println("deleteAcc");
        String userID = "";
        Model instance = new Model();
        instance.deleteAcc(userID);
    }

    /**
     * Test of resetPassword method, in class Model.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        String userID = "";
        String newPassword = "";
        Model instance = new Model();
        instance.resetPassword(userID, newPassword);
    }

    /**
     * Test of initialiseQuestionData method, in class Model.
     */
    @Test
    public void testInitialiseQuestionData() {
        System.out.println("initialiseQuestionData");
        Model instance = new Model();
        instance.initialiseQuestionData();

        boolean result = instance.questionData.questions.isEmpty();
        assertFalse(result);
    }

    /**
     * Test of insertQuestion method, in class Database.
     */
    @Test
    public void testInsertQuestion() {
        System.out.println("insertQuetion");
        Database instance = new Database();
        instance.setup();
        Question q = new Question("Test", "Test", "Test");
        instance.insertQuestion(q);      
        instance.deleteQuestion(q.getqId());
    }
}
