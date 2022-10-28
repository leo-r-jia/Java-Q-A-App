/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
 * @author Katie LI
 * @Student ID:18003055
 */
public class LoginView extends JFrame implements Observer  {
    // initilizing the GUI instance of variables
    private JPanel userPanel1 = new JPanel();
    private JPanel userPanel2 = new JPanel();
    private JPanel loginPanel1 = new JPanel();
    private JPanel loginPanel2 = new JPanel();
    private JPanel createAccPanel1 = new JPanel();
    private JPanel createAccPanel2 = new JPanel();
    private JPanel resetPasswordPanel = new JPanel();
    private JPanel loginAsAdminPanel1 = new JPanel();
    private JPanel loginAsAdminPanel2 = new JPanel();
    private JPanel deleteAccPanel = new JPanel();
    
    private JPanel QAMenu1 = new JPanel();
    private JPanel QAMenu2 = new JPanel();
    
    public JLabel queryMessage = new JLabel("Have you already got an account?",JLabel.CENTER);
    private JLabel yes = new JLabel("Yes, I want to log in with my account.");
    private JButton yesButton = new JButton("Log in Now");
    private JLabel no = new JLabel("No, I want to create a new account.");
    private JButton noButton = new JButton("Create New Account");
    
    private JPanel quitPanel = new JPanel();
    private JButton quitButton = new JButton("Quit");
    private JLabel goodbye =  new JLabel("Goodbye! See you next time!");
    
    private JButton backButton = new JButton("Back to Login");
    
    private JLabel uID = new JLabel("User ID: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField uidInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JButton loginButton = new JButton("Log in");
    
    private JLabel inputId = new JLabel("Please input a user ID: ");
    private JLabel inputName = new JLabel("Please input your name: ");
    private JLabel inputPassword = new JLabel("Please input your password: ");
    public JTextField newUserId = new JTextField(11);
    public JTextField newUserName = new JTextField(11);
    public JTextField newUserPassword = new JTextField(11);
    private JButton createNewAccButton = new JButton("Create New Account");
    private JButton registerButton = new JButton("Register");
    private JLabel remindMsgForNewAcc = new JLabel("As the user ID,user name and password are sensitive, please do not include special characters(for example: ',_.~!) when you create new account.");
    
    private JLabel IDquery = new JLabel("Please input your user ID:");
    public JTextField inputUserID = new JTextField(10);
    private JLabel resetPassword = new JLabel("Please input your new password:");
    public JTextField newInputPassword = new JTextField(10);
    private JButton resetPasswordButton = new JButton("Reset Password");
    private JButton submitButton = new JButton("Submit");
    
    
    private JButton deleteAccButton = new JButton("Delete an account");
    private JButton deleteButton = new JButton("Delete");
    
    
    private JLabel welcomMessage = null;
    private JLabel questionMenu = new JLabel("Would you like to... ");
    private JButton askQuestion = new JButton("Ask a new question");
    private JButton browseQuestions = new JButton("Browse all questions");
    private JButton browseQuesByTopic = new JButton("Browse questions by topic");
    private JButton answerQuestions = new JButton("Answer unanswered questions");
    
   //The constructor initializes the frame window as well as the login interface.
    public LoginView(){
        super("-------------Welcome to ENSE600/COMP603 Q & A App-------------");
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,200);
        
        this.add(this.queryMessage,BorderLayout.NORTH);
        this.queryMessage.setFont(new Font("Serif",Font.ITALIC,18));
        
        this.userPanel1.add(yes);
        this.userPanel1.add(yesButton);
        this.userPanel2.add(no);
        this.userPanel2.add(noButton);
        this.userPanel2.add(quitButton);
        this.quitButton.setForeground(Color.red);
        
        this.add(userPanel1,BorderLayout.CENTER);
        this.add(userPanel2,BorderLayout.SOUTH);
        this.setVisible(true);
    
    }
    
