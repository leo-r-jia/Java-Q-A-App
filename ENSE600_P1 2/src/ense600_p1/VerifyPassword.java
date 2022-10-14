package ense600_p1;

/**
 *
 * @author Leo Jia
 */

//Verify Password interface
public interface VerifyPassword {
    public boolean passwordIsValid(UserDatabase udb, String userId, String password);
}
