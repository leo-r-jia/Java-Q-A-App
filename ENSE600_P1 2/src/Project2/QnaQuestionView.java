package Project2;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo JIA
 * @Student ID: 20115737
 */
public class QnaQuestionView extends javax.swing.JFrame {

    public Model model;
    public Question q;

    public QnaQuestionView(Model model, Question q) {
        initComponents();
        this.q = q;
        this.model = model;
        this.setTitle("ENSE600/COMP603 Q&A APP - View Question by " + q.getAuthor());
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        initialisePage();
    }

    private void initialisePage() {
        questionLabel.setText("<html><p style=\"width:420px\">" + q.toString() + "</p></html>");

        if (q.answers.isEmpty()) {
            answerField.setText("Be the first to answer");
        }
        topicLabel.setText(q.getTopic() + " Question");
        populateAnswerList();
    }

    private void populateAnswerList() {
        answerList.clear();
        for (Answer a : q.answers) {
            answerList.add(a.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topicLabel = new javax.swing.JLabel();
        answerField = new javax.swing.JTextField();
        addAnswer = new java.awt.Button();
        answerList = new java.awt.List();
        answerBoxLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        logOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topicLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        topicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topicLabel.setText("Topic");

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

        answerList.setMaximumSize(new java.awt.Dimension(40, 80));

        answerBoxLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        answerBoxLabel.setText("Answers");

        questionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        questionLabel.setText("jLabel2");

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
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topicLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(addAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(answerList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(answerBoxLabel)
                        .addComponent(questionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(topicLabel)
                .addGap(18, 18, 18)
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(answerBoxLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerList, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerField))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        this.dispose();
        QnaMenuView qm = new QnaMenuView(this.model);
    }//GEN-LAST:event_mainMenuMouseClicked

    private void answerFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerFieldMouseClicked
        if (answerField.getText().contains("Add an answer")
                || answerField.getText().contains("Be the first to answer")) {
            answerField.setText("");
        }
    }//GEN-LAST:event_answerFieldMouseClicked

    private void addAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnswerActionPerformed
        if (answerField.getText().isEmpty() || answerField.getText().contains("Add an answer")
                || answerField.getText().contains("Be the first to answer")) {
            String msg = "Invalid answer.";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } else if (answerField.getText().length() > 119) {
            String msg = "Your answer exceeds maximum allowed characters (120)";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } else {
            String answer = answerField.getText();
            answerField.setText("");
            model.newAnswer(q.getqId(), answer);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            initialisePage();
        }
    }//GEN-LAST:event_addAnswerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addAnswer;
    private javax.swing.JLabel answerBoxLabel;
    private javax.swing.JTextField answerField;
    private java.awt.List answerList;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel topicLabel;
    // End of variables declaration//GEN-END:variables
}
