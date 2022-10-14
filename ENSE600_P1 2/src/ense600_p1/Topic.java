package ense600_p1;

/**
 *
 * @author Leo Jia
 */

import java.util.LinkedHashMap;

public class Topic {

    private String topicName;
    protected LinkedHashMap<String, Question> questions;

    public Topic(String topicName) {
        this.topicName = topicName;
        questions = new LinkedHashMap<>();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

}
