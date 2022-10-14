package ense600_p1;
/**
 *
 * @author Katie Li
 */
// an abstract User class (Student and Admin class are the subclasses of User class)
public abstract class User {

    private String userId;
    private String username = "";
    private String password = "";
    //default constructor
    public User(String userId, String username, String password){
        this.userId = userId;
        this.username = username;
        this.password = password; 
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    
    }
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    
    }
    public String getUserId(){
        return this.userId;
    }
    
    public void setUserId(String UserId){
        this.userId = userId;
    }

    // toString method to print the user information when login successfully
    @Override
    public String toString() {
        String msg = "User ID: " + userId + ", Username: " + username+ ", Password: "+ password +"\n";
        return msg;
    }  
}
