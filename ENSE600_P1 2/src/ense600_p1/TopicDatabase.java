package ense600_p1;

import java.util.ArrayList;

/**
 *
 * @author Leo Jia
 */
//Class that implements Database and holds a ArrayList of topics
public class TopicDatabase implements Database {

    protected ArrayList<Topic> topics;
    protected QuestionDatabase qdb;

    //Default constructor
    public TopicDatabase(QuestionDatabase qdb) {
        topics = new ArrayList<Topic>();
        this.qdb = qdb;
    }

    //Initialize Database method that populates topics
    @Override
    public void initializeDatabase() {
        topics = new ArrayList<Topic>();
        qdb.questions.forEach((key, q) -> {
            boolean added = false;
            for (Topic t : topics) {
                if (q.getTopic().trim().equalsIgnoreCase(t.getTopicName())) {
                    t.questions.put(key, q);
                    added = true;
                }
            }
            if (!added) {
                Topic newT = new Topic(q.getTopic());
                newT.questions.put(key, q);
                topics.add(newT);
            }
        });
    }
}
