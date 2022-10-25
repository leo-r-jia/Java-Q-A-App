package Project2;

import java.util.UUID;

/**
 *
 * @author Leo Jia
 */
//Answer class
public class Answer extends Text {

    private String questionid;
    private String answerid;

    public Answer(String questionid, String text, String author) {
        super(text, author);
        this.answerid = UUID.randomUUID().toString();
        this.questionid = questionid;
    }

    public Answer(String answerid, String questionid, String text, String author) {
        super(text, author);
        this.questionid = questionid;
        this.answerid = answerid;
    }

    public String getQuestionid() {
        return questionid;
    }

    public String getAnswerid() {
        return answerid;
    }
}
