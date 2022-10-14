package ense600_p1;

/**
 *
 * @author Leo Jia
 */

//Removes an answer from a question and calls updateDatabase() to write the changes to file
public class DeleteAnswer implements Delete{

    public void deleteAnswer(QuestionDatabase qdb, Question q, Answer a) {
        if (qdb.questions.get(q.getqId()).answers.remove(a)) {
            System.out.println("Answer deleted");
        } else {
            System.out.println("Answer not deleted "); //Debugging
        }
        qdb.updateDatabase();
    }
}
