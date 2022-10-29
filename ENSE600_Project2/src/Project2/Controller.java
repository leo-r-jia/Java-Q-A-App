package Project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Katie LI
 * @Student ID:18003055
 */
public class Controller implements ActionListener {

    public LoginView view;
    public Model model;

    //Assign view and model to attributes in the constructor, and add ActionListener(this) to the instance of View.
    public Controller(LoginView view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }

    //Define ActionEvents based on the text displayed on the each button.
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Log in Now":
                this.view.loginAccount();
                break;

            case "Create New Account":
                this.view.createAnAccount();
                break;

            case "Log in":
                String userID = this.view.uidInput.getText();
                String password = this.view.pwInput.getText();
                System.out.println(this.model.loginData.isAdmin);
                this.model.loginAcc(userID, password);
                break;

            case "Quit":
                this.view.quitSystem();
                break;

            case "Register":
                String newUserID = this.view.newUserId.getText().trim();
                String newUserName = this.view.newUserName.getText().trim();
                String newUserPassword = this.view.newUserPassword.getText().trim();
                //to make sure the user input information is not empty
                if (newUserID.isEmpty() || newUserName.isEmpty() || newUserPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    //to make sure the user input ID, name and password in the limit of the length
                } else if (newUserID.length() > 30) {
                    JOptionPane.showMessageDialog(null, "You input information exceeds maximum allowed characters (30)");
                } else if (newUserName.length() > 30) {
                    JOptionPane.showMessageDialog(null, "You input information exceeds maximum allowed characters (30)");
                } else if (newUserPassword.length() > 30) {
                    JOptionPane.showMessageDialog(null, "You input information exceeds maximum allowed characters (30)");
                } else {
                    this.model.createNewAcc(newUserID, newUserName, newUserPassword);
                }
                break;

            case "Reset Password":
                this.view.resetPassword();
                break;

            case "Submit":
                String inputID = this.view.inputUserID.getText().trim();
                String newPassword = this.view.newInputPassword.getText().trim();
                this.model.resetPassword(inputID, newPassword);
                break;

            case "Back":
                this.view.goBacktoMenu();

            default:
                break;

        }
    }
}
