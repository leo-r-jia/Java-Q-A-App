/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.Observable;

/**
 *
 * @author yueli
 */
public class Model extends Observable{
    
    public LoginDatabase db;
    public Data data = new Data();
    public String userID;
    
    public Model(){
        this.db = new LoginDatabase();
        this.db.dbsetup();
        
    }

    public void checkName(String userID, String password) {
        this.userID = userID;
        this.data = this.db.checkName(userID, password);
        
        this.setChanged();
        this.notifyObservers(this.data);
      
    }
    
    public void createNewAcc(String userID, String userName, String password){
        this.userID = userID;
        this.db.createNewAccount(userID, password, userName);
        this.setChanged();
        this.notifyObservers(this.data);  
    }

    public void quitSystem() {
        this.db.quitSystem();
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);  
    }
      
}
