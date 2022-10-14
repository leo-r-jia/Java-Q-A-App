package ense600_p1;

import java.util.ArrayList;

/**
 *
 * @author Leo Jia
 */

//Class to print all the questions in a QuestionDatabase
public class QuestionDatabasePrinter implements Printer {

    static int index = 1;

    //Method that prints all questions in a database with an index, and returning
    //an ArrayList of qIds corresponding to the question in index
    public ArrayList<String> printQuestions(QuestionDatabase qdb) {
        index = 1;
        
        QuestionPrinter qp = new QuestionPrinter();
        ArrayList<String> qIds = new ArrayList<>();

        qdb.questions.forEach((key, q) -> {
            System.out.print("(" + index + ") ");
            qp.printQuestion(q);
            qIds.add(key);
            index = index + 1;
        });
        return qIds;
    }
}
