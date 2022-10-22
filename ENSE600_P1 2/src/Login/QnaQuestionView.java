package Login;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
public class QnaQuestionView extends javax.swing.JFrame {

    public Model model;
    public Question q;

    public QnaQuestionView(Model model, Question q) {
        initComponents();
        this.model = model;
        this.setTitle("ENSE600/COMP603 Q&A APP - View Question by " + q.getAuthor());
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        answerField = new javax.swing.JTextField();
        addAnswer = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        answerList = new java.awt.List();
        questionListLabel = new javax.swing.JLabel();
        questionListLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        logOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ENSE600/COMP603 Q&A APP");

        answerField.setText("Add an answer");
        answerField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answerFieldMouseClicked(evt);
            }
        });

        addAnswer.setActionCommand("addAnswer");
        addAnswer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addAnswer.setLabel("Add Answer");
        addAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnswerActionPerformed(evt);
            }
        });

        question.setColumns(20);
        question.setRows(5);
        jScrollPane1.setViewportView(question);

        questionListLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        questionListLabel.setText("Question");

        questionListLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        questionListLabel1.setText("Answers");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionListLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(addAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(answerList, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(questionListLabel1))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(questionListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(questionListLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerList, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        //Refresh page
        answerField.setText("Ask your question here");
    }//GEN-LAST:event_mainMenuMouseClicked

    private void answerFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerFieldMouseClicked
        if (answerField.getText().contains("Ask your question here")) {
            answerField.setText("");
        }
    }//GEN-LAST:event_answerFieldMouseClicked

    private void addAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnswerActionPerformed
        if (answerField.getText().isEmpty() || answerField.getText().contains("Add an answer")) {
            String msg = "Invalid answer.";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } else {
            String answer = answerField.getText();
            String author = "Josh Sun";
        }
    }//GEN-LAST:event_addAnswerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addAnswer;
    private javax.swing.JTextField answerField;
    private java.awt.List answerList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logOut;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JTextArea question;
    private javax.swing.JLabel questionListLabel;
    private javax.swing.JLabel questionListLabel1;
    // End of variables declaration//GEN-END:variables
}
