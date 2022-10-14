package ense600_p1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Leo Jia and Katie Li
 */

//UserCreateAccount class for users to create accounts
public class UserCreateAccount implements AddAccount {

    //addAccount method that allows users to create student accounts
    //adds to UserDatabase and also writes to file
    @Override
    public void addAccount(UserDatabase udb, String filename, User newUser) {
        try {
            FileOutputStream fo = new FileOutputStream(filename, true);
            PrintWriter pw = new PrintWriter(fo);
            pw.println(newUser.getUserId() + "," + newUser.getUsername() + "," + newUser.getPassword() + ",0,");
            pw.close();
            fo.close();
            System.out.println("Your new account has been created successfully");
            udb.allUsers.put(newUser.getUserId(), newUser);

        } catch (IOException except) {
            except.printStackTrace();
        }
    }
}
