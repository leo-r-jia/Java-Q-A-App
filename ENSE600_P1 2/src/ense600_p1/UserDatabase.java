package ense600_p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katie Li
 */

// this class is to handle user information
public class UserDatabase implements Database {

    protected HashMap<String, User> allUsers;
    private String filename;

    public UserDatabase(String filename) {
        allUsers = new HashMap<String, User>();
        this.filename = filename;
    }

    //Initialize userdata, reading data from a file and write it back to the file
    @Override
    public void initializeDatabase() {
        FileInputStream fin;
        try {
            fin = new FileInputStream(filename);
            Scanner fileScanner = new Scanner(fin);
            String line = null;
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                String str[] = line.split(",");
                String userId = str[0];
                String userName = str[1];
                String password = str[2];
                boolean isAdmin = (Integer.parseInt(str[3]) == 1);
                if (isAdmin) {
                    allUsers.put(str[0], new Admin(userId, userName, password, isAdmin));
                } else {

                    allUsers.put(str[0], new Student(userId, userName, password));
                }
            }
            fin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
