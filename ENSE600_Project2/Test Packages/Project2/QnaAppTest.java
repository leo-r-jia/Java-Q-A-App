package Project2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * Test of setup method, of class Database.
     */
    @Test
    public void testDbsetup() {
        System.out.println("dbsetup");
        Database instance = new Database();
        instance.setup();

    }

    /**
     * Test of loginAcc method, of class LoginDatabase.
     */
//    @Test
//    public void testLoginAcc() {
//        System.out.println("loginAcc");
//        String userID = "";
//        String password = "";
//        LoginDatabase instance = new LoginDatabase();
//        Data expResult =null;
//        Data result = instance.loginAcc(userID, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of checkAccountExist method, of class LoginDatabase.
//     */
//    @Test
//    public void testCheckAccountExist() {
//        System.out.println("checkAccountExist");
//        String userID = "";
//        String url = "jdbc:derby:UserDB;create=true";
//        String dbusername = "pdc";
//        String dbpassword = "pdc";
//        LoginDatabase instance = new LoginDatabase();
//        try {
//            instance.conn =DriverManager.getConnection(url,dbusername,dbpassword);
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Data expResult = null;
//        Data result = instance.checkAccountExist(userID);
//        assertEquals(expResult, result);
//         
//    }
//
//    /**
//     * Test of createNewAccount method, of class LoginDatabase.
//     */
//    @Test
//    public void testCreateNewAccount() {
//        System.out.println("createNewAccount");
//        String userID = "";
//        String password = "";
//        String userName = "";
//        LoginDatabase instance = new LoginDatabase();
//        Data expResult = null;
//        Data result = instance.createNewAccount(userID, password, userName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of resetPassword method, of class LoginDatabase.
//     */
//    @Test
//    public void testResetPassword() {
//        System.out.println("resetPassword");
//        String userID = "";
//        String newPassword = "";
//        LoginDatabase instance = new LoginDatabase();
//        Data expResult = null;
//        Data result = instance.resetPassword(userID, newPassword);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of deleteAcc method, of class LoginDatabase.
//     */
//    @Test
//    public void testDeleteAcc() {
//        System.out.println("deleteAcc");
//        String userID = "";
//        LoginDatabase instance = new LoginDatabase();
//        Data expResult = null;
//        Data result = instance.deleteAcc(userID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of quitSystem method, of class LoginDatabase.
//     */
    @Test
    public void testQuitSystem() {
        System.out.println("quitSystem");
        String url = "jdbc:derby:UserDB;create=true";
        String dbusername = "pdc";
        String dbpassword = "pdc";
        Database instance = new Database();
        try {
            instance.conn = DriverManager.getConnection(url, dbusername, dbpassword);
        } catch (SQLException ex) {
            Logger.getLogger(QnaAppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.quitSystem();
    }
//    
}
