package ense600_p1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Leo Jia and Katie Li
 */

//AddAccount method for admins, to add both student and admin accounts
public class AdminAddAccount implements AddAccount {

    @Override
    //addAccount method that adds both student and admin to UserDatabase accounts and writes to file
    public void addAccount(UserDatabase udb, String filename, User newUser) {
        try {
            FileOutputStream fo = new FileOutputStream(filename, true);
            PrintWriter pw = new PrintWriter(fo);
            if (newUser instanceof Admin) {
                pw.println(newUser.getUserId() + "," + newUser.getUsername() + "," + newUser.getPassword() + ",1,");
            } else {
                pw.println(newUser.getUserId() + "," + newUser.getUsername() + "," + newUser.getPassword() + ",0,");
            }
            pw.close();
            fo.close();
            udb.allUsers.put(newUser.getUserId(), newUser);
        } catch (IOException except) {
            except.printStackTrace();
        }
    }

}