    public void loginAccount(){
        loginPanel1.add(uID);
        loginPanel1.add(uidInput);
        loginPanel1.add(pWord);
        loginPanel1.add(pwInput);
        loginPanel2.add(loginButton);
        loginPanel2.add(quitButton);
        this.quitButton.setForeground(Color.red);
        loginPanel2.add(resetPasswordButton);
        loginPanel2.add(createNewAccButton);
        
        this.getContentPane().removeAll();
        loginPanel1.setVisible(true);
        loginPanel2.setVisible(true);
        
        this.add(loginPanel1,BorderLayout.CENTER);
        this.add(loginPanel2,BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
        
    }
    public void createAnAccount() {
        createAccPanel1.add(inputId);
        createAccPanel1.add(newUserId);
        createAccPanel1.add(inputName);
        createAccPanel1.add(newUserName);
        createAccPanel1.add(inputPassword);
        createAccPanel1.add(newUserPassword);
        createAccPanel1.add(registerButton);
        createAccPanel1.add(quitButton);
        createAccPanel1.add(backButton);
        this.quitButton.setForeground(Color.red);
        createAccPanel2.add(remindMsgForNewAcc);
        this.remindMsgForNewAcc.setFont(new Font("Serif",Font.ITALIC,18));
        this.remindMsgForNewAcc.setForeground(Color.BLUE);
        
        this.getContentPane().removeAll();
        createAccPanel1.setVisible(true);
        createAccPanel2.setVisible(true);
        this.add(createAccPanel1,BorderLayout.CENTER);
        this.add(createAccPanel2,BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
        
    }
    public void resetPassword(){
        resetPasswordPanel.add(IDquery);
        resetPasswordPanel.add(inputUserID);
        resetPasswordPanel.add(resetPassword);
        resetPasswordPanel.add(newInputPassword);
        resetPasswordPanel.add(submitButton);
        resetPasswordPanel.add(quitButton);
        resetPasswordPanel.add(backButton);
        
        this.getContentPane().removeAll();
        resetPasswordPanel.setVisible(true);
        this.add(resetPasswordPanel);
        this.revalidate();
        this.repaint();            
    }
    
    public void loginAsAdmin(){
        loginAsAdminPanel1.add(welcomMessage,BorderLayout.NORTH);
        loginAsAdminPanel1.add(questionMenu,BorderLayout.CENTER);
        loginAsAdminPanel2.add(deleteAccButton);
        //loginAsAdminPanel2.add(createNewAccButton);
        //loginAsAdminPanel2.add(resetPasswordButton);
        loginAsAdminPanel2.add(askQuestion);
        loginAsAdminPanel2.add(browseQuestions);
        loginAsAdminPanel2.add(browseQuesByTopic);
        loginAsAdminPanel2.add(answerQuestions);
        loginAsAdminPanel2.add(quitButton);
        this.quitButton.setForeground(Color.red);
        this.loginAsAdminPanel2.add(backButton);
        
        this.getContentPane().removeAll();
        loginAsAdminPanel1.setVisible(true);
        loginAsAdminPanel2.setVisible(true);
        this.add(loginAsAdminPanel1,BorderLayout.CENTER);
        this.add(loginAsAdminPanel2,BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();   
           
    }
    
    public void deleteAcc(){
        deleteAccPanel.add(IDquery);
        deleteAccPanel.add(inputUserID);
        deleteAccPanel.add(deleteButton);
        deleteAccPanel.add(quitButton);
        deleteAccPanel.add(backButton);
       
        
        this.getContentPane().removeAll();
        deleteAccPanel.setVisible(true);
        this.add(deleteAccPanel,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();  
    }
    
    public void printQuestionMenu(){
        QAMenu1.add(welcomMessage,BorderLayout.NORTH);
        QAMenu1.add(questionMenu,BorderLayout.CENTER);
        QAMenu2.add(askQuestion);
        QAMenu2.add(browseQuestions);
        QAMenu2.add(browseQuesByTopic);
        QAMenu2.add(answerQuestions);
        QAMenu2.add(quitButton);
        this.quitButton.setForeground(Color.red);
        QAMenu2.add(backButton);
        
        this.getContentPane().removeAll();
        QAMenu1.setVisible(true);
        QAMenu2.setVisible(true);
        this.add(QAMenu1,BorderLayout.CENTER);
        this.add(QAMenu2,BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();   
    }
    
    public void addActionListener(ActionListener listener) {
        this.yesButton.addActionListener(listener);
        this.noButton.addActionListener(listener);
        this.loginButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
        this.createNewAccButton.addActionListener(listener);
        this.registerButton.addActionListener(listener);
        this.resetPasswordButton.addActionListener(listener);
        this.submitButton.addActionListener(listener);
        this.deleteAccButton.addActionListener(listener);
        this.deleteButton.addActionListener(listener);
    }
    
    public void quitSystem(){
        quitPanel.add(goodbye);
        goodbye.setFont(new Font("Serif",Font.ITALIC,16));
        quitPanel.add(goodbye,BorderLayout.AFTER_LAST_LINE);
        this.getContentPane().removeAll();
        
        this.add(quitPanel);
        this.revalidate();
        this.repaint(); 
    }
    
    public void goBacktoLogin() {
        this.loginAccount();
   
    }
    
    //Define the event when model has been modified.
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        welcomMessage = new JLabel("Kia ora, "+ data.username + "! You have logged in successfully.");
       
        if(!data.hasAnAccount){//if the user has an account, to the login window
            this.loginAccount();
            if(data.loginFlag == true){//if the user ID and password matching the information in db then go to the QAMenu window
                if(data.isAdmin==false){
                    this.printQuestionMenu();
                }else{//after login, if the user is recogized as Admin, go to the Admin Menu window
                this.loginAsAdmin();
                }
            }else{//if the user ID and password did not match with the db, back to the login window
                this.loginAccount();
            }  
        }else if(data.hasAnAccount){//if the user does not have account, go to the createAnAccount window
            this.createAnAccount();
            if(!data.accountExist){//change the value of the createNewAccDone back to Data
                data.createNewAccDone = true;
            }else{
                data.createNewAccDone = false;
            }
        }else if(!data.quitFlag){//if the user press the quit button, go to the quite window
            this.quitSystem();
        }else if(data.resetPasswordDone){//go to the the reset window
           this.resetPassword();
           data.loginFlag = false;
        }else if(data.accountExist){//go to the the createAnAccount window
            this.createAnAccount();
            data.hasAnAccount = true;
        }else if(!data.accountExist){//go to the resetPassword window
            this.resetPassword();  
        }
    }      
}