package ense600_p1;

/**
 *
 * @author Leo Jia
 */

//AnswerQuestion class that adds an answer to a question
public class AnswerQuestion {

    public void answerQuestion(QuestionDatabase qdb, Answer answer, String qId) {
        if (qdb.questions.get(qId) != null) {
            qdb.questions.get(qId).answers.add(answer);
            System.out.println(qdb.questions.get(qId)); //Debugging
        } else {
            System.out.println("Question not found in answerQuestion"); //Debugging
        }
    }
}
