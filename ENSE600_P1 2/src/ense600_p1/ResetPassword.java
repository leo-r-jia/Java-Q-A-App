package ense600_p1;

/**
 *
 * @author Leo Jia and Katie Li
 */
//Class to reset password
public class ResetPassword {

    //Method that resets a user's password, updates UserDatabase, and the text file
    public void resetPassword(UserDatabase udb, String filename, String userId, String newPassword) {
        User temp;
        if (udb.allUsers.get(userId) instanceof Student) {
            temp = new Student(userId, udb.allUsers.get(userId).getUsername(), newPassword);
        } else {
            temp = new Admin(userId, udb.allUsers.get(userId).getUsername(), newPassword, true);
        }
        DeleteUser du = new DeleteUser();
        du.deleteUser(udb, filename, userId);
        AdminAddAccount aaa = new AdminAddAccount();
        aaa.addAccount(udb,filename,temp);
    }
}
