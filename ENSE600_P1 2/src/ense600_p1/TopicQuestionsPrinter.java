package ense600_p1;

import java.util.ArrayList;

/**
 *
 * @author Leo Jia
 */

//Class responsible for printing all questions in a topic
public class TopicQuestionsPrinter implements Printer {

    static int index = 1;

    //Method that prints all the questions in a topic and an index, returning an
    //ArrayList of qIds corresponding to the questions printed
    public ArrayList<String> printQuestions(Topic t) {
        index = 1;

        QuestionPrinter qp = new QuestionPrinter();
        ArrayList<String> qIds = new ArrayList<>();

        t.questions.forEach((key, q) -> {
            System.out.print("(" + index + ") ");
            qp.printQuestion(q);
            qIds.add(key);
            index = index + 1;
        });
        return qIds;
    }
}
