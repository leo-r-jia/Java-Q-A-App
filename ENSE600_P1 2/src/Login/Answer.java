package Login;

/**
 *
 * @author Leo Jia
 */
//Answer class
public class Answer extends Text {

    private String questionid;

    public Answer(String questionid, String text, String author) {
        super(text, author);
        this.questionid = questionid;
    }

    public String getQuestionid() {
        return questionid;
    }
}
