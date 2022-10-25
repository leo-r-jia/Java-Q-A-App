package ense600_p1;

/**
 *
 * @author Leo Jia
 */
//Delete question from QuestionDatabase and calls updateDatabase() to write to file
public class DeleteQuestion implements Delete {

    public void deleteQuestion(QuestionDatabase qdb, Question q) {
        if (qdb.questions.remove(q.getqId(), q)) {
            qdb.questions.remove(q);
            System.out.println("Question deleted");
        } else {
            System.out.println("Question not deleted"); //Debugging
        }
        qdb.updateDatabase();
    }
}
