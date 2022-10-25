package ense600_p1;

/**
 *
 * @author Leo Jia
 */

//Ask question class that adds a new question to the questions database
public class AskQuestion {

    public void askQuestion(QuestionDatabase qdb, Question q, String filename) {
        qdb.questions.put(q.getqId(), q);
        System.out.println("Question asked! (" + qdb.questions.get(q.getqId()) + ")");
        qdb.updateDatabase();
    }
}
