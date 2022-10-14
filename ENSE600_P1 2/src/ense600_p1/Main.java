package ense600_p1;

/**
 *
 * @author Katie Li
 */
public class Main {

    //Main method for program
    public static void main(String[] args) {
        String userFilename = "./resources/UserPassword.txt";
        UserDatabase udb = new UserDatabase(userFilename);
        udb.initializeDatabase();

        String questionFilename = "./resources/questions.txt";
        QuestionDatabase qdb = new QuestionDatabase(questionFilename);
        qdb.initializeDatabase();

        TopicDatabase tdb = new TopicDatabase(qdb);
        tdb.initializeDatabase();

        Login L = new Login(udb, userFilename);
        User currentUser = L.login();
        System.out.println(currentUser.toString());
        QAMenu m = new QAMenu(udb, qdb, tdb, userFilename, questionFilename,
                currentUser);

        if (currentUser instanceof Admin) {
            m.printAdminMenu();
        } else {
            m.printQAMenu();
        }
    }
}
