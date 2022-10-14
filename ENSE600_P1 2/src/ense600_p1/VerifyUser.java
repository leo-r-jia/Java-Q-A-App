package ense600_p1;

/**
 *
 * @author Leo Jia and Katie Li
 */

//Verify User class that implements VerifyUserId and VerifyPass
public class VerifyUser implements VerifyUserId, VerifyPassword {

    //VerifyUser method that verifies user and password
    public boolean verifyUser(UserDatabase udb, String userId, String password) {
        if (!verifyUserId(udb, userId)) {
            return false;
        } else {
            return (passwordIsValid(udb, userId, password));
        }
    }

    //Verifies userId exists
    @Override
    public boolean verifyUserId(UserDatabase udb, String userId) {
        if (udb.allUsers.get(userId) == null) {
            return false;
        } else {
            return true;
        }
    }

    //Verifies the input password matches saved password
    @Override
    public boolean passwordIsValid(UserDatabase udb, String userId, String password) {
        return udb.allUsers.get(userId).getPassword().equals(password);
    }
}
