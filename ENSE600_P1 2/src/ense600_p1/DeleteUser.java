package ense600_p1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Katie Li
 */

//DeleteUser class that deletes user from UserDatabase and writes the changes to file
public class DeleteUser implements Delete {

    public void deleteUser(UserDatabase udb, String filename, String userId) {
        udb.allUsers.remove(userId);
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            PrintWriter pw = new PrintWriter(fo);
            for (User u : udb.allUsers.values()) {
                if (u instanceof Student) {
                    pw.println(u.getUserId() + "," + u.getUsername() + "," + u.getPassword() + ",0");
                } else {
                    pw.println(u.getUserId() + "," + u.getUsername() + "," + u.getPassword() + ",1");
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); //Debugging
        }
    }
}
