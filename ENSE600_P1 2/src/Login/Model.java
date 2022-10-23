/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.Observable;

/**
 *
 * @author Katie and Leo
 */
public class Model extends Observable {

    public QnaDatabase qnaDb;
    public LoginDatabase loginDb;
    
    public QuestionData questionData;
    public Data data = new Data();

    public String userID;
    public String username;

    public Model() {
        this.loginDb = new LoginDatabase();
        this.loginDb.dbsetup();

        this.qnaDb = new QnaDatabase();
        this.qnaDb.setup();

        questionData = new QuestionData();
        qnaDb.initialiseQuestions(questionData);
    }

    public void checkName(String userID, String password) {
        this.userID = userID;
        this.data = this.loginDb.checkName(userID, password);

        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void createNewAcc(String userID, String userName, String password) {
        this.userID = userID;
        this.loginDb.createNewAccount(userID, password, userName);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void quitSystem() {
        this.loginDb.quitSystem();
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void newQuestion(String question, String topic) {
        question = question.replace("'", "''");
        topic = topic.replace("'", "''");
        Question newQuestion = new Question(question, this.username, topic);
        qnaDb.insertQuestion(newQuestion);
    }
}
