package Login;

/**
 *
 * @author Leo
 */
public class QnaMenuView extends javax.swing.JFrame {

    public QnaMenuView() {
        initComponents();
        this.setTitle("ENSE600/COMP603 QNA APP");
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        questionField = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        button1 = new java.awt.Button();
        topicField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        browseQuestions = new javax.swing.JMenu();
        browseTopics = new javax.swing.JMenu();
        logOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ENSE600/COMP603 QNA APP");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        questionField.setText("Ask your question here");
        questionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionFieldMouseClicked(evt);
            }
        });

        jCheckBox1.setText(" Unanswered Questions");

        button1.setActionCommand("askQuestion");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button1.setLabel("Ask Question");

        topicField.setText("Topic");

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
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(topicField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(topicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QnaMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu browseQuestions;
    private javax.swing.JMenu browseTopics;
    private java.awt.Button button1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logOut;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JTextField questionField;
    private javax.swing.JTextField topicField;
    // End of variables declaration//GEN-END:variables
}
