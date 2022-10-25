package Project2;

import java.util.UUID;

/**
 *
 * @author Leo JIA
 * @Student ID: 20115737
 */
//Answer class
public class Answer extends Text {

    private String questionid;
    private String answerid;

    //Default constructor for Answer
    public Answer(String questionid, String text, String author) {
        super(text, author);
        this.answerid = UUID.randomUUID().toString();
        this.questionid = questionid;
    }
    
    //Default constructor for Answer when reading from Database   
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
