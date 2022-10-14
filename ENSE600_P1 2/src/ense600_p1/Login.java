package ense600_p1;

import java.util.Scanner;

/**
 *
 * @author Katie Li
 */
public class Login {

    UserDatabase udb;
    String filename;

    public Login(UserDatabase udb, String filename) {
        this.udb = udb;
        this.filename = filename;
    }

    // a method to let the user(Student/Admin) enter the QA System
    public User login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------Welcome to ENSE600/COMP603 Q & A App-------------");
        System.out.println("Have you already got an account? "
                + "Press 'Y' to login, 'N' to create a new account");
        String choice = null;
        while (true) {
            choice = sc.nextLine();
            if (choice.trim().equalsIgnoreCase("y") || choice.trim().equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("---Invalid input, please enter again.---");
            }
        }
        User currentUser = null;
        //if the user already had an account, ask the user to input the ID and password and verify them
        if (choice.trim().equalsIgnoreCase("y")) {
            while (true) {
                System.out.println("---To login, please enter your user ID:---"
                        + "\n(ID is case and space sensitive, input 'x' to exit)");
                String userId = sc.nextLine();
                if (userId.equalsIgnoreCase("x")) {
                    System.exit(0);
                }
                System.out.println("---Please enter your password:---"
                        + "\n(Password is case and space sensitive, input 'x' to exit)");
                String password = sc.nextLine();
                if (password.equalsIgnoreCase("x")) {
                    System.exit(0);
                }
                VerifyUser vu = new VerifyUser();
                boolean successLogin = vu.verifyUser(udb, userId, password);
                if (successLogin) {
                    System.out.println("\n--------Login successful!--------");
                    currentUser = udb.allUsers.get(userId);
                    break;
                } else {
                    System.out.println(
                            "Invalid username or password. Please input again\n");
                }
            }
        } else if (choice.trim().equalsIgnoreCase("n")) {
            //allow the user to register a new account to log in the QA System
            System.out.println("----Please enter a new user ID (in XXX, ie. 123)----"
                    + "\n(ID is case and space sensitive, input 'x' to exit)");
            String newUID;
            while (true) {
                //check if the input new ID already existing
                newUID = sc.nextLine();
                if (newUID.equalsIgnoreCase("x")) {
                    System.exit(0);
                }
                if (newUID.length() != 3) {
                    System.out.println("Please input an ID in format XXX, ie. 123");
                } else if (udb.allUsers.get(newUID) != null) {
                    System.out.println("--The user ID " + newUID + " already exists, please enter a valid ID--");
                } else {
                    break;
                }
            }
            String newUName;
            System.out.println("----Please enter your username:----"
                    + "\n(Input 'x' to exit)");
            while (true) {
                newUName = sc.nextLine();
                if (newUName.equalsIgnoreCase("x")) {
                    System.exit(0);
                }
                if (newUName.length() <= 2) {
                    System.out.println("The name is too short (min: 3)");
                } else {
                    break;
                }
            }
            System.out.println("----Please enter your password:----"
                    + "\n(Password is case and space sensitive, input 'x' to exit)");
            String newUPw = sc.nextLine();
            if (newUPw.equalsIgnoreCase("x")) {
                System.exit(0);
            }
            Student s = new Student(newUID, newUName, newUPw);
            UserCreateAccount uca = new UserCreateAccount();
            uca.addAccount(udb, filename, s);
            currentUser = udb.allUsers.get(newUID);
        } else {
            System.out.println("Invalid input, please input again.");
        }
        return currentUser;
    }
}
