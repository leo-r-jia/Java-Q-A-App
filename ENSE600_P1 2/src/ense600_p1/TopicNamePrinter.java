package ense600_p1;

/**
 *
 * @author Leo Jia
 */
//Class that prints the names of the topics
public class TopicNamePrinter implements Printer {

    static int index = 1;

    //Method that prints names of topics with questions under them, and an index
    public void printTopicNames(TopicDatabase tdb) {
        index = 1;
        for (Topic t : tdb.topics) {
            System.out.println("(" + index + ") " + t.getTopicName());
            index++;
        }
    }
}
