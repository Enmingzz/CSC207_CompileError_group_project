package app;

import interface_adapter.LoginViewModel;
import interface_adapter.SignupViewModel;
import interface_adapter.ViewManagerModel;
import view.*;

import javax.swing.*;
import java.awt.*;

/**
 * The entrance for the whole program. Run this to start using.
 */

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("CSC207 Project");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setSize(800, 600);
        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel);
        TestView testView = new TestView();
        views.add(signupView.viewName, signupView);
        views.add(testView.viewName, testView);


        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
