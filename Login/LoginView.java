/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author yueli
 */
public class LoginView extends JFrame implements Observer  {
    
    private JPanel userPanel = new JPanel();
    private JPanel loginPanel = new JPanel();
    private JPanel createAccPanel = new JPanel();
    
    public JLabel welcomeMessage = new JLabel ("-------------Welcome to ENSE600/COMP603 Q & A App-------------", JLabel.CENTER);
    public JLabel queryMessage = new JLabel("-------------Have you already got an account?-------------",JLabel.CENTER);
    private JLabel yes = new JLabel("Yes, I want to log in with my account.");
    private JButton yesButton = new JButton("Log in Now");
    private JLabel no = new JLabel("No, I want to create a new account.");
    private JButton noButton = new JButton("Create New Account");
    private JButton quitButton = new JButton("Quit");
    
    private JLabel uID = new JLabel("User ID: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField uidInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    //private JLabel wrongName = new JLabel("Wrong username or passwork!");
    private JButton loginButton = new JButton("Log in");
    
    private JLabel inputId = new JLabel("Please input a user ID: ");
    private JLabel inputName = new JLabel("Please input your name: ");
    private JLabel inputPassword = new JLabel("Please input your password: ");
    public JTextField newUserId = new JTextField(40);
    public JTextField newUserName = new JTextField(40);
    public JTextField newUserPassword = new JTextField(40);
    private JButton createNewAcc = new JButton("Create New Account");
    
   
    public LoginView(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,200);
        
        this.add(this.welcomeMessage,BorderLayout.SOUTH);
        this.add(this.queryMessage,BorderLayout.NORTH);
        
        this.userPanel.add(yes);
        this.userPanel.add(yesButton);
        this.userPanel.add(no);
        this.userPanel.add(noButton);
        this.userPanel.add(quitButton);
        
        this.add(userPanel);
        this.setVisible(true);
    
    }
    
    public void loginAccount(){
        loginPanel.add(uID);
        loginPanel.add(uidInput);
        loginPanel.add(pWord);
        loginPanel.add(pwInput);
        loginPanel.add(loginButton);
        loginPanel.add(quitButton);
        
        
        this.getContentPane().removeAll();
        loginPanel.setVisible(true);
        
        this.add(loginPanel);
        this.add(this.welcomeMessage,BorderLayout.PAGE_START);
        this.revalidate();
        this.repaint();
        
    }
    public void createAnAccount() {
        createAccPanel.add(inputId);
        createAccPanel.add(newUserId);
        createAccPanel.add(inputName);
        createAccPanel.add(newUserName);
        createAccPanel.add(inputPassword);
        createAccPanel.add(newUserPassword);
        createAccPanel.add(createNewAcc);
        createAccPanel.add(quitButton);
        
        this.getContentPane().removeAll();
        createAccPanel.setVisible(true);
        this.add(createAccPanel);
        this.add(this.welcomeMessage,BorderLayout.PAGE_START);
        this.revalidate();
        this.repaint();
        
    }
    
    public void addActionListener(ActionListener listener) {
        this.yesButton.addActionListener(listener);
        this.noButton.addActionListener(listener);
        this.loginButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if(!data.hasAnAccount){
            this.loginAccount();
            
        }else if(data.hasAnAccount){
            this.createAnAccount();
            
        }else if(!data.loginFlag){
            this.uidInput.setText("");
            this.pwInput.setText("");
            this.welcomeMessage.setText("Invalid username or password.");
        }
    }

    

    
     
}
