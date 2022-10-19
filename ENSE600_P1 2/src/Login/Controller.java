/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author yueli
 */
public class Controller implements ActionListener {
    public LoginView view;
    public Model model;
    
    public Controller(LoginView view, Model model){
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "Log in Now":
                this.view.loginAccount();
                break;
            
            case "Create New Account":
                this.view.createAnAccount();
//                String newUserID = this.view.newUserId.getText().trim();
//                String newUserName = this.view.newUserName.getText().trim();
//                String newUserPassword = this.view.newUserPassword.getText().trim();
//                this.model.createNewAcc(newUserID, newUserName, newUserPassword);
                break;
                
            case "Log in":
                String userID = this.view.uidInput.getText();
                String password = this.view.pwInput.getText();
                this.model.checkName(userID, password);
                break;
                
            case "Quit":
                this.view.quitSystem();
                break;
                
            case "Register":
                this.view.loginAccount();
                break;
                
            case "Back":
                this.view.goBackToQAMenu();
                break;
            default:
                break;
                
        }
    }  
}
