/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.Observable;

/**
 *
 * @author Katie LI and Leo JIA
 * @Student ID:18003055 and 20115737
 */
public class Model extends Observable {

    public QnaDatabase qnaDb;
    public LoginDatabase db;

    public QuestionData questionData;
    public LoginData data = new LoginData();

    public String userID;
    public String username;

    public Model() {
        this.db = new LoginDatabase();
        this.db.dbsetup();

        this.qnaDb = new QnaDatabase();
        this.qnaDb.setup();

        this.initialiseQuestionData();
    }

    public void initialiseQuestionData() {
        questionData = new QuestionData();
        qnaDb.initialiseQuestions(questionData);
        qnaDb.initialiseAnswers(questionData);
    }

    //Compare userID and password with that inside db.
    public void loginAcc(String userID, String password) {
        this.userID = userID;
        this.data = this.db.loginAcc(userID, password);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    //generate a new account and write back to db
    public void createNewAcc(String userID, String userName, String password) {
        this.userID = userID;
        this.db.createNewAccount(userID, password, userName);

        this.setChanged();
        this.notifyObservers(this.data);
    }

    //add the new password back to db
    public void resetPassword(String userID, String newPassword) {
        this.userID = userID;
        this.db.resetPassword(userID, newPassword);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    //delete the information which matching with the userID in db
    public void deleteAcc(String userID) {
        this.userID = userID;
        this.db.deleteAcc(userID);
        this.setChanged();
        this.notifyObservers(this.data);

    }

    //update data in db
    public void quitSystem() {
        this.db.quitSystem();
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void newQuestion(String question, String topic) {
        question = question.replace("'", "''");
        Question newQuestion = new Question(question, this.username, topic);
        qnaDb.insertQuestion(newQuestion);
        initialiseQuestionData();
    }

    public void newAnswer(String questionid, String answer) {
        questionid = questionid.replace("'", "''");
        answer = answer.replace("'", "''");
        Answer newAnswer = new Answer(questionid, answer, this.username);
        qnaDb.insertAnswer(newAnswer);
        initialiseQuestionData();
    }

    public void deleteQuestion(Question q) {
        qnaDb.deleteQuestion(q.getqId().replace("'", "''"));
        initialiseQuestionData();
    }

    public void deleteAnswer(Answer a) {
        qnaDb.deleteQuestion(a.getAnswerid().replace("'", "''"));
        initialiseQuestionData();
    }
}
