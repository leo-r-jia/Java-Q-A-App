package ense600_p1;

/**
 *
 * @author Katie Li
 */
//Admin class is the subclass of the User class
public class Admin extends User {

    private boolean isAdmin;

    //default constructor
    public Admin(String userId,String username, String password, boolean isAdmin){
        
        super(userId, username, password);
        this.isAdmin = true;
    }
    
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
    
    

    
  
