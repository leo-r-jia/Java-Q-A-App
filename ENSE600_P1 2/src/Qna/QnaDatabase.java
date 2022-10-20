package Qna;

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

    Connection conn = null;
    String url = "jdbc:derby:PlayerDB;create=true";
    String dbusername = "pdc";  //your DB username
    String dbpassword = "pdc";   //your DB password

    public void dbSetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "Questions";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            statement.close();

        } catch (Throwable e) {
            System.out.println("error");

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

    public void quitSystem() {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("See you next time!");
        }
    }
}
