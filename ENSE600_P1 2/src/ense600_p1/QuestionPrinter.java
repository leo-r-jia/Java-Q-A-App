package ense600_p1;

/**
 *
 * @author Leo Jia
 */

//Class that prints individual questions
public class QuestionPrinter implements Printer {

    //Method that prints a question and its answers. Prints a default string if 
    //there are no answers yet
    public void printQuestion(Question q) {
        if (q.answers.isEmpty()) {
            System.out.println("Q: " + q.getText() + " (" + q.getAuthor() + ")");
            System.out.println("(No answers yet, be the first to answer)\n\n");
        } else {
            System.out.println("Q: " + q.getText() + " (" + q.getAuthor() + ")");
            for (Answer a : q.answers) {
                System.out.println("A: " + a.getText() + " (" + a.getAuthor() + ")");
            }
            System.out.println("\n");
        }
    }
}
