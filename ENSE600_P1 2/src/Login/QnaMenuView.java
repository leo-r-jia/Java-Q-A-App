package Login;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
public class QnaMenuView extends javax.swing.JFrame {

    public Model model;

    public QnaMenuView(Model model) {
        initComponents();
        this.model = model;
        this.setTitle("ENSE600/COMP603 Q&A APP - Menu");
        this.setResizable(false);
        loadQuestions("All");
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void loadQuestions(String topic) {
        questionList.clear();
        if (topic.contentEquals("All")) {
            for (Question q : model.questionData.questions.values()) {
                questionList.add(q.toString());
            }
        } else {
            for (Question q : model.questionData.questions.values()) {
                if (q.getTopic().contentEquals(topic)) {
                    questionList.add(q.toString());
                }
            }
        }

    }

    private void loadUnansweredQuestions(String topic) {
        questionList.clear();
        if (topic.contentEquals("All")) {
            for (Question q : model.questionData.questions.values()) {
                if (q.answers.isEmpty()) {
                    questionList.add(q.toString());
                }
            }
        } else {
            for (Question q : model.questionData.questions.values()) {
                if (q.answers.isEmpty() && q.getTopic().contentEquals(topic)) {
                    questionList.add(q.toString());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        unansweredQuestionsFilter = new javax.swing.JCheckBox();
        askQuestion = new java.awt.Button();
        questionList = new java.awt.List();
        questionListLabel = new javax.swing.JLabel();
        topicSelector = new javax.swing.JComboBox<>();
        topicFilter = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        logOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ENSE600/COMP603 Q&A APP");

        questionField.setText("Ask your question here");
        questionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionFieldMouseClicked(evt);
            }
        });

        unansweredQuestionsFilter.setText(" Unanswered Questions");
        unansweredQuestionsFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unansweredQuestionsFilterActionPerformed(evt);
            }
        });

        askQuestion.setActionCommand("askQuestion");
        askQuestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        askQuestion.setLabel("Ask Question");
        askQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                askQuestionActionPerformed(evt);
            }
        });

        questionList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        questionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionListMouseClicked(evt);
            }
        });

        questionListLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        questionListLabel.setText("Questions");

        topicSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Assignment 1", "Assignment 2", "Labs", "Lectures" }));

        topicFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "General", "Assignment 1", "Assignment 2", "Labs", "Lectures" }));
        topicFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topicFilterActionPerformed(evt);
            }
        });

        jLabel2.setText("Filter:");

        mainMenu.setText("Main Menu");
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(mainMenu);

        logOut.setText("Logout");
        jMenuBar1.add(logOut);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(questionListLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topicFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(unansweredQuestionsFilter))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(topicSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(askQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(questionList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(topicSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(askQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unansweredQuestionsFilter)
                    .addComponent(questionListLabel)
                    .addComponent(topicFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(questionList, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        //Refresh page
        questionField.setText("Ask your question here");
    }//GEN-LAST:event_mainMenuMouseClicked

    private void questionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionFieldMouseClicked
        if (questionField.getText().contains("Ask your question here")) {
            questionField.setText("");
        }
    }//GEN-LAST:event_questionFieldMouseClicked

    private void askQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_askQuestionActionPerformed
        if (questionField.getText().isEmpty() || questionField.getText().contains("Ask your question here")) {
            String msg = "Invalid question.";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } else if (questionField.getText().length() > 119) {
            String msg = "Your question exceeds maximum allowed characters (120)";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } else {
            String question = questionField.getText();
            String author = "Josh Sun";
            String topic = (String) topicSelector.getSelectedItem();
            Question q = new Question(question, author, topic);
            model.qnaDb.insertQuestion(q);
            model.qnaDb.initialiseQuestions(model.questionData);
            loadQuestions((String) topicFilter.getSelectedItem());
        }
    }//GEN-LAST:event_askQuestionActionPerformed

    private void questionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionListMouseClicked
        String questionText = questionList.getSelectedItem();
        Question selectedQuestion = null;
        for (Question q : model.questionData.questions.values()) {
            if (q.toString().equals(questionText)) {
                selectedQuestion = q;
            }
        }
        String msg = selectedQuestion.toString();
        JOptionPane.showMessageDialog(null, msg, "Question", HEIGHT);
    }//GEN-LAST:event_questionListMouseClicked

    private void unansweredQuestionsFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unansweredQuestionsFilterActionPerformed
        if (unansweredQuestionsFilter.isSelected()) {
            loadUnansweredQuestions((String) topicFilter.getSelectedItem());
        } else {
            loadQuestions((String) topicFilter.getSelectedItem());
        }
    }//GEN-LAST:event_unansweredQuestionsFilterActionPerformed

    private void topicFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topicFilterActionPerformed
        loadQuestions((String) topicFilter.getSelectedItem());
    }//GEN-LAST:event_topicFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button askQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JTextField questionField;
    private java.awt.List questionList;
    private javax.swing.JLabel questionListLabel;
    private javax.swing.JComboBox<String> topicFilter;
    private javax.swing.JComboBox<String> topicSelector;
    private javax.swing.JCheckBox unansweredQuestionsFilter;
    // End of variables declaration//GEN-END:variables
}
