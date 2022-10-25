package ense600_p1;

/**
 *
 * @author Leo Jia
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

//QuestionDatabase class, that implements Database and holds a LinkedHashMap of questions
public class QuestionDatabase implements Database {

    protected LinkedHashMap<String, Question> questions;
    protected String filename;

    //Default constructor
    public QuestionDatabase(String filename) {
        questions = new LinkedHashMap<>();
        this.filename = filename;
    }

    //Initialize database method that populates questions, reading from a file
    @Override
    public void initializeDatabase() {
        FileInputStream fin;
        try {
            fin = new FileInputStream(filename);
            Scanner fileScanner = new Scanner(fin);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, "|", false);
                Question q = new Question(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                while (st.hasMoreTokens()) {
                    q.answers.add(new Answer(st.nextToken(), st.nextToken()));
                }
                questions.put(q.getqId(), q);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Writes database of questions back to file
    public void updateDatabase() {
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            PrintWriter pw = new PrintWriter(fo);
            for (Question q : this.questions.values()) {
                String answers = "";
                for (Answer a : q.answers) {
                    answers = answers + "|" + a.getText() + "|" + a.getAuthor();
                }
                pw.println(q.getqId() + "|" + q.getText() + "|" + q.getAuthor() + "|" + q.getTopic() + answers);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
