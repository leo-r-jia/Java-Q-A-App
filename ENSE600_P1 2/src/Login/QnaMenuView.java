package Login;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
public class QnaMenuView extends javax.swing.JFrame {

    public Model model;

    public QnaMenuView() {
        initComponents();
        this.model = new Model();
        this.setTitle("ENSE600/COMP603 QNA APP");
        this.setResizable(false);
        loadQuestions();
    }

    private void loadQuestions() {
        int i = 0;
        for (Question q : model.questionData.questions.values()) {
            questionList.add(q.toString(), i);
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        askQuestion = new java.awt.Button();
        questionList = new java.awt.List();
        questionListLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        browseQuestions = new javax.swing.JMenu();
        browseTopics = new javax.swing.JMenu();
        logOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ENSE600/COMP603 QNA APP");

        questionField.setText("Ask your question here");
        questionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionFieldMouseClicked(evt);
            }
        });

        jCheckBox1.setText(" Unanswered Questions");

        askQuestion.setActionCommand("askQuestion");
        askQuestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        askQuestion.setLabel("Ask Question");
        askQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                askQuestionActionPerformed(evt);
            }
        });

        questionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionListMouseClicked(evt);
            }
        });

        questionListLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        questionListLabel.setText("Questions");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        mainMenu.setText("Main Menu");
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(mainMenu);

        browseQuestions.setText("Browse Questions");
        browseQuestions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseQuestionsMouseClicked(evt);
            }
        });
        jMenuBar1.add(browseQuestions);

        browseTopics.setText("Browse Topics");
        browseTopics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseTopicsMouseClicked(evt);
            }
        });
        jMenuBar1.add(browseTopics);

        logOut.setText("Logout");
        jMenuBar1.add(logOut);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(118, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(questionListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(askQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(questionList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(askQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(questionListLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionList, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        //Refresh page
        questionField.setText("Ask your question here");
    }//GEN-LAST:event_mainMenuMouseClicked

    private void browseQuestionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseQuestionsMouseClicked
        this.dispose();
    }//GEN-LAST:event_browseQuestionsMouseClicked

    private void questionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionFieldMouseClicked
        questionField.setText("");
    }//GEN-LAST:event_questionFieldMouseClicked

    private void browseTopicsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseTopicsMouseClicked
        this.dispose();
    }//GEN-LAST:event_browseTopicsMouseClicked

    private void askQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_askQuestionActionPerformed
        if (questionField.getText().isEmpty() || questionField.getText().contains("Ask your question here")) {
            String msg = "Invalid question.";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } else {
//            Question q = new Question();
        }
    }//GEN-LAST:event_askQuestionActionPerformed

    private void questionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionListMouseClicked
        int index = questionList.getSelectedIndex();
        Question q = model.questionData.questions.get(index);
        String msg = q.toString();
        JOptionPane.showMessageDialog(null, msg, "Question", HEIGHT);
    }//GEN-LAST:event_questionListMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QnaMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button askQuestion;
    private javax.swing.JMenu browseQuestions;
    private javax.swing.JMenu browseTopics;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JTextField questionField;
    private java.awt.List questionList;
    private javax.swing.JLabel questionListLabel;
    // End of variables declaration//GEN-END:variables
}
