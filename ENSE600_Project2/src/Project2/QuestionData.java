package Project2;

import java.util.LinkedHashMap;

/**
 *
 * @author Leo JIA
 * @Student ID: 20115737
 */
public class QuestionData {

    //LinkedHashMap of questions with questionid as key
    protected LinkedHashMap<String, Question> questions;
    
    public QuestionData() {
        questions = new LinkedHashMap<>();
    }
}
