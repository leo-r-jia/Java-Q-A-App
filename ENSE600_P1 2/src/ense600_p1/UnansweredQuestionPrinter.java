package ense600_p1;

import java.util.ArrayList;

/**
 *
 * @author Leo Jia
 */

//Class responsible for printing all unanswered questions
public class UnansweredQuestionPrinter implements Printer {

    static int index = 1;

    //Method that prints all the unanswered questions and an index, returning an
    //ArrayList of qIds corresponding to the questions printed
    public ArrayList<String> printUnansweredQuestions(QuestionDatabase qdb) {
        index = 1;

        QuestionPrinter qp = new QuestionPrinter();
        ArrayList<String> qIds = new ArrayList<>();

        qdb.questions.forEach((key, q) -> {
            if (q.answers.isEmpty()) {
                System.out.print("(" + index + ") ");
                qp.printQuestion(q);
                qIds.add(key);
                index = index + 1;
            }
        });
        return qIds;
    }
}
