package Project2;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yueli
 */
public class QuestionsView extends JPanel {
    
    private JLabel welcomMessage = new JLabel("Kia ora,you have logged in successfully!");
    private JLabel questionMenu = new JLabel("Would you like to: ");
    private JButton askQuestion = new JButton("Ask a new question");
    private JButton browseQuestions = new JButton("Browse all questions");
    private JButton browseQuesByTopic = new JButton("Browse questions by topic");
    private JButton answerQuestions = new JButton("Answer unanswered questions");
    
   
    public QuestionsView() {
        this.add(welcomMessage);
        this.add(questionMenu);
        this.add(askQuestion);
        this.add(browseQuestions);
        this.add(browseQuesByTopic);
        this.add(answerQuestions);
        this.setVisible(true);
        this.removeAll();
        this.revalidate();
        this.repaint(); 
    } 
    
    public void addActionListener(ActionListener listener) {
        
        this.askQuestion.addActionListener(listener);
        this.browseQuestions.addActionListener(listener);
        this.browseQuesByTopic.addActionListener(listener);
        this.answerQuestions.addActionListener(listener);
        
    }
}
