package ense600_p1;

/**
 *
 * @author Katie Li and Leo Jia
 */
import java.util.ArrayList;
import java.util.Scanner;

//Q&A Menu
public class QAMenu {

    protected UserDatabase udb;
    protected QuestionDatabase qdb;
    protected TopicDatabase tdb;
    protected String userFilename;
    protected String questionFilename;
    protected User currentUser;

    //Default constructor
    public QAMenu(UserDatabase udb, QuestionDatabase qdb, TopicDatabase tdb,
            String userFilename, String questionFilename, User currentUser) {
        this.udb = udb;
        this.qdb = qdb;
        this.tdb = tdb;
        this.userFilename = userFilename;
        this.questionFilename = questionFilename;
        this.currentUser = currentUser;
    }

    //Prints standard Q&A menu and handles user input
    public void printQAMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n----------Kia ora " + currentUser.getUsername() + " ----------");

        System.out.println("\n"
                + "Would you like to:"
                + "\n(1) Ask a new question"
                + "\n(2) Browse all questions"
                + "\n(3) Browse questions by topic"
                + "\n(4) Answer unanswered questions"
                + "\n(5) Change password"
                + "\n(6) Exit\n");

        String choice = sc.next().trim();
        switch (choice.trim()) {
            case "1":
                askNewQuestion();
                break;

            case "2":
                browseAllQuestions();
                break;

            case "3":
                browseByTopic();
                break;

            case "4":
                browseUnansweredQuestions();
                break;
            case "5":
                resetPassword(currentUser.getUserId());
                break;
            case "6":
                exitSystem();
            default:
                System.out.println("This option does not exist. Input a number between 1 and 6");
                break;
        }
        printQAMenu();
    }

    //Prints admin menu for Q&A system with additional administrative functions 
    //and handles user input
    public void printAdminMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "\n----------Kia ora " + currentUser.getUsername() + " ----------"
                + "\n------You are logged in as an admin------"
                + "\n\nWould you like to:"
                + "\n(1) Ask a new question"
                + "\n(2) Browse all questions"
                + "\n(3) Browse questions by topic"
                + "\n(4) Answer unanswered questions"
                + "\n\n(5) Add a new user"
                + "\n(6) Reset user password"
                + "\n(7) Delete a user"
                + "\n(8) Exit"
        );

        String choice = sc.nextLine().trim();
        switch (choice.trim()) {
            case "1":
                askNewQuestion();
                break;

            case "2":
                browseAllQuestions();
                break;

            case "3":
                browseByTopic();
                break;

            case "4":
                browseUnansweredQuestions();
                break;
            case "5":
                while (true) {
                    VerifyUser vu = new VerifyUser();
                    System.out.println("---Please enter the new user's ID (in format XXX, ie 123)---"
                            + "\n(Press 'x' to exit, 'B' to go back)");
                    String newId;
                    while (true) {
                        newId = sc.nextLine();
                        if (newId.equalsIgnoreCase("x")) {
                            exitSystem();
                        }
                        if (newId.equalsIgnoreCase("b")) {
                            printAdminMenu();
                        }
                        if (newId.length() != 3) {
                            System.out.println("Please input an ID in format XXX, ie. 123");
                        } else {
                            break;
                        }
                    }
                    if (!vu.verifyUserId(udb, newId)) {
                        System.out.println("---Please enter the new user's name:---"
                                + "\n(Press 'X' to exit, 'B' to go back)");
                        String newName = sc.nextLine();
                        if (newName.equalsIgnoreCase("x")) {
                            exitSystem();
                        }
                        if (newName.equalsIgnoreCase("b")) {
                            printAdminMenu();
                        }
                        System.out.println("---Please enter the new user's password:---");
                        String newPassword = sc.nextLine();
                        System.out.println("---Is this new user an admin? 'Y' or 'N'---");
                        boolean isAdmin = false;
                        while (true) {
                            String checkAdmin = sc.nextLine();
                            if (checkAdmin.trim().equalsIgnoreCase("Y")) {
                                isAdmin = true;
                                break;
                            } else if (checkAdmin.trim().equalsIgnoreCase("N")) {
                                isAdmin = false;
                                break;
                            } else {
                                System.out.println("Invalid input. Input 'Y' or 'N'");
                            }
                        }
                        AdminAddAccount aaa = new AdminAddAccount();
                        if (isAdmin) {
                            Admin a = new Admin(newId, newName, newPassword, isAdmin);
                            aaa.addAccount(udb, userFilename, a);
                        } else {
                            Student s = new Student(newId, newName, newPassword);
                            aaa.addAccount(udb, userFilename, s);
                        }
                        System.out.println("---New user information added successfully.---");
                        printAdminMenu();
                    } else {
                        System.out.println("ID already in use. Input another ID.");
                    }
                }
            case "6":
                String inputId;
                VerifyUser vu = new VerifyUser();
                while (true) {
                    System.out.println("---Please enter the user ID to reset the password---");
                    System.out.println("(Press 'X' to exit, 'B' to go back)");
                    inputId = sc.nextLine();
                    if (inputId.trim().equalsIgnoreCase("b")) {
                        printAdminMenu();
                    }
                    if (inputId.trim().equalsIgnoreCase("x")) {
                        System.exit(0);
                    }
                    if (vu.verifyUserId(udb, inputId)) {
                        resetPassword(inputId);
                        break;
                    } else {
                        System.out.println("There is no user with that ID. Input again or press 'X' to exit, 'B' to go back");
                    }
                }
                break;
            case "7":
                VerifyUser vu1 = new VerifyUser();
                while (true) {
                    System.out.println("---Which user do you want to delete? Please enter the user ID---");
                    System.out.println("Press 'X' to exit, 'B' to go back");
                    String deleteUserId = sc.next();
                    if (deleteUserId.trim().equalsIgnoreCase("b")) {
                        printAdminMenu();
                    }
                    if (deleteUserId.trim().equalsIgnoreCase("x")) {
                        System.exit(0);
                    }
                    if (vu1.verifyUserId(udb, deleteUserId)) {
                        DeleteUser du = new DeleteUser();
                        du.deleteUser(udb, userFilename, deleteUserId);
                        System.out.println("---Deleted successfully!---");
                        printAdminMenu();
                    } else {
                        System.out.println("You input ID does not exist!");
                    }
                }
            case "8":
                exitSystem();
            default:
                System.out.println("This option does not exist. Input a number between 1 and 8");
                break;
        }
        printAdminMenu();
    }

    //Prompts user to ask a new question and handles user input
    public void askNewQuestion() {
        Scanner sc = new Scanner(System.in);
        AskQuestion aq = new AskQuestion();
        Question newQ;

        System.out.println("-------------Ask a new question:-------------"
                + "\n(press 'B' to cancel and go back, press 'X' to exit)");
        String questionText = sc.nextLine();
        if (questionText.trim().equalsIgnoreCase("b")) {
            if (currentUser instanceof Student) {
                printQAMenu();
            } else {
                printAdminMenu();
            }
        }
        if (questionText.trim().equalsIgnoreCase("x")) {
            System.exit(0);
        } else {
            String confirm;
            if (questionText.length() < 10) {
                System.out.println("Are you sure you want to ask '" + questionText + "'"
                        + "(Y/N)");
                confirm = sc.nextLine();
                if (confirm.trim().equalsIgnoreCase("y")) {
                    System.out.println("---What is the topic of your question:---");
                    System.out.println("(Ie. Assignment 1, General, or create a new topic)");
                    String questionTopic = sc.nextLine();
                    newQ = new Question(questionText, currentUser.getUsername(), questionTopic);
                    aq.askQuestion(qdb, newQ, questionFilename);
                    tdb.initializeDatabase();
                }
                if (confirm.trim().equalsIgnoreCase("n")) {
                }
            } else {
                System.out.println("---What is the topic of your question:---");
                System.out.println("(Ie. Assignment 1, General, or create a new topic)");
                String questionTopic = sc.nextLine();
                newQ = new Question(questionText, currentUser.getUsername(), questionTopic);

                aq.askQuestion(qdb, newQ, questionFilename);
                tdb.initializeDatabase();
            }
            if (currentUser instanceof Student) {
                printQAMenu();
            } else {
                printAdminMenu();
            }
        }

    }

    //Prints all questions (and answers) out to the console and returns an ArrayList
    //of qIds for succeeding methods (selectQuestion, deleteQuestion)
    public void browseAllQuestions() {
        Scanner sc = new Scanner(System.in);
        QuestionDatabasePrinter qdp = new QuestionDatabasePrinter();
        ArrayList<String> qIds;
        QuestionPrinter qp = new QuestionPrinter();

        System.out.println("-----------All Questions----------\n");

        selectQuestion(qdp.printQuestions(qdb));
    }

    //Prints all currently unanswered questions and handles user input
    public void browseUnansweredQuestions() {
        Scanner sc = new Scanner(System.in);
        UnansweredQuestionPrinter uqp = new UnansweredQuestionPrinter();
        ArrayList<String> qIds;
        QuestionPrinter qp = new QuestionPrinter();

        System.out.println("--------Unanswered Questions--------\n");

        qIds = uqp.printUnansweredQuestions(qdb);

        if (qIds.isEmpty()) {
            String choice;
            System.out.println("There are currently no unanswered questions"
                    + "\n(1) Ask new question"
                    + "\n(2) Go back");
            choice = sc.next().trim();
            switch (choice.trim()) {
                case "1":
                    askNewQuestion();
                    break;
                case "2":
                    if (currentUser instanceof Student) {
                        printQAMenu();
                    } else {
                        printAdminMenu();
                    }
                    break;
                default:
                    System.out.println("This option does not exist. Input '1', or '2'");
                    break;
            }
        }

        System.out.println("Enter a number to select a question"
                + "(press 'B' to go back, press 'X' to exit)");

        String choice;
        int index = -1;
        Question selected = null;

        while (true) {
            choice = sc.nextLine();
            if (choice.trim().equalsIgnoreCase("x") || choice.trim().equalsIgnoreCase("b")) {
                break;
            } else {
                try {
                    index = Integer.parseInt(choice);
                    if (index < 1 || index > qIds.size()) {
                        index = Integer.parseInt("x");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and " + qIds.size());

                }
            }
        }
        if (choice.trim().equalsIgnoreCase("x")) {
            exitSystem();
        }
        if (choice.trim().equalsIgnoreCase("b")) {
            if (currentUser instanceof Student) {
                printQAMenu();
            } else {
                printAdminMenu();
            }
        } else {
            selected = qdb.questions.get(qIds.get(index - 1));
            qp.printQuestion(selected);
        }
        if (currentUser instanceof Student) {
            System.out.println("(1) Add answer "
                    + "\n(2) Go back");
            choice = sc.next().trim();
            switch (choice.trim()) {
                case "1":
                    answerQuestion(qIds.get(index - 1));
                    break;
                case "2":
                    printQAMenu();
                    break;
                default:
                    System.out.println("This option does not exist. Input '1', or '2'.");
                    break;
            }
        } else {
            System.out.println("(1) Add answer "
                    + "\n(2) Go back"
                    + "\n(3) Delete question");
            choice = sc.nextLine().trim();
            switch (choice.trim()) {
                case "1":
                    answerQuestion(qIds.get(index - 1));
                    break;
                case "2":
                    printAdminMenu();
                    break;
                case "3":
                    DeleteQuestion dq = new DeleteQuestion();
                    dq.deleteQuestion(qdb, selected);
                    this.tdb.initializeDatabase();
                    break;
                default:
                    System.out.println("This option does not exist. Input '1', '2', or '3'.");
                    break;
            }

        }
    }

    //Prints a goodbye message and exits system
    public void exitSystem() {
        System.out.println("You are exiting the system. See you next time!");
        qdb.updateDatabase();
        System.exit(0);
    }

    //Adds an answer to a selected question, handles user input
    public void answerQuestion(String qId) {
        Scanner sc = new Scanner(System.in);
        AnswerQuestion aq = new AnswerQuestion();
        String text;

        System.out.println("------------Add answer:-----------"
                + "\n(Press 'X' to exit, 'B' to go back)");

        while (true) {
            text = sc.nextLine();
            if (text.trim().equalsIgnoreCase("b")) {
                if (currentUser instanceof Student) {
                    printQAMenu();
                } else {
                    printAdminMenu();
                }
            }
            if (text.trim().equalsIgnoreCase("x")) {
                System.exit(0);
            } else {
                Answer newAnswer = new Answer(text, currentUser.getUsername());
                aq.answerQuestion(qdb, newAnswer, qId);
                break;
            }
        }
        if (currentUser instanceof Admin) {
            printAdminMenu();
        } else {
            printQAMenu();
        }
    }

    //Displays topics for users to browse, handles user input
    public void browseByTopic() {
        TopicNamePrinter tnp = new TopicNamePrinter();
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------Topics:---------------\n");
        tnp.printTopicNames(tdb);

        System.out.println("\nEnter a number to select topic "
                + "\n(press 'X' to go exit, press 'B' to go back)");

        String choice;
        int index = -1;
        Topic selected = null;

        while (true) {
            choice = sc.nextLine();
            if (choice.trim().equalsIgnoreCase("x") || choice.trim().equalsIgnoreCase("b")) {
                break;
            } else {
                try {
                    index = Integer.parseInt(choice);
                    if (index < 1 || index > tdb.topics.size()) {
                        index = Integer.parseInt("x");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Input a number between 1 and " + tdb.topics.size());
                }
            }
        }
        if (choice.trim().equalsIgnoreCase("x")) {
            exitSystem();
        }
        if (choice.trim().equalsIgnoreCase("b")) {
            if (currentUser instanceof Student) {
                printQAMenu();
            } else {
                printAdminMenu();
            }
        } else {
            selected = tdb.topics.get(index - 1);
        }

        System.out.println("--------" + selected.getTopicName() + " Questions --------\n");

        TopicQuestionsPrinter tqp = new TopicQuestionsPrinter();
        ArrayList<String> qIds;
        qIds = tqp.printQuestions(selected);

        selectQuestion(qIds);
    }

    //Prompts user to select a question, and prompts user to answer question
    //or go back. Promts admin to answer question, delete question, or go back
    public void selectQuestion(ArrayList<String> qIds) {
        Scanner sc = new Scanner(System.in);
        QuestionPrinter qp = new QuestionPrinter();

        System.out.println("-----Enter a number to select a question-----"
                + "\n(press 'X' to exit, press 'B' to go back)");

        String choice;
        int index = -1;
        Question selected = null;

        while (true) {
            choice = sc.nextLine();
            if (choice.trim().equalsIgnoreCase("x") || choice.trim().equalsIgnoreCase("b")) {
                break;
            } else {
                try {
                    index = Integer.parseInt(choice);
                    if (index < 1 || index > qIds.size()) {
                        index = Integer.parseInt("x");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Input a number between 1 and " + qIds.size());

                }
            }
        }
        if (choice.trim().equalsIgnoreCase("x")) {
            exitSystem();
        }
        if (choice.trim().equalsIgnoreCase("b")) {
            if (currentUser instanceof Student) {
                printQAMenu();
            } else {
                printAdminMenu();
            }
        } else {
            selected = qdb.questions.get(qIds.get(index - 1));
            System.out.println();
            qp.printQuestion(selected);
        }
        if (currentUser instanceof Student) {
            System.out.println("(1) Add answer "
                    + "\n(2) Go back");
            choice = sc.next().trim();
            switch (choice.trim()) {
                case "1":
                    answerQuestion(qIds.get(index - 1));
                    break;
                case "2":
                    printQAMenu();
                    break;
                default:
                    System.out.println("This option does not exist. Input '1', or '2'.");
                    break;
            }
        } else {
            System.out.println("(1) Add answer "
                    + "\n(2) Go back"
                    + "\n(3) Delete question");
            choice = sc.nextLine().trim();
            switch (choice.trim()) {
                case "1":
                    answerQuestion(qIds.get(index - 1));
                    break;
                case "2":
                    printAdminMenu();
                    break;
                case "3":
                    DeleteQuestion dq = new DeleteQuestion();
                    dq.deleteQuestion(qdb, selected);
                    this.tdb.initializeDatabase();
                    break;
                default:
                    System.out.println("This option does not exist. Input '1', '2', or '3'.");
                    break;
            }

        }

    }

    //Prompts user to input new password for password reset
    public void resetPassword(String inputId) {
        Scanner sc = new Scanner(System.in);
        ResetPassword rp = new ResetPassword();

        System.out.println("----Please enter the new password:----");
        String newPw = sc.next();
        rp.resetPassword(udb, userFilename, inputId, newPw);
        System.out.println("Password has been changed successfully!");
    }
}
