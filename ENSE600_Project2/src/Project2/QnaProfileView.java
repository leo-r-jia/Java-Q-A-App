package Project2;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo JIA
 * @Student ID: 20115737
 */
public class QnaProfileView extends javax.swing.JFrame {

    public Model model;
    public Question q;

    //Constructor for Profile View
    public QnaProfileView(Model model) {
        initComponents();
        this.q = q;
        this.model = model;
        this.setTitle("ENSE600/COMP603 Q&A APP - View Profile");
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        initialisePage();
    }

    //Setup GUI
    private void initialisePage() {
        for (Question q : model.questionData.questions.values()) {
            if (q.getAuthor().equals(model.loginData.username)) {
                questionList.add(q.getText());
            }
        }
        if (model.loginData.isAdmin) {
            this.usernameTitle.setText(model.loginData.username + " (Admin)");
        } else {
            this.usernameTitle.setText(model.loginData.username);
        }

        this.userIdLabel.setText("User ID: " + model.loginData.userid);
        this.usernameLabel.setText("Username: " + model.loginData.username);
        this.passwordLabel.setText("Password: " + model.loginData.password);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameTitle = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        questionListLabel = new javax.swing.JLabel();
        questionList = new java.awt.List();
        deleteAccount = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        profile = new javax.swing.JMenu();
        logOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usernameTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        usernameTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usernameTitle.setText("User Name");

        userIdLabel.setText("User ID:");

        usernameLabel.setText("Username:");

        passwordLabel.setText("Password:");

        questionListLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        questionListLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionListLabel.setText("My Questions");

        questionList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        questionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionListMouseClicked(evt);
            }
        });

        deleteAccount.setActionCommand("");
        deleteAccount.setLabel("Delete Account");
        deleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountActionPerformed(evt);
            }
        });

        mainMenu.setText("Main Menu");
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(mainMenu);

        profile.setText("Profile");
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jMenuBar1.add(profile);

        logOut.setText("Logout");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logOut);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionListLabel)
                    .addComponent(passwordLabel)
                    .addComponent(usernameLabel)
                    .addComponent(userIdLabel)
                    .addComponent(usernameTitle)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(deleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(questionList, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(usernameTitle)
                .addGap(18, 18, 18)
                .addComponent(userIdLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addGap(50, 50, 50)
                .addComponent(questionListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionList, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(deleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Main menu clicked, go back to main menu
    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        this.dispose();
        if (model.loginData.isAdmin) {
            new QnaAdminMenuView(this.model);
        } else {
            new QnaMenuView(this.model);
        }
    }//GEN-LAST:event_mainMenuMouseClicked

    //Log out button clicked
    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        String msg = "Are you sure you want to log out? ";
        int result = JOptionPane.showConfirmDialog(null, msg, "Confirm Log Out", HEIGHT);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            new App();
        }
    }//GEN-LAST:event_logOutMouseClicked

    //If question pressed, load question view
    private void questionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionListMouseClicked
        String questionText = questionList.getSelectedItem();
        Question selectedQuestion = null;
        for (Question q : model.questionData.questions.values()) {
            if (q.getText().equals(questionText)) {
                selectedQuestion = q;
            }
        }
        if (selectedQuestion != null) {
            this.dispose();
            if (model.loginData.isAdmin) {
                new QnaQuestionAdminView(this.model, selectedQuestion);
            } else {
                QnaQuestionView qv = new QnaQuestionView(this.model, selectedQuestion);
            }
        }
    }//GEN-LAST:event_questionListMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        this.dispose();
        new QnaProfileView(model);
    }//GEN-LAST:event_profileMouseClicked

    private void deleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountActionPerformed
        String msg = "Are you sure you want to delete your account?";
        int result = JOptionPane.showConfirmDialog(null, msg, "Confirm Delete Account", HEIGHT);
        if (result == JOptionPane.YES_OPTION) {
            this.model.deleteAcc(model.loginData.userid);
            this.dispose();
            new App();
        }
    }//GEN-LAST:event_deleteAccountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button deleteAccount;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JMenu profile;
    private java.awt.List questionList;
    private javax.swing.JLabel questionListLabel;
    private javax.swing.JLabel userIdLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameTitle;
    // End of variables declaration//GEN-END:variables
}
