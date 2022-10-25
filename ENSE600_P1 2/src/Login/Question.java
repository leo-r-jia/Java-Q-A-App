package Login;

/**
 *
 * @author Leo Jia
 */
import java.util.HashSet;
import java.util.UUID;

//Question class that holds text, author, topic, and HashSet of answers
public class Question extends Text {

    HashSet<Answer> answers;
    private String qId;
    private String topic;

    //Default constructor for new question
    public Question(String text, String author, String topic) {
        super(text, author);
        this.answers = new HashSet<Answer>();
        this.qId = UUID.randomUUID().toString();
        this.topic = topic;
    }

    //Constructor when initializing database
    public Question(String qId, String text, String author, String topic) {
        super(text, author);
        this.answers = new HashSet<Answer>();
        this.qId = qId;
        this.topic = topic;
    }

    //toString method
    public String toString() {
        return getText() + "   (" + getAuthor() + ")";
    }

    //Get methds for Id and Topic
    public String getqId() {
        return qId;
    }

    public String getTopic() {
        return topic;
    }

}
