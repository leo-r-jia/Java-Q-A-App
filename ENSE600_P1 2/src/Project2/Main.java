package Project2;

/**
 *
 * @author yueli
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
