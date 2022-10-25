package Project2;

/**
 *
 * @author Katie LI and Leo JIA
 * @Student ID:18003055 and 20115737
 */
public class Main {

    public static void main(String[] args) {
        LoginView view = new LoginView();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        view.m = model;
        model.addObserver(view);
    }
}
